package kr.hs.dukyoung.DYApp.jaehoon.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public final class URLRequest {

    private String url;

    public URLRequest(String url) {
        this.url = url;
    }

    public String sendRequest() {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn;
        InputStreamReader in;

        try {
            URL url = new URL(this.url);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
                in.close();
            }
            return sb.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
