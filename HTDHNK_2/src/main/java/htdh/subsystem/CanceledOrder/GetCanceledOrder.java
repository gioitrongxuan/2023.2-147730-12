package htdh.subsystem.CanceledOrder;

import htdh.model.actor.dhqt.Model;
import htdh.model.common.entity.Merchandise;
import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCanceledOrder implements ICURDRejectOrder{
    public GetCanceledOrder() {
    }

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
    public List<Order> getCanceledOrders() {
        List<Order> canceledOrders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE status = 'canceled'";
        try {
            PreparedStatement preparedStatement = Model.getInstance().getDatabaseDriver().getConnection().prepareStatement(query);
            ResultSet resultSet = ((PreparedStatement) preparedStatement).executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getString("order_id"));
                order.setListfromsiteID(resultSet.getString("list_from_sale_id"));
                order.setSiteID(resultSet.getString("site_id"));
                order.setSiteName(resultSet.getString("site_name"));
                order.setDeliveryMean(resultSet.getString("delivery_mean"));
                order.setOrderSentDate(resultSet.getString("order_sent_date"));
                order.setDesiredDeliveryDate( resultSet.getString("desired_delivery_date"));
        
                

                // Retrieve merchandise information
                String merchandiseCodes = resultSet.getString("merchandise_ids");
                String[] merchandiseCodeArray = merchandiseCodes.split(",");
                String merchandiseAmounts = resultSet.getString("merchandise_quantities");
                String[] merchandiseAmountArray = merchandiseAmounts.split(",");
                for (int i = 0; i < merchandiseCodeArray.length; i++) {
                    Merchandise merchandise = new Merchandise();
                    merchandise.setMerchandiseCode(merchandiseCodeArray[i].trim());
                    order.getMerchandisesNeedToOrder().add(merchandise);
                    order.getAmountOfMerchandisesNeedToOrder().add(Integer.parseInt(merchandiseAmountArray[i].trim()));
                }

                order.setStatus(resultSet.getString("status"));
                canceledOrders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canceledOrders;
    }
    public List<Order_Merchandise> getOrderMerchandise(String orderId) {
        List<Order_Merchandise> orderMerchandiseList = new ArrayList<>();
        String query = "SELECT * FROM order_merchandise WHERE orderid = ?";
        try {
            // Tạo đối tượng PreparedStatement
            PreparedStatement statement = Model.getInstance().getDatabaseDriver().getConnection().prepareStatement(query);

            statement.setString(1, orderId);

            // Thực thi truy vấn SQL
            ResultSet resultSet = statement.executeQuery();

            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String mercode = resultSet.getString("mercode");
                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                int quantity = resultSet.getInt("quantity");
                String deliverydate = resultSet.getString("deliverydate");

                // Tạo đối tượng Merchandise từ dữ liệu truy vấn và thêm vào danh sách
                Order_Merchandise merchandise = new Order_Merchandise(name,orderId,mercode,unit,quantity,deliverydate);
                orderMerchandiseList.add(merchandise);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderMerchandiseList;
    }

}
