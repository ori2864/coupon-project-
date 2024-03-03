import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import DBDAOs.DButils;
import Exceptions.sqlCustomException;
import Facades.CompanyFacade;
import Facades.AdminFacade;
import Facades.CompanyFacade;
import Facades.CustomerFacade;
import SQLcommands.Inits.InitManager;
import SQLcommands.customerCommands;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static Beans.Category.*;
import static SQLcommands.Inits.InitManager.*;

public class Main {
    public static void main(String[] args) throws sqlCustomException, SQLException, InterruptedException {
        Company company=new Company(-23, "exle","ori3@testing","3e553",new ArrayList<Coupon>());
      //  System.out.println(new CustomerDBDAO().getCustomerCoupons(22,7));
        //new CustomerFacade(7).purchaseCoupon(new Coupon().builder().id(4).build());
        //new CompanyDBDAO().addCompany(company);
       // new CompanyDBDAO().updateCompany(company);
       // new AdminFacade().updateCompany(company);
        //ArrayList<Company>list=new CompanyDBDAO().getAllCompanies();
        //list.forEach(System.out::println);
        //System.out.println(new CompanyDBDAO().getOneCompany(15));
        // new CompanyDBDAO().deleteCompany(18);
  //      Customer customer = new Customer(1,"kkjkj","shshsh","ttftft@ppopo","cccvcvc",new ArrayList<Coupon>());
        // new CustomerDBDAO().addCustomer(customer);
//        HashMap<Integer,Object>params=new HashMap<>();
//        params.put(1,customer.getFirstName());
//        params.put(2,customer.getLastName());
//        params.put(3,customer.getEmail());
//        params.put(4,customer.getPassword());
//        Boolean b=DButils.runQuery(customerCommands.ADD_CUSTOMER,params);
//        System.out.println(b);
        //new CustomerDBDAO().updateCustomer(customer);
        //new CustomerDBDAO().deleteCustomer(1);
        //ArrayList<Customer>list = new CustomerDBDAO().getAllCustomers();
        //list.forEach(System.out::println);
        //System.out.println(new CustomerDBDAO().getOneCustomer(2) );
       // System.out.println(new CustomerDBDAO().isCustomerExists("xxxxxd@dggd","dwdwd"));
        //System.out.println(new CompanyDBDAO().isCompanyExists("e","212"));
//          Date d=new Date(123,02,9);
       // Coupon coupon= new Coupon(17,833,"coupi",
         //       "a nice coupon",d,new Date(123,03,11)
           //     ,12,30.01,"jpgekek");
        //ArrayList<Coupon>couponArrayList=new CouponDBDAO().getAllCoupons();
        //couponArrayList.forEach(System.out::println);
//        System.out.println(new CouponDBDAO().getOneCoupon(3));
       // DailyJob.CouponExpirationDailyJob job=new DailyJob.CouponExpirationDailyJob();
        //job.run();
//        InitManager.createDB();
//
//         createCompaniesTable();
//
//         createCategoriesTable();
//
//         createCouponsTable();
//
//         createCustomersTable();
//
//         createCvcTable();
        insertDemoData();
     // job.stop();
    }
}