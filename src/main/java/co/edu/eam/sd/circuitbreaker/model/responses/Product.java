package co.edu.eam.sd.circuitbreaker.model.responses;

public class Product {

  private String name;

  private String id;

  private Category category;

  public Product() {
  }

  public Product(String name, String id, Category category) {
    this.name = name;
    this.id = id;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
