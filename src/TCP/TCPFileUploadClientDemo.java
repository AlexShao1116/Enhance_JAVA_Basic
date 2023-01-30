package TCP;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class TCPFileUploadClientDemo {

        public static void main(String[] args) throws Exception {
            //1.新建一个Socket连接
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            //2.创建一个输出流
            OutputStream os = socket.getOutputStream();
            //3.读取文件
            FileInputStream fis = new FileInputStream(new File("th.jpg"));
            //4.写出文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);   // 写出文件
            }

            //通知服务器我传输结束了
            socket.shutdownOutput(); //传输完了

            //确定服务器接收完，才能够断开连接
            InputStream is = socket.getInputStream();
            //String<==>byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString()); //转为字符串

            //关闭连接
            baos.close();
            is.close();
            fis.close();
            os.close();
            socket.close();
        }
}
