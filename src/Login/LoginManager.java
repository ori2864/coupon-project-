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
    public ClientFacade login(String email, String password, ClientType clientType) throws sqlCustomException {
        ClientFacade facade =null;
        switch (clientType){


            case Company : {
                try {
                    //check login->boolean query
                  if(new CompanyFacade().login(email,password)) {
                      //saving facade with the relevant id
                      facade= new CompanyFacade(new CompanyDBDAO().getCompanyByLogin(email, password).getId());
                  }
                  //if login fails->company facade will throw custom exception
                } catch (SQLException  e) {
                    System.out.println("an error has occurred - "+e.getMessage());
                }
            }break;


            case Customer : {
                try {
                    //check login->boolean query
                    if(new CustomerFacade().login(email,password)) {
                        facade= new CustomerFacade(new CustomerDBDAO().getCustomerByLogin(email,password).getId());
                        //saving facade with the relevant id
                    }
                    //if login fails->customer facade will throw custom exception
                } catch (SQLException e) {
                    System.out.println("an error has occurred - "+e.getMessage());
                }
            }break;


            case Administrator : {
                    if(new AdminFacade().login(email,password)) {
                        facade= new AdminFacade();
                    }
            }break;
        }


        return facade;
    }
}
