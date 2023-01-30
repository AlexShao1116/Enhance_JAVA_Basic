package TCP;
import java.io.OutputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPFileUploadServerDemo {
        public static void main(String[] args) throws IOException {
            //1.�����������˿�
            ServerSocket serverSocket = new ServerSocket(9000);
            //2.�ȴ��û�����
            Socket socket = serverSocket.accept();
            //3.��ȡ������
            InputStream is = socket.getInputStream();

            //4.�ļ����
            FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }


            //֪ͨ�ͻ��˽������
            OutputStream os = socket.getOutputStream();
            os.write("������ϣ����ԶϿ�������".getBytes());

            //�ر���������
            os.close();
            fos.close();
            is.close();
            socket.close();
            serverSocket.close();
        }
}
