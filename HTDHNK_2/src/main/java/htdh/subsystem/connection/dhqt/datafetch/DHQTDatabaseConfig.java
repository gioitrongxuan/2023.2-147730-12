package htdh.subsystem.connection.dhqt.datafetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import htdh.model.actor.dhqt.orderoperation.orderstosites.OrderToSite;
import htdh.subsystem.connectionManagementSubsystem.DatabaseConfig;
import htdh.subsystem.connectionManagementSubsystem.DatabaseConnector;

public class DHQTDatabaseConfig implements DatabaseConnector {
	
	private DatabaseConfig config;
    private static Connection connection;

    public DHQTDatabaseConfig(DatabaseConfig config) {
        this.config = config;
    }
    public DHQTDatabaseConfig() {
        this.config = new DatabaseConfig();
    }

    @Override
    public void connect() {
        try {
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            System.out.println("Database Connect successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            this.connection.close();
            System.out.println("Database Disconnect successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unused")
    public void createTable() {
        // Câu lệnh SQL để tạo bảng OrderToSite
        String createOrderToSiteTableSQL = "CREATE TABLE OrderToSite (" +
                                           "orderToSiteID NVARCHAR(50) PRIMARY KEY, " +
                                           "siteID NVARCHAR(50), " +
                                           "siteName NVARCHAR(50), " +
                                           "deliveryMean NVARCHAR(10), " +
                                           "orderSentDate NVARCHAR(20), " +
                                           "desiredDeliveryDate NVARCHAR(20), " +
                                           "status NVARCHAR(50)" +
                                           ");";

        // Câu lệnh SQL để tạo bảng MerchandisesInOrderToSite
        String createMerchandisesInOrderToSiteTableSQL = "CREATE TABLE MerchandisesInOrderToSite (" +
                                                         "orderToSiteID NVARCHAR(50), " +
                                                         "merchandiseID NVARCHAR(50), " +
                                                         "merchandiseName NVARCHAR(200), " +
                                                         "quantity INT, " +
                                                         "FOREIGN KEY (orderToSiteID) REFERENCES OrderToSite(orderToSiteID)" +
                                                         ");";

        try (Statement stmt = connection.createStatement()) {
            // Thực hiện câu lệnh tạo bảng OrderToSite
            stmt.execute(createOrderToSiteTableSQL);
            System.out.println("Table OrderToSite created successfully.");

            // Thực hiện câu lệnh tạo bảng MerchandisesInOrderToSite
            stmt.execute(createMerchandisesInOrderToSiteTableSQL);
            System.out.println("Table MerchandisesInOrderToSite created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error creating tables: " + e.getMessage());
        }
    }

    
    public boolean insertDataIntoOrderToSiteTable(OrderToSite order) {
        // SQL statement to insert data into the OrderToSite table
        String insertOrderToSiteSQL = "INSERT INTO OrderToSite (orderToSiteID, siteID, siteName, deliveryMean, orderSentDate, desiredDeliveryDate, status) " +
                                      "VALUES (?, ?, ?, ?, ?, ?, ?);";

        // SQL statement to insert data into the MerchandisesInOrderToSite table
        String insertMerchandisesInOrderSQL = "INSERT INTO MerchandisesInOrderToSite (orderToSiteID, merchandiseID, merchandiseName, quantity) " +
                                               "VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmtOrder = connection.prepareStatement(insertOrderToSiteSQL);
             PreparedStatement pstmtMerchandise = connection.prepareStatement(insertMerchandisesInOrderSQL)) {

            // Insert data into the OrderToSite table
            pstmtOrder.setString(1, order.getOrderToSiteID());
            pstmtOrder.setString(2, order.getSiteID());
            pstmtOrder.setString(3, order.getSiteName());
            pstmtOrder.setString(4, order.getDeliveryMean());
            pstmtOrder.setString(5, order.getOrderSentDate());
            pstmtOrder.setString(6, order.getDesiredDeliveryDate());
            pstmtOrder.setString(7, order.getStatus());
            pstmtOrder.executeUpdate();

            // Insert data into the MerchandisesInOrderToSite table for each merchandise
            for (int i = 0; i < order.getMerchandisesNeedToOrder().size(); i++) {
                pstmtMerchandise.setString(1, order.getOrderToSiteID());
                pstmtMerchandise.setString(2, order.getMerchandisesNeedToOrder().get(i).getMerchandiseCode());
                pstmtMerchandise.setString(3, order.getMerchandisesNeedToOrder().get(i).getName());
                pstmtMerchandise.setInt(4, order.getAmountOfMerchandisesNeedToOrder().get(i));
                pstmtMerchandise.executeUpdate();
            }

            System.out.println("Data inserted into OrderToSite and MerchandisesInOrderToSite tables successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error inserting data: " + e.getMessage());
            return false;
        }
		return true;
    }
}
