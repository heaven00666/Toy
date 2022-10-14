package Oct.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author hs
 * @version 1.0
 * Create by 2022/10/14 9:54
 */

public class Handler extends Thread {
    Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try (InputStream input = this.socket.getInputStream()){
            try (OutputStream output = this.socket.getOutputStream()){
                handle(input,output);
            }
        } catch (Exception e) {
            try {
                this.socket.close();
            }catch (IOException ioe){

            }
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));

        for (;;) {
            String s = reader.readLine();
            int num = 0;
            int sum = 0;
            for (int i = 0;i < s.length();i++){
                char c = s.charAt(i);
                if(c - '0' >= 0 && c - '0' <= 9){
                    num = num*10+(c - '0');
                }else if(c == '+'){
                    sum = sum + num;
                    num = 0;
                }else {
                    writer.write("0");
                    writer.write("\r\n");
                    writer.flush();
                    break;
                }
            }
            sum = sum + num;
            String str = sum + "";
            writer.write(str);
            writer.write("\r\n");
            writer.flush();
        }
    }
}
