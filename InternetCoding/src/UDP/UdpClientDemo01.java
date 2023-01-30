package UDP;


import java.net.*;

//不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.新建一个Socket
        DatagramSocket socket = new DatagramSocket();

        //2.建个包 DatagramPacket
        String msg="你好，服务器！";
        InetAddress address = InetAddress.getByName("localhost");
        int port=9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, address, port);

        //3.发送包
        socket.send(packet);

        socket.close();
    }
}
