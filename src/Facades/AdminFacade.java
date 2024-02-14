package Facades;

import Beans.Company;
import Beans.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminFacade extends ClientFacade{
    @Override
    public Boolean login(String email, String password) {
        return super.login(email, password);
    }
    public void addCompany(Company company){

    }
    public void updateCompany(Company company){

    }
    public void deleteCompany(int CompanyID){

    }
    public ArrayList<Company> getAllCompanies(){
        return null;
    }
    public Company getOneCompany(int companyID){
        return null;
    }
    public void addCustomer(Customer customer){

    }
    public void updateCustomer(Customer customer){

    }
    public void deleteCustomer(int customerID){

    }
    public ArrayList<Customer> getAllCustomers(){
        return null;
    }
    public Customer getOneCustomer(int customerID){
        return null;
    }

}
