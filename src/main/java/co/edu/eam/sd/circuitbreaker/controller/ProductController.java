package co.edu.eam.sd.circuitbreaker.controller;

import co.edu.eam.sd.circuitbreaker.model.responses.Product;
import co.edu.eam.sd.circuitbreaker.services.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/products-ms/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable Long id) throws IOException {
    return productService.getProduct(id);
  }
}
