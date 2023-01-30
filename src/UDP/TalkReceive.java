package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    DatagramSocket socket = null;

    public TalkReceive(int port,String msgfrom) {
        this.port = port;
        this.msgfrom = msgfrom;
        {
            try {
                socket = new DatagramSocket(port);
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int port;
    private String msgfrom;




    @Override
    public void run() {
        while(true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            byte[] data = packet.getData();
            String receiveData = new String(data,0,data.length);
            System.out.println(msgfrom+":"+receiveData);
            if(receiveData.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
