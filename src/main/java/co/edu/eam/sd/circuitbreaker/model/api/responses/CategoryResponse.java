package co.edu.eam.sd.circuitbreaker.model.api.responses;

import java.io.Serializable;

public class CategoryResponse implements Serializable {

  private Integer id;

  private String name;

  public CategoryResponse() {
  }

  public CategoryResponse(Integer id, String name) {
    this.name = name;
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
