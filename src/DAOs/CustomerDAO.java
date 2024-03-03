package DAOs;

import Beans.Category;
import Beans.Coupon;
import Beans.Customer;
import Exceptions.sqlCustomException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    public Boolean isCustomerExists(String email,String password) throws SQLException;
    public void addCustomer(Customer customer) throws SQLException;
    public void updateCustomer(Customer customer) throws SQLException;
    public void deleteCustomer(int customerID) throws SQLException;
    public ArrayList<Customer> getAllCustomers() throws SQLException;
    public Customer getOneCustomer(int customerID) throws SQLException;
    public ArrayList<Coupon>getCustomerCoupons(int customerID)throws SQLException;
    public ArrayList<Coupon> getCustomerCoupons(Category category, int customerID)throws SQLException;
    public ArrayList<Coupon> getCustomerCoupons(double maxPrice, int customerID)throws SQLException;
    public Customer getCustomerByLogin(String email, String password)throws SQLException;
}
