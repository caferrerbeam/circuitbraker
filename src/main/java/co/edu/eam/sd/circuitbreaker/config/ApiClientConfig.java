package co.edu.eam.sd.circuitbreaker.config;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApiClientConfig {

  @Bean
  public Retrofit catalogApiConfig(OkHttpClient client){
    return new Retrofit.Builder()
            .baseUrl(Constants.CATALOG_BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(client)
            .build();
  }

  @Bean
  public OkHttpClient buildClient() {
    SSLContext sslContext;
    TrustManager[] trustManagers;
    try {
      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(null, null);


      InputStream certInputStream = ApiClientConfig.class.getClassLoader().getResourceAsStream("malo.crt");
      BufferedInputStream bis = new BufferedInputStream(certInputStream);

      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      while (bis.available() > 0) {
        Certificate cert = certificateFactory.generateCertificate(bis);
        keyStore.setCertificateEntry("www.example.com", cert);
      }
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init(keyStore);
      trustManagers = trustManagerFactory.getTrustManagers();
      sslContext = SSLContext.getInstance("TLS");
      sslContext.init(null, trustManagers, null);
    } catch (Exception e) {
      e.printStackTrace(); //TODO replace with real exception handling tailored to your needs
      return null;
    }

    OkHttpClient client = new OkHttpClient.Builder()
            .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0])
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            //esto es porque es autofirmado....
            .hostnameVerifier(new HostnameVerifier() {
              @Override
              public boolean verify(String s, SSLSession sslSession) {
                return true;
              }
            })
            .build();

    return client;
  }

}
