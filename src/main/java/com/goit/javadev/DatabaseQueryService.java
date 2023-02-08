package com.goit.javadev;

import com.goit.javadev.dao.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String FIND_LONGEST_PROJECT_PATH = "sql/find_longest_project.sql";
    private static final String FIND_MAX_PROJECTS_CLIENT_PATH = "sql/find_max_projects_client.sql";
    private static final String FIND_MAX_SALARY_WORKER_PATH = "sql/find_max_salary_worker.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS_PATH = "sql/find_youngest_eldest_workers.sql";
    private static final String PRINT_PROJECT_PRICES_PATH = "sql/print_project_prices.sql";

    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        ArrayList<LongestProject> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                Path path = Paths.get(FIND_LONGEST_PROJECT_PATH);
                ResultSet resultSet = statement.executeQuery(Files.readString(path, StandardCharsets.UTF_8));

                while (resultSet.next()) {
                    LongestProject longestProject = new LongestProject(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("months_count")
                    );
                    result.add(longestProject);
                }
            }
        }

        return result;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() throws IOException, SQLException {
        ArrayList<MaxProjectsClient> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                Path path = Paths.get(FIND_MAX_PROJECTS_CLIENT_PATH);
                ResultSet resultSet = statement.executeQuery(Files.readString(path, StandardCharsets.UTF_8));

                while (resultSet.next()) {
                    MaxProjectsClient longestProject = new MaxProjectsClient(
                            resultSet.getString("name"),
                            resultSet.getInt("project_count")
                    );
                    result.add(longestProject);
                }
            }
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        ArrayList<MaxSalaryWorker> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                Path path = Paths.get(FIND_MAX_SALARY_WORKER_PATH);
                ResultSet resultSet = statement.executeQuery(Files.readString(path, StandardCharsets.UTF_8));

                while (resultSet.next()) {
                    MaxSalaryWorker longestProject = new MaxSalaryWorker(
                            resultSet.getString("name"),
                            resultSet.getInt("salary")
                    );
                    result.add(longestProject);
                }
            }
        }

        return result;
    }

    public List<YoungestEldestWorkers> findYoungestAndEldestWorkers() throws IOException, SQLException {
        ArrayList<YoungestEldestWorkers> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                Path path = Paths.get(FIND_YOUNGEST_ELDEST_WORKERS_PATH);
                ResultSet resultSet = statement.executeQuery(Files.readString(path, StandardCharsets.UTF_8));

                while (resultSet.next()) {
                    YoungestEldestWorkers longestProject = new YoungestEldestWorkers(
                            resultSet.getString("type"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthday").toLocalDate()
                    );
                    result.add(longestProject);
                }
            }
        }

        return result;
    }

    public List<ProjectPrices> getProjectPrices() throws IOException, SQLException {
        ArrayList<ProjectPrices> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                Path path = Paths.get(PRINT_PROJECT_PRICES_PATH);
                ResultSet resultSet = statement.executeQuery(Files.readString(path, StandardCharsets.UTF_8));

                while (resultSet.next()) {
                    ProjectPrices longestProject = new ProjectPrices(
                            resultSet.getLong("id"),
                            resultSet.getLong("client_id"),
                            resultSet.getString("name"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getDate("finish_date").toLocalDate(),
                            resultSet.getInt("price")
                    );
                    result.add(longestProject);
                }
            }
        }

        return result;
    }
}
