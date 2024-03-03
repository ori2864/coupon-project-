package DAOs;
import Beans.Category;
import Beans.Company;
import Beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompanyDAO {
    public boolean isCompanyExists(String email,String password) throws SQLException;
    public void addCompany(Company company) throws SQLException;
    public void updateCompany(Company company) throws SQLException;
    public void deleteCompany(int companyID) throws SQLException;
    public ArrayList<Company> getAllCompanies() throws SQLException;
    public Company getOneCompany(int companyID) throws SQLException;
    public ArrayList<Coupon> getCompanyCoupons(int companyID) throws SQLException;

    public ArrayList<Coupon> getCompanyCoupons(Category category,int companyID) throws SQLException;

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice, int companyID) throws SQLException;
    public Company getCompanyByLogin(String email, String password) throws SQLException;



}
