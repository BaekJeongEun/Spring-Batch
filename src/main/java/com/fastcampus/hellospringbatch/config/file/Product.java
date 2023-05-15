package com.fastcampus.hellospringbatch.config.file;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
}
