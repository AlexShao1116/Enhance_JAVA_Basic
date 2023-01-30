package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        //���Ŷ˿�
        DatagramSocket socket = new DatagramSocket(9090);

        //�������ݰ�
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet); //��������

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength())); //byte[]->String
        socket.close();
    }
}

