package com.fastcampus.hellospringbatch.config.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private int age;
}
