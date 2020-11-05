package co.edu.eam.sd.circuitbreaker.api.clients;

import co.edu.eam.sd.circuitbreaker.api.definitions.CategoryAPI;
import co.edu.eam.sd.circuitbreaker.api.definitions.ProductAPI;
import co.edu.eam.sd.circuitbreaker.model.api.responses.CategoryResponse;
import co.edu.eam.sd.circuitbreaker.model.api.responses.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Component
public class ProductClient {

  @Autowired
  private Retrofit catalogApiConfig;

  @Cacheable(cacheNames = "products", key = "#id")
  public ProductResponse getProduct(Long id) throws IOException {
    ProductAPI api = catalogApiConfig.create(ProductAPI.class);

    Call<ProductResponse> request = api.getProduct(id);

    return request.execute().body();
  }

  public List<ProductResponse> getProducts() throws IOException {
    ProductAPI api = catalogApiConfig.create(ProductAPI.class);

    Call<List<ProductResponse>> request = api.getProducts();

    return request.execute().body();
  }
}
