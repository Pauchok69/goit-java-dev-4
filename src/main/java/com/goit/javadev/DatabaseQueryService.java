package com.goit.javadev;

import com.goit.javadev.dao.LongestProject;
import com.goit.javadev.dao.MaxProjectsClient;

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
    private static final String FIND_MAX_PROJECTS_CLIENT = "sql/find_max_projects_client.sql";
    private static final String FIND_MAX_SALARY_WORKER = "sql/find_max_salary_worker.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS = "sql/find_youngest_eldest_workers.sql";
    private static final String PRINT_PROJECT_PRICES = "sql/print_project_prices.sql";

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
                Path path = Paths.get(FIND_MAX_PROJECTS_CLIENT);
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
}
