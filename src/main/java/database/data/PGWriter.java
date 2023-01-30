package database.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PGWriter {
    private PGWriter() {
    }

    public static void initalizeTables(Connection connection) throws SQLException, IOException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(new String(Files.readAllBytes(Paths.get("src\\main\\resources\\InitalTables.sql"))));
        }
    }

    public static void writeResource(Connection connection) throws SQLException, IOException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(new String(Files.readAllBytes(Paths.get("src\\main\\resources\\DataResource.sql"))));
        }
    }
}