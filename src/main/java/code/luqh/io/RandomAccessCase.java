package code.luqh.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author luqh
 * @date 2018/10/16
 **/
public class RandomAccessCase {

    public static void main(String[] args) {



        try {


            RandomAccessFile raf = new RandomAccessFile("D://flume-agent.log", "r");
            FileChannel channel = raf.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);



            int byteRead = channel.read(buf);

            System.out.println(byteRead);

            while (byteRead != -1) {
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }

                buf.compact();

                byteRead = channel.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
