package TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCOServerDemo {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        //1.创建服务端 端口
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                //2.等待客户端连接
                socket = serverSocket.accept();
                //3.读取客户端的消息
                is = socket.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024]; //新建缓冲区
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString()); //打印信息

                //管道流(过滤一下，防止中文乱码)

            }
        }catch (Exception e) {
                throw new RuntimeException(e);
        }finally {
            try {
                baos.close();
                is.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }




//关闭连接，先开后关

    }
}
