module com.jmc.htdh {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires java.desktop;
    opens com.jmc.htdh to javafx.fxml;
    opens com.jmc.htdh.view.test to javafx.fxml,javafx.base;
    opens com.jmc.htdh.controller.actor.dhqt.orderoperationcontroller to javafx.fxml;
    opens com.jmc.htdh.controller.actor.sales to javafx.fxml;
    opens com.jmc.htdh.model.actor.sales to javafx.base;

    exports com.jmc.htdh.model.actor.sales.manageOrder to javafx.graphics,javafx.fxml;
    opens com.jmc.htdh.controller.actor.dhqt.listcontroller to javafx.fxml;
    exports com.jmc.htdh.controller.actor.sales to javafx.fxml;
    exports com.jmc.htdh.view.test to javafx.graphics,javafx.fxml;
    exports com.jmc.htdh.test.dhqt.sales to javafx.graphics;
    exports com.jmc.htdh;
    exports com.jmc.htdh.controller;
    exports com.jmc.htdh.controller.actor.admin;
    exports com.jmc.htdh.controller.actor.dhqt;
    exports com.jmc.htdh.model.actor.dhqt;
    exports com.jmc.htdh.test.dhqt.orderoperationtest to javafx.graphics,javafx.fxml;
    exports com.jmc.htdh.view.dhqt;
    exports com.jmc.htdh.subsystemSQLServer;

}