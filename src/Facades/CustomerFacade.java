package Facades;

import Beans.Category;
import Beans.Coupon;
import Beans.Customer;
import DBDAOs.CustomerDBDAO;
import DBDAOs.DButils;
import Exceptions.ErrMsg;
import Exceptions.sqlCustomException;
import SQLcommands.couponCommands;
import SQLcommands.cvcCommands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerFacade extends ClientFacade {
    private int customerID;
    public Boolean login(String email, String password) throws SQLException, sqlCustomException {
        if (customerDAO.isCustomerExists(email,password))return true;
        else throw new sqlCustomException(ErrMsg.CUSTOMER_DOES_NOT_EXIST);
    }
    public void purchaseCoupon(Coupon coupon) throws sqlCustomException {
        Coupon checkExistence = null;
        try {
            checkExistence = couponDAO.getOneCoupon(coupon.getId());

        if (checkExistence ==null)
            throw new sqlCustomException(ErrMsg.ID_NOT_FOUND);
        if (coupon.getEndDate().before(Date.valueOf(LocalDate.now()))) {
            couponDAO.deleteCoupon(coupon.getId());
            throw new sqlCustomException(ErrMsg.COUPON_IS_EXPIRED);
        }
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }
        try {
            couponDAO.addCouponPurchase(customerID,coupon.getId());
            System.out.println("purchase successful");
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"------"+e.getErrorCode());
        }
    }
    public ArrayList<Coupon> getCustomerCoupons(){
        try {
            return customerDAO.getCustomerCoupons(customerID);
        } catch (SQLException e) {
            System.out.println("an error has occurred -  "+e.getMessage());
            return null;
        }

    }
    public ArrayList<Coupon> getCustomerCoupons(Category category){
        try {
           return customerDAO.getCustomerCoupons(category,customerID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }
    }
    public ArrayList<Coupon> getCustomerCoupons(double maxPrice){
        try {
            return customerDAO.getCustomerCoupons(maxPrice,customerID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }
    }
    public Customer getCustomerDetails() throws sqlCustomException {
        Customer customer=null;
        try {
            customer= customerDAO.getOneCustomer(customerID);
            if (customer==null)throw new sqlCustomException(ErrMsg.CUSTOMER_DOES_NOT_EXIST);
            return customer;
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }
    }
}
