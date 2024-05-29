package htdh.controller.actor.dhqt;

import htdh.model.actor.site.Site;
import htdh.model.common.entity.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ListSiteCellController implements Initializable {
    public Label site_id_lbl;
    public Label deliverydate_lbl;
    public Label quantity_lbl;
    public TextField selected_tld;
    public ChoiceBox deliverymean_choice;
    TitlePaneReOrderController titlePaneReOrderController;
    private Site site;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date currentDay = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



        titlePaneReOrderController.selected.textProperty().addListener((observable, oldValue, newValue) -> {
            if(Integer.parseInt(newValue) == Integer.parseInt(titlePaneReOrderController.quantity_lbl.getText())){
               setDisableTextField();
            }else {
                setEnableTextField();
            }
        });
        deliverymean_choice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("Air")){
                Date deliveryDate = new Date(currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByAirTime()));
                deliverydate_lbl.setText(dateFormat.format(deliveryDate));
            }else if(newValue.equals("Ship")){
                Date deliveryDate = new Date(currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByShipTime()));
                deliverydate_lbl.setText(dateFormat.format(deliveryDate));
            }
        });
        

    }

    public void setSite_id_lbl(String site_id_lbl) {
        this.site_id_lbl.setText(site_id_lbl);
    }

    public void setDeliverydate_lbl(String deliverydate_lbl) {
        this.deliverydate_lbl.setText(deliverydate_lbl);
    }

    public void setQuantity_lbl(String quantity_lbl) {
        this.quantity_lbl.setText(quantity_lbl);
    }

    public void setSelected_tld(String selected_tld) {
        this.selected_tld.setText(selected_tld);
    }

    public void setDeliverymean_choice(String deliverymean_choice) {
        String[] choice =deliverymean_choice.split("'");
        ObservableList<String>  choiceOb= FXCollections.observableArrayList(choice);
        this.deliverymean_choice.setItems(choiceOb);
    }
    public void setData(ResultSet resultSet) {
        try {
            // Lấy dữ liệu từ ResultSet
            String siteId = resultSet.getString("site_id");
//            String deliveryDate = resultSet.getString("deliverydate");
            int quantity = resultSet.getInt("quantity");
            int air_time_day = resultSet.getInt("air_time_day");
            int ship_time_day = resultSet.getInt("ship_time_day");
//            String deliveryMean = resultSet.getString("delivery_mean");

            // Đặt dữ liệu vào các thành phần UI tương ứng
            site_id_lbl.setText(siteId);
            deliverydate_lbl.setText("____-__-__");
            quantity_lbl.setText(String.valueOf(quantity));
            selected_tld.setText("");
            ObservableList<String> choicebox;
            if(air_time_day == -1){
                if(ship_time_day== -1) {
                    choicebox = FXCollections.observableArrayList("");
                }else{
                    choicebox = FXCollections.observableArrayList("Ship");
                }
            } else {
                if(ship_time_day== -1){
                    choicebox = FXCollections.observableArrayList("Air");
                }else{
                    choicebox = FXCollections.observableArrayList("Air","Ship");
                }
            }
            deliverymean_choice.setItems(choicebox);
            this.site = new Site(siteId,"",air_time_day,ship_time_day);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTitlePaneReOrderController(TitlePaneReOrderController titlePaneReOrderController){
        this.titlePaneReOrderController= titlePaneReOrderController;
    }
    public void setDisableTextField(){
        if(selected_tld.getText().isEmpty())
                 selected_tld.setDisable(true);
    }
    public void setEnableTextField(){
        if(selected_tld.getText().isEmpty())
            selected_tld.setDisable(false);
    }


}
