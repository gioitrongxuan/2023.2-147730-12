module htdh {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
    opens htdh to javafx.fxml;
    opens htdh.view.test to javafx.fxml,javafx.base;
    opens htdh.controller.actor.dhqt.orderoperationcontroller to javafx.fxml;
    opens htdh.model.actor.sales to javafx.base;
    opens htdh.controller.actor.dhqt.merchandisecontroller to javafx.fxml;

    exports htdh.model.actor.sales.manageOrder to javafx.graphics,javafx.fxml;
    exports htdh.test.bpdhqt.dhqt.orderoperationtest to  javafx.graphics;
    exports htdh.controller.actor.sales.createOrder.child.management to javafx.fxml;
    opens htdh.controller.actor.sales.createOrder.child.management to javafx.fxml;
    opens htdh.controller.actor.dhqt.listcontroller to javafx.fxml;
    exports htdh.view.test to javafx.graphics,javafx.fxml;
    exports htdh.test.dhqt.sales to javafx.graphics;
    exports htdh;
    exports htdh.controller;
    exports htdh.controller.actor.admin;
    exports htdh.controller.actor.dhqt;
    exports htdh.model.actor.dhqt;
    exports htdh.test.dhqt.orderoperationtest to javafx.graphics,javafx.fxml;
    exports htdh.view.dhqt;
    exports htdh.subsystem.connectionManagementSubsystem;
    exports htdh.controller.actor.sales.createOrder.child.createOrder.child;
    opens htdh.controller.actor.sales.createOrder.child.createOrder.child to javafx.fxml;
    opens htdh.controller.actor.sales.createOrder.child.createOrder.parent to javafx.fxml, javafx.base;
    opens htdh.common.entity;
    exports htdh.common.entity;
<<<<<<< HEAD
    
    exports htdh.test.warehousemanagement;
    exports htdh.controller.warehousemanagement;
    opens htdh.test.warehousemanagement;
    opens htdh.controller.warehousemanagement to javafx.fxml;

    exports test; // Xuất khẩu gói test để các mô-đun khác có thể truy cập
    opens test to javafx.graphics, javafx.fxml;
}
=======
    exports htdh.controller.actor.sales.createProduct to javafx.fxml;
    opens htdh.controller.actor.sales.createProduct to javafx.fxml;
}
>>>>>>> 7ac4fe243b4e948c54b5bdaa33a67c1e26c047bc
