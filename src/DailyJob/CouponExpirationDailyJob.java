package DailyJob;

import Beans.Coupon;
import DAOs.CouponDAO;
import DBDAOs.CouponDBDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CouponExpirationDailyJob implements Runnable {
    private CouponDAO couponDAO;
    private boolean quit =false;

    @Override
    public void run() {
        Date dateNow=Date.valueOf(LocalDate.now());
        ArrayList<Coupon> coupons= null;
        try {
            coupons = couponDAO.getAllCoupons();
        } catch (SQLException e) {
            System.out.println("an error has occurred while " +
                    "trying to delete expired coupons - "+e.getMessage());
        }
        if (coupons==null)return;//preventing null pointer exception
        synchronized (CouponExpirationDailyJob.class) {
            while (!quit) {
                coupons.forEach(coupon -> {
                    if (dateNow.after(coupon.getEndDate())) {
                        try {
                            new CouponDBDAO().deleteCoupon(coupon.getId());
                        } catch (SQLException e) {
                            System.out.println("an error has occurred while " +
                                    "trying to delete expired coupons - "+e.getMessage());
                        }
                    }
                });
                try {
                    wait(1000*60*60*24);
                } catch (InterruptedException e) {
                    System.out.println("an error has occurred while " +
                            "trying to delete expired coupons - "+e.getMessage());
                }
            }
        }
    }

    public void stop(){
        synchronized (CouponExpirationDailyJob.class){
            quit=true;
        }
    }
}
