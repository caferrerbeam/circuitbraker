package co.edu.eam.sd.circuitbreaker.api.definitions;

import co.edu.eam.sd.circuitbreaker.config.Constants;
import co.edu.eam.sd.circuitbreaker.model.api.responses.CategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryAPI {

  @GET("/categories/{id}")
  Call<CategoryResponse> getCategory(@Path("id") Long id);

}
