package UDP;


import java.net.*;

//����Ҫ���ӷ�����
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.�½�һ��Socket
        DatagramSocket socket = new DatagramSocket();

        //2.������ DatagramPacket
        String msg="��ã���������";
        InetAddress address = InetAddress.getByName("localhost");
        int port=9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, address, port);

        //3.���Ͱ�
        socket.send(packet);

        socket.close();
    }
}
