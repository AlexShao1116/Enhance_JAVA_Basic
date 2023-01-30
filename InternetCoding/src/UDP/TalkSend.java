package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
    DatagramSocket socket = null;
    BufferedReader reader = null;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
    }

    private int fromPort;
    private String toIP;
    private int toPort;


    @Override
    public void run() {
        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String data = null;
            try {
                data = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(toIP,toPort));

            try {
                socket.send(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(data.equals("bye")){
                break;
            }
        }
    }
}
