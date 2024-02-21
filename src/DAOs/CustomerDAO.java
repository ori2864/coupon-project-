package DAOs;

import Beans.Customer;
import Exceptions.sqlCustomException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    public Boolean isCustomerExists(String email,String password) throws sqlCustomException, SQLException;
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int customerID);
    public ArrayList<Customer> getAllCustomers();
    public Customer getOneCustomer(int customerID);
}
