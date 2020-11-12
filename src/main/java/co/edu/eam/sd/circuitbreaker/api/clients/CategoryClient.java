package co.edu.eam.sd.circuitbreaker.api.clients;

import co.edu.eam.sd.circuitbreaker.api.definitions.CategoryAPI;
import co.edu.eam.sd.circuitbreaker.model.api.responses.CategoryResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class CategoryClient {

  @Autowired
  private Retrofit catalogApiConfig;

  //@Cacheable(cacheNames = "category", key = "#id", unless="#result == null")
  @HystrixCommand(fallbackMethod = "fallBackCategory")
  public CategoryResponse getCategory(Long id) throws IOException {
    System.out.println("ORIGINALLLLLLLLLL-------------------");

    CategoryAPI api = catalogApiConfig.create(CategoryAPI.class);

    Call<CategoryResponse> request = api.getCategory(id);

    Response<CategoryResponse> response = request.execute();

      if (!response.isSuccessful()) {
        throw new RuntimeException("api error");
      }

      return response.body();
  }

  public CategoryResponse fallBackCategory(Long id) {

    System.out.println("FALLBACKKKKKKKKKK");

    return new CategoryResponse(id.intValue(), "");
  }
}
