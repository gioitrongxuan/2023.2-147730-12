module com.jmc.htdh {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    opens com.jmc.htdh to javafx.fxml;
    opens com.jmc.htdh.view.test to javafx.fxml,javafx.base;

    exports com.jmc.htdh.model.actor.sales.manageOrder to javafx.graphics,javafx.fxml;
    exports com.jmc.htdh.view.test to javafx.graphics,javafx.fxml;
    exports com.jmc.htdh;
    exports com.jmc.htdh.controller;
    exports com.jmc.htdh.controller.admin;
    exports com.jmc.htdh.controller.bpdhqt;
    exports com.jmc.htdh.model;
    exports com.jmc.htdh.view;
    exports com.jmc.htdh.model.actor.dhqt;
    exports com.jmc.htdh.view.dhqt;
    exports com.jmc.htdh.subsystemSQLServer;

}