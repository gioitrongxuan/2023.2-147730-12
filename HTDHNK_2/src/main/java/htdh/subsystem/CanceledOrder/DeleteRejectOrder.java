package htdh.subsystem.CanceledOrder;

import htdh.model.actor.dhqt.Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRejectOrder implements ICURDRejectOrder{
    @Override
    public void create() {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
        
    }
    public void deleteCancelOrder(String orderID) {
        String query = "DELETE FROM orders WHERE order_id = ?";
        try {
            PreparedStatement preparedStatement = Model.getInstance().getDatabaseDriver().getConnection().prepareStatement(query);
            preparedStatement.setString(1, orderID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
