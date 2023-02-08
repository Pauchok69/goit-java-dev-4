package com.goit.javadev.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPrices {
    private long id;
    private long clientId;
    private String name;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int price;
}
