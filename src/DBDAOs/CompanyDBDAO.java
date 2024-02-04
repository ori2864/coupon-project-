package DBDAOs;

import Beans.Company;
import DAOs.CompanyDAO;
import Exceptions.sqlException;
import SQLcommands.companyCommands;
import SQLcommands.customerCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompanyDBDAO implements CompanyDAO {
    @Override
    public boolean isCompanyExists(String email, String password) throws sqlException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        ResultSet result= DButils.runQueryForResult(companyCommands.IS_COMPANY_EXISTS, params);
        try {
            while (result.next()) {
                return result.getInt("isExists") == 1;
            }
        } catch (SQLException err){
            throw new sqlException(err.getMessage());
        }
        return false;
    }

    @Override
    public void addCompany(Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        DButils.runQuery(companyCommands.ADD_COMPANY, params);
    }

    @Override
    public void updateCompany(Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        params.put(4, company.getId());
        DButils.runQuery(companyCommands.UPDATE_COMPANY, params);

    }

    @Override
    public void deleteCompany(int companyID) {
        DButils.runQueryWithIndex(companyCommands.DELETE_COMPANY, companyID);
    }

    @Override
    public ArrayList<Company> getAllCompanies() {
        ArrayList<Company> list = new ArrayList<>();
        ResultSet results = DButils.runQueryForResult(companyCommands.GET_ALL_COMPANIES, new HashMap<>());
        try {
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String email = results.getString(3);
                String password = results.getString(4);
                list.add(new Company(id,name, email, password));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        @Override
        public Company getOneCompany (int companyID){
            Company c= new Company();
            Map<Integer,Object> params = new HashMap<>();
            params.put(1,companyID);
            ResultSet results = DButils.runQueryForResult(companyCommands.GET_ONE_COMPANY,params);
            try {
                while (results.next()) {
                    int id = results.getInt(1);
                    String name = results.getString(2);
                    String email = results.getString(3);
                    String password = results.getString(4);
                    c= new Company(id,name, email, password,null);
                }
                return c;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


}

