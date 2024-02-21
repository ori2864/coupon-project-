package DBDAOs;

import Beans.Coupon;
import Beans.Customer;
import DAOs.CustomerDAO;
import SQLcommands.customerCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerDBDAO implements CustomerDAO {
    @Override
    public Boolean isCustomerExists(String email, String password) throws SQLException, SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        try {
            ResultSet result= DButils.runQueryForResult(customerCommands.IS_CUSTOMER_EXISTS, params);
            while (result.next()) {
                return result.getInt("isExists") == 1;
            }
        } catch (SQLException err){
            throw new SQLException(err.getMessage());
        }


        return false;

    }

    @Override
    public void addCustomer(Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        DButils.runQuery(customerCommands.ADD_CUSTOMER, params);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, customer.getId());
        DButils.runQuery(customerCommands.UPDATE_CUSTOMER, params);
    }

    @Override
    public void deleteCustomer(int customerID) {
        DButils.runQueryWithIndex(customerCommands.DELETE_CUSTOMER, customerID);

    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> list = new ArrayList<>();
        ResultSet results = DButils.runQueryForResult(customerCommands.GET_ALL_CUSTOMERS, new HashMap<>());
        try {
            while (results.next()) {
                int id = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                String email = results.getString(4);
                String password = results.getString(5);
                list.add(new Customer(id,firstName,lastName, email, password,new ArrayList<Coupon>()));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getOneCustomer(int customerID) {
        Customer c= new Customer();
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        ResultSet results = DButils.runQueryForResult(customerCommands.GET_ONE_CUSTOMER,params);
        try {
            while (results.next()) {
                int id = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                String email = results.getString(4);
                String password = results.getString(5);
                c= new Customer(id,firstName,lastName,email,password,null);
            }
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
