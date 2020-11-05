package co.edu.eam.sd.circuitbreaker.api.definitions;

import co.edu.eam.sd.circuitbreaker.config.Constants;
import co.edu.eam.sd.circuitbreaker.model.api.responses.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ProductAPI {

  @GET(Constants.CATALOG_BASE_URL + "/products/{id}")
  Call<ProductResponse> getProduct(@Path("id") Long id);

  @GET(Constants.CATALOG_BASE_URL + "/products")
  Call<List<ProductResponse>> getProducts();

}
