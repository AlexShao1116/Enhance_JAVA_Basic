package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        //1.要知道服务器的地址，端口号
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 9999;
        //2.创建一个Socket连接
        Socket socket = new Socket(address, port);
        //3.发送消息
        OutputStream os = socket.getOutputStream();
        os.write("Hello World".getBytes()); //返回字节数组（将String编码为字节序列 存到字节数组）

//关闭连接
        os.close();
        socket.close();

    }

}
