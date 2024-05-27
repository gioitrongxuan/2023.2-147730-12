package htdh.subsystem.queryExecutionSubsystem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLQueryExecutor implements QueryExecutor {
    private Connection connection;

    public MySQLQueryExecutor(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    @Override
    public int executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }
}

