package TCP;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class TCPFileUploadClientDemo {

        public static void main(String[] args) throws Exception {
            //1.�½�һ��Socket����
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            //2.����һ�������
            OutputStream os = socket.getOutputStream();
            //3.��ȡ�ļ�
            FileInputStream fis = new FileInputStream(new File("th.jpg"));
            //4.д���ļ�
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);   // д���ļ�
            }

            //֪ͨ�������Ҵ��������
            socket.shutdownOutput(); //��������

            //ȷ�������������꣬���ܹ��Ͽ�����
            InputStream is = socket.getInputStream();
            //String<==>byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString()); //תΪ�ַ���

            //�ر�����
            baos.close();
            is.close();
            fis.close();
            os.close();
            socket.close();
        }
}
