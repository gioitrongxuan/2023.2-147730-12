package htdh.model.actor.sales;

import htdh.view.bpbh.SaleViewFactory;

public class ViewModel {
    private static ViewModel viewModel;
    private final SaleViewFactory saleViewFactory;


    public ViewModel() {
        saleViewFactory = new SaleViewFactory();
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
}
