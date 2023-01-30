package URLDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws IOException {
        //1.���ص�ַ������д�Լ����µ���Դ���ӣ�
        URL url = new URL("https://m801.music.126.net/20220728121358/66e85231ec0f3ccaeceb346a33189703/jdyyaac/035c/060b/0308/46bd66df5e1a7a58519c4bb1b7c2cb9f.m4a");

        //2.���ӵ������Դ HTTP0
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("mine.m4a");
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len); //д��������ݵ��ļ�
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect(); //�Ͽ�����
    }
}
