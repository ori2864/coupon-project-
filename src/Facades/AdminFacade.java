package Facades;

import Beans.Company;
import Beans.Customer;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CustomerDBDAO;
import Exceptions.ErrMsg;
import Exceptions.sqlCustomException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

@Data
@NoArgsConstructor
public class AdminFacade extends ClientFacade {

    @Override
    public Boolean login(String email, String password) throws sqlCustomException {
        if (!email.equals("admin@admin.com") || !password.equals("admin")) {
            throw new sqlCustomException(ErrMsg.WRONG_ADMIN_LOGIN);

        }
        return true;
    }


    public void addCompany(Company company) throws sqlCustomException {
        Boolean isExists = null;
        try {
            isExists = new CompanyDBDAO().isCompanyExists(company.getEmail(), company.getPassword());
            if (isExists) {
                throw new sqlCustomException(ErrMsg.COMPANY_ALREADY_EXISTS);
            } else {
                companyDAO.addCompany(company);
                System.out.println("company added successfully");
            }
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
        }
    }


    public void updateCompany(Company company) throws sqlCustomException {
        try {
            if (companyDAO.isCompanyExists(company.getEmail(), company.getPassword())) {
                companyDAO.updateCompany(company);
            } else throw new sqlCustomException(ErrMsg.COMPANY_DOES_NOT_EXIST);
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
        }
    }


    public void deleteCompany(int companyID) {
        try {
            new CompanyDBDAO().deleteCompany(companyID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
        }
    }


    public ArrayList<Company> getAllCompanies() {
        try {
            return new CompanyDBDAO().getAllCompanies();
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
            return null;
        }
    }


    public Company getOneCompany(int companyID) {
        try {
            return new CompanyDBDAO().getOneCompany(companyID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
            return null;
        }
    }


    public void addCustomer(Customer customer) throws sqlCustomException {
        try {
            Boolean isExists = new CustomerDBDAO().isCustomerExists(customer.getEmail(), customer.getPassword());
            if (isExists) {
                throw new sqlCustomException(ErrMsg.CUSTOMER_ALREADY_EXISTS);
            } else {
                new CustomerDBDAO().addCustomer(customer);
            }
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }

    }


    public void updateCustomer(Customer customer) {
        try {
            new CustomerDBDAO().updateCustomer(customer);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }
    }


    public void deleteCustomer(int customerID) {
        try {
            new CustomerDBDAO().deleteCustomer(customerID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - "+e.getMessage());
        }
    }


    public ArrayList<Customer> getAllCustomers() {
        try {
            return new CustomerDBDAO().getAllCustomers();
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
            return null;
        }
    }


    public Customer getOneCustomer(int customerID) {
        try {
            return new CustomerDBDAO().getOneCustomer(customerID);
        } catch (SQLException e) {
            System.out.println("an error has occurred - " + e.getMessage());
            return null;
        }
    }

}
