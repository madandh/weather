package com.weather;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    Application app = new Application();
   // app.disableCertificateVerification();
  }

  private void disableCertificateVerification() {
    TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
      }

      @Override
      public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
          throws CertificateException {
      }

      @Override
      public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
          throws CertificateException {
      }
    }};

    try {
      SSLContext sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
      HostnameVerifier allHostsValid = new HostnameVerifier() {
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
          // TODO Auto-generated method stub
          return true;
        }
      };
      HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
      HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> hostname.equals(
          ""));
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      e.printStackTrace();
    }
  }

}
