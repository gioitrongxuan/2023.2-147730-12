package htdh.controller.actor.dhqt.reorder;

import htdh.controller.actor.dhqt.ListSiteCellController;
import htdh.controller.actor.dhqt.TitlePaneReOrderController;
import htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseController;
import htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseSiteOptController;
import htdh.model.actor.dhqt.Model;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.dhqt.orderoperation.orderstosites.OrderToSite;
import htdh.model.common.entity.Order;
import htdh.model.actor.site.Site;
import htdh.model.common.entity.Order_Merchandise;
import htdh.subsystem.connection.dhqt.datafetch.DHQTDatabaseConfig;

import javax.swing.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReorderController {
    private List<Site> listSite = new ArrayList<>();


    public List<Site> getListSite(Order_Merchandise orderMerchandise) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDay = new Date(2023 - 1900, 3, 10);

        ResultSet resultSet = Model.getInstance().getDatabaseDriver().findListSite(orderMerchandise.getMerchandiseCode(),orderMerchandise.getOrderId());
        try {
            while (resultSet.next()) {
                Site site = new Site();
                site.setSiteCode(resultSet.getString("site_id"));
                site.setSiteName("");
                site.setByAirTime(resultSet.getInt("air_time_day"));
                site.setByShipTime(resultSet.getInt("ship_time_day"));
                site.setQuantity(resultSet.getInt("quantity"));
                if (site.getByAirTime() == -1) {
                    if (site.getByShipTime() == -1) {
                        continue;
                    } else {
                        if (currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByShipTime()) < java.sql.Date.valueOf(orderMerchandise.getDeliveryDate()).getTime()) {
                            site.setDeliveryDate(new Date(currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByShipTime())));
                            site.setType(1);
                            listSite.add(site);
                        }
                    }
                } else {
                    if (site.getByShipTime() == -1) {
                        if (currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByAirTime()) < java.sql.Date.valueOf(orderMerchandise.getDeliveryDate()).getTime()) {
                            site.setDeliveryDate(new Date(currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByAirTime())));
                            site.setType(2);
                            listSite.add(site);
                        }
                    } else {
                        if (currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByAirTime()) < java.sql.Date.valueOf(orderMerchandise.getDeliveryDate()).getTime() || currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByShipTime()) < java.sql.Date.valueOf(orderMerchandise.getDeliveryDate()).getTime()) {
                            long deliveryTime = Math.min(currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByAirTime()), currentDay.getTime() + TimeUnit.DAYS.toMillis(site.getByShipTime()));
                            Date deliveryDate = new Date(deliveryTime);
                            site.setDeliveryDate(deliveryDate);
                            site.setType(1);
                            listSite.add(site);
                        }

                    }

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sortListSite(listSite);
        return listSite;
    }
    public void sortListSite(List<Site> listSite){
        listSite.sort((o1, o2) -> {
            if (o1.getType() > o2.getType()) {
                return 1;
            } else if (o1.getType() < o2.getType()) {
                return -1;
            } else {
                return o1.getDeliveryDate().compareTo(o2.getDeliveryDate());
            }
        });
    }
    public ReorderController(){}

    public void deleteCancelOrder(Order orderMerchandise){
        Model.getInstance().getDatabaseDriver().deleteCancelOrder(orderMerchandise.getOrderID());
    }
//    private void allocationOrdersToSites(List<TitlePaneReOrderController> titlePaneReOrderControllers) {
//
//        DHQTDatabaseConfig dbConfig = new DHQTDatabaseConfig();
//        dbConfig.connect();
//
//        dbConfig.createTable();
//
//        List<String> orderToSiteKey = new ArrayList<String>();
//        for ( TitlePaneReOrderController titlePaneReOrderController : titlePaneReOrderControllers ) {
//            for( ListSiteCellController listSiteCellController : titlePaneReOrderController.getListSiteCellControllers()) {
//                String siteID = listSiteCellController.site_id_lbl.getText();
//                String deliveryMean = listSiteCellController.deliverymean_choice.getValue().toString();
//
//                ArrayList<Merchandise> merchandisesNeedToOrder = new ArrayList<Merchandise>();
//                ArrayList<Integer> amountOfMerchandisesNeedToOrder = new ArrayList<Integer>();
//                String status = "Chờ xác nhận";
//                String key = siteID + "-" + deliveryMean ;
//                if(!(listSiteCellController.selected_tld.getText().equals("0"))) {
//                    if (orderToSiteKey.contains(key) == false) {
//                        orderToSiteKey.add(key);
//                        desiredDeliveryDate = (merchandiseSiteOptController.getDesiredDeliveryDateLbl().getText());
//                        merchandisesNeedToOrder.add(merchandiseController.getMerchandise());
//                        amountOfMerchandisesNeedToOrder.add(Integer.parseInt(merchandiseSiteOptController.getQuantityTextField().getText()));
//                        OrderToSite orderToSite = new OrderToSite(key, siteID, siteName, deliveryMean, orderSentDate, desiredDeliveryDate, merchandisesNeedToOrder, amountOfMerchandisesNeedToOrder, status);
//                        numberOfOrderToSite.add(orderToSite);
//                    } else {
//                        for ( int i = 0 ; i < numberOfOrderToSite.size() ; i++ ) {
//                            if(numberOfOrderToSite.get(i).getSiteID().equals(siteID)) {
//                                numberOfOrderToSite.get(i).setDesiredDeliveryDate(merchandiseSiteOptController.getDesiredDeliveryDateLbl().getText());;
//                                numberOfOrderToSite.get(i).getMerchandisesNeedToOrder().add(merchandiseController.getMerchandise());
//                                numberOfOrderToSite.get(i).getAmountOfMerchandisesNeedToOrder().add(Integer.parseInt(merchandiseSiteOptController.getQuantityTextField().getText()));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        for (OrderToSite order : numberOfOrderToSite) {
//            boolean updateDataCheck = dbConfig.insertDataIntoOrderToSiteTable(order);
//            if (!updateDataCheck) {
//                JOptionPane.showMessageDialog(null, "Đơn hàng này đã được gửi rồi.");
//                order = null;
//                break; // Thoát khỏi vòng lặp nếu đơn hàng đã được gửi
//            }
//        }
//    }

}
