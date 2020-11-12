package co.edu.eam.sd.circuitbreaker.services;


import co.edu.eam.sd.circuitbreaker.api.clients.CategoryClient;
import co.edu.eam.sd.circuitbreaker.api.clients.ProductClient;
import co.edu.eam.sd.circuitbreaker.model.api.responses.CategoryResponse;
import co.edu.eam.sd.circuitbreaker.model.api.responses.ProductResponse;
import co.edu.eam.sd.circuitbreaker.model.responses.Category;
import co.edu.eam.sd.circuitbreaker.model.responses.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService {

  @Autowired
  private CategoryClient categoryClient;

  @Autowired
  private ProductClient productClient;


  public Product getProduct(Long id) throws IOException {
    ProductResponse productResponse = productClient.getProduct(id);
    CategoryResponse catRes = categoryClient.getCategory(productResponse.getCategoryId().longValue());

    Category category = new Category(catRes.getName(), catRes.getId().longValue());

    return new Product(productResponse.getProductName(), productResponse.getProductId().toString(), category);
  }
}
