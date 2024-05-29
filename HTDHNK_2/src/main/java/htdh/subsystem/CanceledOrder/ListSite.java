package htdh.subsystem.CanceledOrder;

import htdh.model.actor.dhqt.Model;
import htdh.model.actor.site.Site;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListSite {
    public ResultSet findListSite(String merchandiseCode) {
            List<Site> siteList = new ArrayList<>();
            String query = "SELECT * " +
                    "FROM inventory i " +
                    "JOIN site s ON i.site_id = s.site_id " +
                    "WHERE i.merchandise_code = ?";
            ResultSet resultSet = null;
            try {
                // Tạo đối tượng PreparedStatement
                PreparedStatement statement = Model.getInstance().getDatabaseDriver().getConnection().prepareStatement(query);

                statement.setString(1, merchandiseCode);

                // Thực thi truy vấn SQL
                resultSet = statement.executeQuery();


            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }


    }
