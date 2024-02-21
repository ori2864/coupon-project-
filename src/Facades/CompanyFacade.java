package Facades;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import Exceptions.sqlCustomException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class CompanyFacade extends ClientFacade{
    private int companyID;

    @Override
    public Boolean login(String email, String password) throws sqlCustomException, SQLException {
        return companyDAO.isCompanyExists(email,password);
    }

    public void addCoupon(Coupon coupon){
        couponDAO.addCoupon(coupon);
    }
    public void updateCoupon(Coupon coupon){
        couponDAO.updateCoupon(coupon);
    }
    public void deleteCoupon(Coupon coupon){
        couponDAO.deleteCoupon(coupon.getId());
    }
    public ArrayList<Coupon> getCompanyCoupons(){

        return companyDAO.getCompanyCoupons(this.companyID);
    }
    public ArrayList<Coupon> getCompanyCoupons(Category category){
        return companyDAO.getCompanyCoupons(category);
    }
    public ArrayList<Coupon> getCompanyCoupons(double maxPrice){
        return companyDAO.getCompanyCoupons(maxPrice);
    }
    public Company getCompanyDetails(){
        return companyDAO.getOneCompany(companyID);
    }


}
