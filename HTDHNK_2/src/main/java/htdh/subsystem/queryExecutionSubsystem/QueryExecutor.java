package htdh.subsystem.queryExecutionSubsystem;
import java.sql.ResultSet;
import java.sql.SQLException;
public interface QueryExecutor {
    ResultSet executeQuery(String query) throws SQLException;
    int executeUpdate(String query) throws SQLException;
}