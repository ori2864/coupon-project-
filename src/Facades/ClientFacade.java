package Facades;

import DAOs.CompanyDAO;
import DAOs.CouponDAO;
import DAOs.CustomerDAO;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import Exceptions.sqlCustomException;

import java.sql.SQLException;

public abstract class ClientFacade {
    protected CompanyDAO companyDAO=new CompanyDBDAO();
    protected CustomerDAO customerDAO=new CustomerDBDAO();
    protected CouponDAO couponDAO=new CouponDBDAO();
    public Boolean login(String email, String password) throws sqlCustomException, SQLException {

        return null;
    }



}
