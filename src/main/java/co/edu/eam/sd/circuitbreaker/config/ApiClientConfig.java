package co.edu.eam.sd.circuitbreaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class ApiClientConfig {

  @Bean
  public Retrofit catalogApiConfig(){
    return new Retrofit.Builder()
            .baseUrl(Constants.CATALOG_BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
  }

}
