package Facades;

import Beans.Category;
import Beans.Coupon;
import Beans.Customer;
import DBDAOs.CustomerDBDAO;
import DBDAOs.DButils;
import SQLcommands.couponCommands;
import SQLcommands.cvcCommands;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@AllArgsConstructor
public class CustomerFacade extends ClientFacade {
    private int customerID;
    public Boolean login(String email, String password) throws SQLException {
        return new CustomerDBDAO().isCustomerExists(email,password);
    }
    public void purchaseCoupon(Coupon coupon){

    }
    public ArrayList<Coupon> getCustomerCoupons(){
        ArrayList<Coupon> list = new ArrayList<>();
        HashMap<Integer,Object>params=new HashMap<>();
        params.put(1,customerID);
        try {
            ResultSet results = DButils.runQueryForResult(cvcCommands.GET_ALL_COUPONS_FOR_CUSTOMER, params);
            //company_id`,`category_id`,`title`,`description`," +
            //            "`start_date`,`end_date`,`amount`,`price`,`image
            while (results.next()) {
                Integer id=results.getInt(1);
                Integer companyID = results.getInt(2);
                Integer categoryID = results.getInt(3);
                String title = results.getString(4);
                String description = results.getString(5);
                java.sql.Date startDate = results.getDate(6);
                java.sql.Date endDate = results.getDate(7);
                Integer amount = results.getInt(8);
                Double price = results.getDouble(9);
                String image = results.getString(10);
                list.add(new Coupon(id,companyID,categoryID,title,description,startDate,endDate,amount,price,image));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Coupon> getCustomerCoupons(Category category){

    }
//    public ArrayList<Coupon> getCustomerCoupons(double maxPrice){
//
//    }
//    public Customer getCustomerDetails(){
//
//    }
}
