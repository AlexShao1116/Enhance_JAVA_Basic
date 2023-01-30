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

        //1.��������� �˿�
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                //2.�ȴ��ͻ�������
                socket = serverSocket.accept();
                //3.��ȡ�ͻ��˵���Ϣ
                is = socket.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024]; //�½�������
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString()); //��ӡ��Ϣ

                //�ܵ���(����һ�£���ֹ��������)

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




//�ر����ӣ��ȿ����

    }
}
