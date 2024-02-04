package DAOs;
import Beans.Company;
import Exceptions.sqlException;

import java.util.ArrayList;

public interface CompanyDAO {
    public boolean isCompanyExists(String email,String password) throws sqlException;
    public void addCompany(Company company);
    public void updateCompany(Company company);
    public void deleteCompany(int companyID);
    public ArrayList<Company> getAllCompanies();
    public Company getOneCompany(int companyID);


}
