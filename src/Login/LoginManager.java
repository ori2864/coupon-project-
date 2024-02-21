package Login;

import DBDAOs.CompanyDBDAO;
import DBDAOs.CustomerDBDAO;
import Exceptions.sqlCustomException;
import Facades.AdminFacade;
import Facades.ClientFacade;
import Facades.CompanyFacade;
import Facades.CustomerFacade;

import java.sql.SQLException;

public class LoginManager {
    private static LoginManager loginManager=null;

    private LoginManager() {
        loginManager=new LoginManager();
    }
    public static LoginManager getInstance() {
        if (loginManager == null) {
            synchronized (LoginManager.class){
                if (loginManager==null)
                    loginManager=new LoginManager();
            }
        }    
     return loginManager;
    }
    public ClientFacade login(String email, String password, ClientType clientType){
        ClientFacade facade =null;
        switch (clientType){
            case Company : {
                try {
                  if(new CompanyFacade().login(email,password)) {
                      facade= new CompanyFacade(new CompanyDBDAO().getCompanyID(email, password));
                  }
                } catch (SQLException | sqlCustomException e) {
                    throw new RuntimeException(e);
                }
            }break;
            case Customer : {
                try {
                    if(new CustomerFacade().login(email,password)) {
                        facade= new CustomerFacade();
                    }
                } catch (SQLException | sqlCustomException e) {
                    throw new RuntimeException(e);
                }
            }break;
            case Administrator : {
                try {
                    if(new AdminFacade().login(email,password)) {
                        facade= new AdminFacade();
                    }
                } catch (sqlCustomException e) {
                    throw new RuntimeException(e);
                }
            }break;
        }
        return facade;
    }
}
