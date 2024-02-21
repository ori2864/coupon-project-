import Beans.Coupon;
import DAOs.CouponDAO;
import DBDAOs.CouponDBDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class CouponExpirationDailyJob implements Runnable {
    private CouponDAO couponDAO;
    private boolean quit =false;

    @Override
    public void run() {
        Date dateNow=Date.valueOf(LocalDate.now());
        ArrayList<Coupon> coupons= couponDAO.getAllCoupons();
        synchronized (CouponExpirationDailyJob.class) {
            while (!quit) {
                coupons.forEach(coupon -> {
                    if (dateNow.after(coupon.getEndDate())) {
                        new CouponDBDAO().deleteCoupon(coupon.getId());
                    }
                });
                try {
                    wait(1000*60*60*24);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
