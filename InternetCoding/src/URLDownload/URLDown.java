package URLDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws IOException {
        //1.下载地址（可以写自己想下的资源链接）
        URL url = new URL("https://m801.music.126.net/20220728121358/66e85231ec0f3ccaeceb346a33189703/jdyyaac/035c/060b/0308/46bd66df5e1a7a58519c4bb1b7c2cb9f.m4a");

        //2.连接到这个资源 HTTP0
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("mine.m4a");
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len); //写出这个数据到文件
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect(); //断开连接
    }
}
