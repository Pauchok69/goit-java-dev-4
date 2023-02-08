package com.goit.javadev;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        System.out.println("databaseQueryService.findLongestProject() = " + databaseQueryService.findLongestProject());
        System.out.println("databaseQueryService.findMaxProjectsClient() = " + databaseQueryService.findMaxProjectsClient());
        System.out.println("databaseQueryService.findMaxSalaryWorker() = " + databaseQueryService.findMaxSalaryWorker());
        System.out.println("databaseQueryService.findYoungestAndEldestWorkers() = " + databaseQueryService.findYoungestAndEldestWorkers());
        System.out.println("databaseQueryService.getProjectPrices() = " + databaseQueryService.getProjectPrices());
    }
}