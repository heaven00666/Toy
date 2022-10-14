package Oct.tcp;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hs
 * @version 1.0
 * Create by 2022/10/14 9:36
 */

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(6666);
        System.out.println("server is running……");
        for (;;){
            Socket socket = ss.accept();
            socket.setTcpNoDelay(false);//设置服务端开启Nagle算法,true关闭
            Thread t = new Handler(socket);
            t.start();
        }
    }
}
