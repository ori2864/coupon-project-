package DAOs;
import Beans.Category;
import Beans.Company;
import Beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompanyDAO {
    public boolean isCompanyExists(String email,String password) throws SQLException;
    public void addCompany(Company company) throws SQLException;
    public void updateCompany(Company company);
    public void deleteCompany(int companyID);
    public ArrayList<Company> getAllCompanies();
    public Company getOneCompany(int companyID);
    public int getCompanyID (String email, String password) throws SQLException;
    public ArrayList<Coupon> getCompanyCoupons(int companyID);

    public ArrayList<Coupon> getCompanyCoupons(Category category);

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice);



}
