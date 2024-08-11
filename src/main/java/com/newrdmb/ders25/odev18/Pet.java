package com.newrdmb.ders25.odev18;

import lombok.Data;

import java.util.List;

@Data
public class Pet {
  private long id;
  private String name;
  private String status;
  private Category category;
  private List<String> photoUrls;
  private List<Tag> tags;  //

  @Data
  public static class Category {
    private long id;
    private String name;
  }

  @Data
  public static class Tag {
    private long id;
    private String name;
  }
}
