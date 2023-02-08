package com.goit.javadev.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate birthday;
}
