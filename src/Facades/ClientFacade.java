package Facades;

import DAOs.CompanyDAO;
import DAOs.CouponDAO;
import DAOs.CustomerDAO;

public abstract class ClientFacade {
    CompanyDAO companyDAO;
    CustomerDAO customerDAO;
    CouponDAO couponDAO;
    public Boolean login(String email, String password){

        return null;
    }



}
