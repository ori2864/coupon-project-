package DAOs;

import Beans.Category;
import Beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CouponDAO {
    public void addCoupon(Coupon coupon) throws SQLException;

    public void updateCoupon(Coupon coupon) throws SQLException;

    public void deleteCoupon(int couponID) throws SQLException;

    public ArrayList<Coupon> getAllCoupons() throws SQLException;

    public Coupon getOneCoupon(int couponID) throws SQLException;

    public void addCouponPurchase(int customerID, int couponID) throws SQLException;

    public void deleteCouponPurchase(int customerID, int couponID) throws SQLException;


}
