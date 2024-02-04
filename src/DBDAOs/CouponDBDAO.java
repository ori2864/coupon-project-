package DBDAOs;

import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DAOs.CouponDAO;
import DAOs.CustomerDAO;
import SQLcommands.companyCommands;
import SQLcommands.couponCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CouponDBDAO implements CouponDAO {
    @Override
    public void addCoupon(Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        //company_id`,`category_id`,`title`,`description`," +
        //            "`start_date`,`end_date`,`amount`,`price`,`image
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategoryID());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5,"2023-12-06");
        params.put(6,"2024-01-07");
        //TODO date columns????
        //params.put(5, coupon.getStartDate().toString());
        //params.put(6, coupon.getEndDate().toString());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DButils.runQuery(couponCommands.ADD_COUPON , params);
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        //company_id`,`category_id`,`title`,`description`," +
        //            "`start_date`,`end_date`,`amount`,`price`,`image
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategoryID());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5,"2023-12-06");
        params.put(6,"2024-01-07");
        //TODO date columns????
        //params.put(5, coupon.getStartDate().toString());
        //params.put(6, coupon.getEndDate().toString());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DButils.runQuery(couponCommands.ADD_COUPON , params);


    }

    @Override
    public void deleteCoupon(int couponID) {
        DButils.runQueryWithIndex(couponCommands.DELETE_COUPON, couponID);

    }

    @Override
    public ArrayList<Coupon> getAllCoupons() {
        ArrayList<Coupon> list = new ArrayList<>();
        ResultSet results = DButils.runQueryForResult(couponCommands.GET_ALL_COUPONS, new HashMap<>());
        try {
            //company_id`,`category_id`,`title`,`description`," +
            //            "`start_date`,`end_date`,`amount`,`price`,`image
            while (results.next()) {
                Integer companyID = results.getInt(2);
                Integer categoryID = results.getInt(3);
                String title = results.getString(4);
                String description = results.getString(5);
                //todo date columns
                Date startDate = results.getDate(6);
                Date endDate = results.getDate(7);
                Integer amount = results.getInt(8);
                Double price = results.getDouble(9);
                String image = results.getString(10);
                list.add(new Coupon(companyID,categoryID,title,description,startDate,endDate,amount,price,image));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Coupon getOneCoupon(int couponID) {
        Coupon c = new Coupon();
        Map<Integer,Object>params=new HashMap<>();
        params.put(1,couponID);
        ResultSet results = DButils.runQueryForResult(couponCommands.GET_ONE_COUPON,params);
        try {
            while (results.next()) {
                Integer companyID = results.getInt(2);
                Integer categoryID = results.getInt(3);
                String title = results.getString(4);
                String description = results.getString(5);
                //todo date columns
                Date startDate = results.getDate(6);
                Date endDate = results.getDate(7);
                Integer amount = results.getInt(8);
                Double price = results.getDouble(9);
                String image = results.getString(10);
                c= new Coupon(companyID,categoryID,title,description,
                        startDate,endDate,amount,price,image);
            }
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {

    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {

    }
}
