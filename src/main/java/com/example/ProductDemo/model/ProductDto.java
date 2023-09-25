package com.example.ProductDemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotNull(message="name not be null")
private String name;
    @NotNull(message="price not be null")
private Integer price;
    @NotNull(message="brand not be null")
private String brand;
}
