package co.edu.eam.sd.circuitbreaker.model.api.responses;

import java.io.Serializable;

public class ProductResponse implements Serializable {

  private Integer productId;

  private String productName;

  private Integer categoryId;

  public ProductResponse() {
  }

  public ProductResponse(Integer productId, String productName, Integer categoryId) {
    this.productId = productId;
    this.productName = productName;
    this.categoryId = categoryId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }
}
