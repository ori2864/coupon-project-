package Facades;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import Exceptions.ErrMsg;
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
    public Boolean login(String email, String password) throws SQLException, sqlCustomException {

        if (companyDAO.isCompanyExists(email,password))return true;
        else throw new sqlCustomException(ErrMsg.COMPANY_DOES_NOT_EXIST);
    }

    public void addCoupon(Coupon coupon){
        try {
            couponDAO.addCoupon(coupon);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }
    }
    public void updateCoupon(Coupon coupon) {
        try {
            couponDAO.updateCoupon(coupon);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }
    }
    public void deleteCoupon(Coupon coupon) throws sqlCustomException {
        try {
            if (couponDAO.getOneCoupon(coupon.getId())==null)
                throw new sqlCustomException(ErrMsg.COUPON_DOES_NOT_EXIST);
        couponDAO.deleteCoupon(coupon.getId());
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }
    }
    public ArrayList<Coupon> getCompanyCoupons(int companyID) throws sqlCustomException {
        try {
        if (companyDAO.getOneCompany(companyID)==null){
            throw new sqlCustomException(ErrMsg.ID_NOT_FOUND);}
            return companyDAO.getCompanyCoupons(this.companyID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }

    }
    public ArrayList<Coupon> getCompanyCoupons(Category category) throws sqlCustomException {
        try {
        if (companyDAO.getOneCompany(companyID)==null) {
            throw new sqlCustomException(ErrMsg.ID_NOT_FOUND);
        }
            return companyDAO.getCompanyCoupons(category,companyID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }
    }
    public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws sqlCustomException {
        try {
            if (companyDAO.getOneCompany(companyID)==null) {
                throw new sqlCustomException(ErrMsg.ID_NOT_FOUND);
            }
            return companyDAO.getCompanyCoupons(maxPrice,companyID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }
    }
    public Company getCompanyDetails(){
        try {
            return companyDAO.getOneCompany(companyID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
            return null;
        }
    }


}
