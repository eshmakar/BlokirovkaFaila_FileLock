package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class BlockinFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream out = new FileOutputStream("fil15.txt"); //блокируемый файлы
        FileLock f1 = out.getChannel().lock();//блокируем этот файл с помощью FileLock (можно использовать метод lock, или tryLock)
        if (f1 != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(10000);//после 10 секунд
            f1.release();//разблокируем файл обратно
            System.out.println("Released LOCK");
        }
        out.close();
    }
}
