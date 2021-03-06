package co.edu.eam.sd.circuitbreaker.api.clients;

import co.edu.eam.sd.circuitbreaker.api.definitions.CategoryAPI;
import co.edu.eam.sd.circuitbreaker.model.api.responses.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class CategoryClient {

  @Autowired
  private Retrofit catalogApiConfig;

  public CategoryResponse getCategory(Long id) throws IOException {
    CategoryAPI api = catalogApiConfig.create(CategoryAPI.class);

    Call<CategoryResponse> request = api.getCategory(id);

    return request.execute().body();
  }
}
