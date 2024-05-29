package htdh.model.actor.dhqt;

import htdh.subsystem.connectionManagementSubsystem.SQLServerConnector;
import htdh.view.dhqt.AccountType;
import htdh.view.dhqt.ViewFactory;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final SQLServerConnector databaseDriver;
    private AccountType loginAccountType = AccountType.BPDHQT;
    //BPDHQT Data section
    private boolean bpdhqtLoginSuccessFlag;
    private final BPDHQT bpdhqt;
    //Other

    private Model() {
        this.databaseDriver = new SQLServerConnector() ;
        databaseDriver.connect();

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

    public SQLServerConnector getDatabaseDriver() {
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

    /*
            Sales method section
             */

}
