package com.mitix.len.serial.jdk;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * @author oldflame-jm
 * @since 1.0.0
 */


public class HttpClientUtil {

    public static void main(String[] args) throws IOException {
        String url = "https://api-geometry.mitix.com";
        HttpClientUtil.doGet(url);
    }

    @SuppressWarnings("resource")
    public static void doGet(String url) throws IOException {
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        // 设置参数
        HttpResponse res = null;
        try {
            httpClient = new SSLClient();
            httpGet = new HttpGet(url);
            res = httpClient.execute(httpGet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(IOUtils.toString(res.getEntity().getContent(), "utf-8"));
    }

    private static class SSLClient extends DefaultHttpClient {
        public SSLClient() throws Exception {
            super();
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = this.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));
        }
    }
}