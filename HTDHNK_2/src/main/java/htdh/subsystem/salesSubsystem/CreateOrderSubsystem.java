package htdh.subsystem.salesSubsystem;

import htdh.common.entity.Merchandise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateOrderSubsystem {
    public ResultSet createOrderDataBase(Connection connection){
        ResultSet resultSet = null;
        String query = "SELECT * FROM Order WHERE status = 'REJECTED'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void createOrder(Connection connection, ArrayList<Merchandise> data) {
        String query = "INSERT INTO Order (merchandiseCode, quantity, unit, year, month, day) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (Merchandise merchandise : data) {
                preparedStatement.setString(1, merchandise.getMerchandiseCode());
                preparedStatement.setInt(2, merchandise.getQuantityOrdered());
                preparedStatement.setString(3, merchandise.getUnit());
                preparedStatement.setInt(4, merchandise.getYear());
                preparedStatement.setInt(5, merchandise.getMonth());
                preparedStatement.setInt(6, merchandise.getDay());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
