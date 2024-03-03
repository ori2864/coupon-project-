package DBDAOs;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DAOs.CustomerDAO;
import SQLcommands.companyCommands;
import SQLcommands.couponCommands;
import SQLcommands.customerCommands;
import SQLcommands.cvcCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerDBDAO implements CustomerDAO {
    @Override
    public Boolean isCustomerExists(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
            ResultSet result= DButils.runQueryForResult(customerCommands.IS_CUSTOMER_EXISTS, params);
            while (result.next()) {
                return result.getInt("isExists") == 1;
            }
        return false;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        DButils.runQuery(customerCommands.ADD_CUSTOMER, params);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, customer.getId());
        DButils.runQuery(customerCommands.UPDATE_CUSTOMER, params);
    }

    @Override
    public void deleteCustomer(int customerID) throws SQLException{
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        DButils.runQuery(customerCommands.DELETE_CUSTOMER, params);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException {
        ArrayList<Customer> list = new ArrayList<>();
        ResultSet results = DButils.runQueryForResult(customerCommands.GET_ALL_CUSTOMERS, new HashMap<>());
            while (results.next()) {
                int id = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                String email = results.getString(4);
                String password = results.getString(5);
                list.add(new Customer(id,firstName,lastName, email, password,new ArrayList<Coupon>()));
            }
            return list;

    }

    @Override
    public Customer getOneCustomer(int customerID) throws SQLException {
        Customer c= new Customer();
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        ResultSet results = DButils.runQueryForResult(customerCommands.GET_ONE_CUSTOMER,params);
            while (results.next()) {
                int id = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                String email = results.getString(4);
                String password = results.getString(5);
                c= new Customer(id,firstName,lastName,email,password,null);
            }
            return c;

    }
    public ArrayList<Coupon> getCustomerCoupons(int customerID) throws SQLException {

        ArrayList<Coupon> list = new ArrayList<>();
        HashMap<Integer,Object>params=new HashMap<>();
        params.put(1,customerID);
            ResultSet results = DButils.runQueryForResult(couponCommands.GET_CUSTOMER_COUPONS, params);
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
    public ArrayList<Coupon> getCustomerCoupons(Category category,int customerID) throws SQLException {
        ArrayList<Coupon> list = new ArrayList<>();
        HashMap<Integer,Object>params=new HashMap<>();
        params.put(1,customerID);
        params.put(2,category.ordinal()+1);
        ResultSet results = DButils.runQueryForResult(couponCommands.GET_CUSTOMER_COUPONS_BY_CATEGORY, params);
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
    public ArrayList<Coupon> getCustomerCoupons(double maxPrice, int customerID) throws SQLException {
        ArrayList<Coupon> list = new ArrayList<>();
        HashMap<Integer,Object>params=new HashMap<>();
        params.put(1,customerID);
        params.put(2,maxPrice);
        ResultSet results = DButils.runQueryForResult(couponCommands.GET_CUSTOMER_COUPONS_BELOW_PRICE, params);
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
    public Customer getCustomerByLogin(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        Customer c = new Customer();
        params.put(1, email);
        params.put(2, password);
        ResultSet results = DButils.runQueryForResult(customerCommands.GET_CUSTOMER_DETAILS, params);
        while (results.next()) {
            int id = results.getInt(1);
            String firstName = results.getString(2);
            String lastName = results.getString(3);
            email = results.getString(4);
            password = results.getString(5);
            c = new Customer(id,firstName,lastName,email,password,null);
        }
        return c;
    }


}
