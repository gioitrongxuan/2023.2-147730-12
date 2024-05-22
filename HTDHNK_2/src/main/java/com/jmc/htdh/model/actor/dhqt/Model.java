package com.jmc.htdh.model.actor.dhqt;

import com.jmc.htdh.subsystemSQLServer.SQLServerConnection;
import com.jmc.htdh.view.dhqt.AccountType;
import com.jmc.htdh.view.dhqt.ViewFactory;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final SQLServerConnection databaseDriver;
    private AccountType loginAccountType = AccountType.BPDHQT;
    //BPDHQT Data section
    private boolean bpdhqtLoginSuccessFlag;
    private final BPDHQT bpdhqt;
    //Other

    private Model() {
        this.databaseDriver = new SQLServerConnection() ;
        this.viewFactory = new ViewFactory();
        //BPDHQT
        this.bpdhqtLoginSuccessFlag = false;
        this.bpdhqt = new BPDHQT("","","",null);
        //Other

    }
    public  static  synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public SQLServerConnection getDatabaseDriver() {
        return databaseDriver;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    /*
            BPDHQT method section
             */
    public boolean getBPDHQTLoginSuccessFlag(){
        return this.bpdhqtLoginSuccessFlag;
    }
    public void setBpdhqtLoginSuccessFlag(boolean flag){this.bpdhqtLoginSuccessFlag = flag;}
    public BPDHQT getBpdhqt(){
        return bpdhqt;
    }
    public void evalueteBPDHQTCred (String username, String password){
        ResultSet resultSet = databaseDriver.getBPDHQTDataBase(username,password);
        try {
            if (resultSet.isBeforeFirst()){
                resultSet.next();
               this.bpdhqt.setName(resultSet.getString("username"));
               this.bpdhqtLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getRejectOrderData(){
        ResultSet resultSet = databaseDriver.getRejectOrderDataBase();
        try {
            while (resultSet.next()){
                System.out.println(resultSet.getString("order_id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
            Sales method section
             */

}
