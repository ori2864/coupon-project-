package DBDAOs;

import Beans.Category;
import Beans.Coupon;
import DAOs.CouponDAO;
import SQLcommands.couponCommands;
import SQLcommands.cvcCommands;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CouponDBDAO implements CouponDAO {
    @Override
    public void addCoupon(Coupon coupon) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        //company_id`,`category_id`,`title`,`description`," +
        //            "`start_date`,`end_date`,`amount`,`price`,`image
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategory().ordinal()+1);
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate().toString());
        params.put(6, coupon.getEndDate().toString());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        params.put(10,coupon.getCompanyID());
        params.put(11,coupon.getTitle());
            DButils.runQuery(couponCommands.ADD_COUPON , params);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        //company_id`,`category_id`,`title`,`description`," +
        //            "`start_date`,`end_date`,`amount`,`price`,`image
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategory().ordinal()+1);
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate().toString());
        params.put(6, coupon.getEndDate().toString());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DButils.runQuery(couponCommands.ADD_COUPON , params);


    }

    @Override
    public void deleteCoupon(int couponID) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        DButils.runQuery(couponCommands.DELETE_COUPON, params);

    }

    @Override
    public ArrayList<Coupon> getAllCoupons() throws SQLException {
        ArrayList<Coupon> list = new ArrayList<>();
        Category input;
            ResultSet results = DButils.runQueryForResult(couponCommands.GET_ALL_COUPONS, new HashMap<>());
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

                list.add(new Coupon(id,companyID,Category.values()[categoryID],title,description,startDate,endDate,amount,price,image));
            }
            return list;
    }

    @Override
    public Coupon getOneCoupon(int couponID) throws SQLException {
        Coupon c = new Coupon();
        Map<Integer,Object>params=new HashMap<>();
        params.put(1,couponID);
        ResultSet results = DButils.runQueryForResult(couponCommands.GET_ONE_COUPON,params);
            while (results.next()) {
                Integer id = results.getInt(1);
                Integer companyID = results.getInt(2);
                Integer categoryID = results.getInt(3);
                String title = results.getString(4);
                String description = results.getString(5);
                java.sql.Date startDate = results.getDate(6);
                Date endDate = results.getDate(7);
                Integer amount = results.getInt(8);
                Double price = results.getDouble(9);
                String image = results.getString(10);
                c= new Coupon(id,companyID,Category.values()[categoryID],title,description,
                        startDate,endDate,amount,price,image);
            }
            return c;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        params.put(3, couponID);
        Boolean result = DButils.runQuery(cvcCommands.ADD_CVC_COUPON_PURCHASE,params);
        if (result){
            params.clear();
            params.put(1,couponID);
            DButils.runQuery(couponCommands.COUPON_PURCHASE_AMOUNT_UPDATE,params);
        }
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        DButils.runQuery(cvcCommands.DELETE_CVC_COUPON_PURCHASE,params);
    }
}
