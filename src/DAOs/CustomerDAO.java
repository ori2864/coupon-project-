package DAOs;

import Beans.Customer;
import Exceptions.sqlException;

import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO {
    public Boolean isCustomerExists(String email,String password) throws sqlException;
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int customerID);
    public ArrayList<Customer> getAllCustomers();
    public Customer getOneCustomer(int customerID);
}
