import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import DBDAOs.DButils;
import Exceptions.sqlException;
import SQLcommands.companyCommands;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws sqlException {
        //Company company=new Company(1, "ori3 company","ori3@ori2","333",new ArrayList<Coupon>());
        //ArrayList<Company>list=new CompanyDBDAO().getAllCompanies();
        //list.forEach(System.out::println);
        //System.out.println(new CompanyDBDAO().getOneCompany(15));
        // new CompanyDBDAO().deleteCompany(18);
        //Customer customer = new Customer(1,"ffff","shshsh","xxxxxd@dggd","dwdwd",new ArrayList<Coupon>());
        // new CustomerDBDAO().addCustomer(customer);
        //new CustomerDBDAO().updateCustomer(customer);
        //new CustomerDBDAO().deleteCustomer(1);
        //ArrayList<Customer>list = new CustomerDBDAO().getAllCustomers();
        //list.forEach(System.out::println);
        //System.out.println(new CustomerDBDAO().getOneCustomer(2) );
       // System.out.println(new CustomerDBDAO().isCustomerExists("xxxxxd@dggd","dwdwd"));
        //System.out.println(new CompanyDBDAO().isCompanyExists("e","212"));
          Date d=new Date(123,02,9);
       // Coupon coupon= new Coupon(17,833,"coupi",
         //       "a nice coupon",d,new Date(123,03,11)
           //     ,12,30.01,"jpgekek");
        //ArrayList<Coupon>couponArrayList=new CouponDBDAO().getAllCoupons();
        //couponArrayList.forEach(System.out::println);
        System.out.println(new CouponDBDAO().getOneCoupon(2));
    }
}