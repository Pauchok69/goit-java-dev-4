package com.goit.javadev.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxProjectsClient {
    private String name;
    private int projectCount;
}
