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

@Data
@NoArgsConstructor
public class AdminFacade extends ClientFacade{
    //@TODO exceptions
    @Override
    public Boolean login(String email, String password) throws sqlCustomException {
        if (!email.equals("admin@admin.com")||!password.equals("admin")){
            throw new sqlCustomException(ErrMsg.WRONG_ADMIN_LOGIN);

        }
       return true;
        }

    public void addCompany(Company company) throws sqlCustomException, SQLException {
        Boolean isExists=new CompanyDBDAO().isCompanyExists(company.getEmail(),company.getPassword());
        if (isExists) {
            throw new sqlCustomException(ErrMsg.COMPANY_ALREADY_EXISTS);
        }
        else new CompanyDBDAO().addCompany(company);
    }
    public void updateCompany(Company company){
        new CompanyDBDAO().updateCompany(company);
    }
    public void deleteCompany(int companyID){
        new CompanyDBDAO().deleteCompany(companyID);
    }
    public ArrayList<Company> getAllCompanies(){
        return new CompanyDBDAO().getAllCompanies();
    }
    public Company getOneCompany(int companyID){
        return new CompanyDBDAO().getOneCompany(companyID);
    }
    public void addCustomer(Customer customer) throws SQLException, sqlCustomException {
        Boolean isExists=new CustomerDBDAO().isCustomerExists(customer.getEmail(),customer.getPassword());
        if (isExists) {
            throw new sqlCustomException(ErrMsg.CUSTOMER_ALREADY_EXISTS);
        }
        else new CustomerDBDAO().addCustomer(customer);
    }
    public void updateCustomer(Customer customer){
        new CustomerDBDAO().updateCustomer(customer);
    }
    public void deleteCustomer(int customerID){
        new CustomerDBDAO().deleteCustomer(customerID);
        //@todo delete purchase
    }
    public ArrayList<Customer> getAllCustomers(){
        return new CustomerDBDAO().getAllCustomers();
    }
    public Customer getOneCustomer(int customerID){
        return new CustomerDBDAO().getOneCustomer(customerID);
    }

}
