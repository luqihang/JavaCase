package code.luqh.concurent;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.concurrent.*;

/**
 * @author luqh
 * @date 2018/10/09
 **/
public class ExecutorCase {

    public class ThreadPerTaskExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    private static final int NTHREADS = 2;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
//        ThreadPoolExecutor

        ServerSocket socket = new ServerSocket(80);


        while (true) {
            final Socket conn = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("处理请求");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        OutputStream out = conn.getOutputStream();

                        out.write("hello world".getBytes());
                        out.close();

                        conn.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(task);
        }
    }
}
