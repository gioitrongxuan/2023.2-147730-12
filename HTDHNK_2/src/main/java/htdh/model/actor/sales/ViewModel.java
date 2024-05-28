package htdh.model.actor.sales;

import htdh.common.entity.Merchandise;
import htdh.common.entity.Product;
import htdh.subsystem.connectionManagementSubsystem.SQLServerConnector;
import htdh.view.bpbh.SaleViewFactory;

import java.util.ArrayList;

public class ViewModel {
    private static ViewModel viewModel;
    private final SaleViewFactory saleViewFactory;
    private final SQLServerConnector databaseDriver;


    public ViewModel() {
        saleViewFactory = new SaleViewFactory();
        this.databaseDriver = new SQLServerConnector() ;
        databaseDriver.connect();
    }
    public  static  synchronized ViewModel getInstance() {
        if (viewModel == null) {
            viewModel = new ViewModel();
        }
        return viewModel;
    }
    public SaleViewFactory getSaleViewFactory() {
        return saleViewFactory;
    }

    public void createOrder(ArrayList<Merchandise> data){
        this.databaseDriver.createOrder(data);
    }

    public Product searchProduct(String merchandiseCode){
        return this.databaseDriver.findProductByMerchandiseCode(merchandiseCode);
    }
}
