package DBDAOs;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import DAOs.CompanyDAO;
import SQLcommands.companyCommands;
import SQLcommands.couponCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//@todo exceptions
public class CompanyDBDAO implements CompanyDAO {
    @Override
    public boolean isCompanyExists(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        try {
            ResultSet result = DButils.runQueryForResult(companyCommands.IS_COMPANY_EXISTS, params);
            while (result.next()) {
                return result.getInt("isExists") == 1;
            }
        } catch (SQLException err) {
            throw new SQLException(err.getMessage());
        }
        return false;
    }

    @Override
    public void addCompany(Company company) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
            DButils.runQuery(companyCommands.ADD_COMPANY, params);

    }

    @Override
    public void updateCompany(Company company) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getEmail());
        params.put(2, company.getPassword());
        params.put(3, company.getId());
            DButils.runQuery(companyCommands.UPDATE_COMPANY, params);
    }

    @Override
    public void deleteCompany(int companyID) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
            DButils.runQuery(companyCommands.DELETE_COMPANY, params);
    }

    @Override
    public ArrayList<Company> getAllCompanies() throws SQLException {
        ArrayList<Company> list = new ArrayList<>();
        ResultSet results = DButils.runQueryForResult(companyCommands.GET_ALL_COMPANIES, new HashMap<>());
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String email = results.getString(3);
                String password = results.getString(4);
                list.add(new Company(id, name, email, password));
            }
            return list;
    }


    @Override
    public Company getOneCompany(int companyID) throws SQLException {
        Company c = new Company();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        ResultSet results = DButils.runQueryForResult(companyCommands.GET_ONE_COMPANY, params);
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String email = results.getString(3);
                String password = results.getString(4);
                c = new Company(id, name, email, password, null);
            }
            return c;
    }


    public Company getCompanyByLogin(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        Company c = new Company();
        params.put(1, email);
        params.put(2, password);
            ResultSet results = DButils.runQueryForResult(companyCommands.GET_COMPANY_DETAILS, params);
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                email = results.getString(3);
                password = results.getString(4);
                c = new Company(id, name, email, password, null);
            }
        return c;
    }

    public ArrayList<Coupon> getCompanyCoupons(int companyID) throws SQLException {
        ArrayList<Coupon> coupons = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);

            ResultSet results = DButils.runQueryForResult(couponCommands.GET_COMPANY_COUPONS, params);
            while (results.next()) {
                Integer id = results.getInt(1);
                Integer companyID2 = results.getInt(2);
                Integer categoryID = results.getInt(3);
                String title = results.getString(4);
                String description = results.getString(5);
                java.sql.Date startDate = results.getDate(6);
                java.sql.Date endDate = results.getDate(7);
                Integer amount = results.getInt(8);
                Double price = results.getDouble(9);
                String image = results.getString(10);
                coupons.add(new Coupon(id, companyID, Category.values()[categoryID], title, description, startDate, endDate, amount, price, image));
            }
            return coupons;


    }

    @Override
    public ArrayList<Coupon> getCompanyCoupons(Category category, int companyID) throws SQLException {
        ArrayList<Coupon> coupons = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, category.ordinal()+1);
        params.put(2, companyID);

            ResultSet results = DButils.runQueryForResult(couponCommands.GET_COMPANY_COUPONS_BY_CATEGORY, params);
            while (results.next()) {
                Integer id = results.getInt(1);
                Integer companyID2 = results.getInt(2);
                Integer categoryID = results.getInt(3);
                String title = results.getString(4);
                String description = results.getString(5);
                java.sql.Date startDate = results.getDate(6);
                java.sql.Date endDate = results.getDate(7);
                Integer amount = results.getInt(8);
                Double price = results.getDouble(9);
                String image = results.getString(10);
                coupons.add(new Coupon(id, companyID2,Category.values()[categoryID], title,
                        description, startDate, endDate, amount, price, image));
            }
            return coupons;
    }

    @Override
    public ArrayList<Coupon> getCompanyCoupons(double maxPrice, int companyID) throws SQLException {
        ArrayList<Coupon> coupons = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, maxPrice);
        params.put(2, companyID);

        ResultSet results = DButils.runQueryForResult(couponCommands.GET_COMPANY_COUPONS_BELOW_PRICE, params);
        while (results.next()) {
            Integer id = results.getInt(1);
            Integer companyID2 = results.getInt(2);
            Integer categoryID = results.getInt(3);
            String title = results.getString(4);
            String description = results.getString(5);
            java.sql.Date startDate = results.getDate(6);
            java.sql.Date endDate = results.getDate(7);
            Integer amount = results.getInt(8);
            Double price = results.getDouble(9);
            String image = results.getString(10);
            coupons.add(new Coupon(id, companyID2, Category.values()[categoryID], title,
                    description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

}

