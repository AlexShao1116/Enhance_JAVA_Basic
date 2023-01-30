package TCP;
import java.io.OutputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPFileUploadServerDemo {
        public static void main(String[] args) throws IOException {
            //1.创建服务器端口
            ServerSocket serverSocket = new ServerSocket(9000);
            //2.等待用户连接
            Socket socket = serverSocket.accept();
            //3.获取输入流
            InputStream is = socket.getInputStream();

            //4.文件输出
            FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }


            //通知客户端接收完毕
            OutputStream os = socket.getOutputStream();
            os.write("接收完毕，可以断开连接了".getBytes());

            //关闭所有连接
            os.close();
            fos.close();
            is.close();
            socket.close();
            serverSocket.close();
        }
}
