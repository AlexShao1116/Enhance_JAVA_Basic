package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        //1.Ҫ֪���������ĵ�ַ���˿ں�
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 9999;
        //2.����һ��Socket����
        Socket socket = new Socket(address, port);
        //3.������Ϣ
        OutputStream os = socket.getOutputStream();
        os.write("Hello World".getBytes()); //�����ֽ����飨��String����Ϊ�ֽ����� �浽�ֽ����飩

//�ر�����
        os.close();
        socket.close();

    }

}
