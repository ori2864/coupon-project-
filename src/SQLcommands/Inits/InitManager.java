package SQLcommands.Inits;



import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import Connections.DBmanager;
import DBDAOs.CompanyDBDAO;
import DBDAOs.CouponDBDAO;
import DBDAOs.CustomerDBDAO;
import DBDAOs.DButils;
import com.mysql.cj.QueryResult;
import lombok.Getter;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class InitManager {

        public static void createDB(){
            System.out.println("database created: "+DButils.runQuery(SQLinits.CREATE_DATABASE));
        }
        private static void dropDB(){
            System.out.println("database dropped: "+DButils.runQuery(SQLinits.DROP_DATABASE));
        }

        public static void createCompaniesTable(){
            System.out.println("companies table created: "+DButils.runQuery(SQLinits.CREATE_TABLE_COMPANIES));
            }
        public static void createCategoriesTable(){
            System.out.println("categories table created: "+DButils.runQuery(SQLinits.CREATE_TABLE_CATEGORIES));
        }
        public static void createCouponsTable(){
            System.out.println("coupons table created: "+DButils.runQuery(SQLinits.CREATE_TABLE_COUPONS));
        }
    public static void createCustomersTable(){
        System.out.println("customers table created: "+DButils.runQuery(SQLinits.CREATE_TABLE_CUSTOMERS));
    }
        public static void createCvcTable(){
            System.out.println("cvc table created: "+DButils.runQuery(SQLinits.CREATE_TABLE_CUSTOMERS_VS_COUPONS));
        }

        //todo insert categories
        public static void  insertCategories(){




//            ArrayList<Object>params=new ArrayList<>();
//            String query = "";
//            ArrayList<String>data=new ArrayList<>();
//            int index=0;
//            //iterating through all the categories and adding them to params in order to insert them
//            for(int i = 0; i< Category.values().length; i++)
//            {
//                data.add(SQLinits.CREATE_CATEGORY);
//                query+=" "+SQLinits.CREATE_CATEGORY+"\n";
//                params.add(index++,Category.values()[i].ordinal()+1);
//                params.add(index++,Category.values()[i].toString());
//            DButils.runQuery(SQLinits.CREATE_CATEGORIES_v1);
//            }
//            try {
//                DButils.runQuery(query,params);
//                DButils.runQuery(SQLinits.CREATE_CATEGORY2,params);
//                DButils.MultiRunQuery(data,params,2);}
//            } catch (SQLException e) {
//                System.out.println("an error has occurred while inserting categories - "+e.getMessage());
//            }
//            System.out.println(query);
//            QueryResult queryResult = DButils.runQuery(Categories.INSERT_CATEGORIES(params.size()),params);
//            if(queryResult.isResult())
//                System.out.println(DBmanager.SQL_CATEGORIES + " were inserted");
//            else {
//                if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
//                        && queryResult.getExceptionID() != 0) {
//                    System.out.println(DBmanager.SQL_CATEGORIES + " weren't inserted");
//                }
//            }
        }
//        private static void handleInsertTable(QueryResult queryResult,String table){
//            if(queryResult.isResult()) {
//                System.out.println(table + " created");
//            }
//            else {
//                if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
//                        && queryResult.getExceptionID() != 0) {
//                    System.out.println(table + " is not created");
//                }
//            }
//        }
//        /**
//         * Inserting demo data for showcasing the program
//         */
//        private static void insertDemoData() throws CouponSystemException, SQLException {
//            //Adding demmy companies
//            new CompaniesDBDAO().addCompany(new Company("Demmy",
//                    "hardCodedCompany@email.com","12345678"));
//            new CompaniesDBDAO().addCompany(new Company("Demy",
//                    "hardCodedCompany22@email.com","12345678"));
//            //Adding coupons to company
//            LocalDate date =  LocalDate.now();
//            new CouponDBDAO().addCoupon(new Coupon(2
//                    ,Category.Electricity
//                    ,"lamp","30% on lamps"
//                    ,Date.valueOf(date),Date.valueOf(date.plusDays(5)),
//                    5
//                    ,5.0,
//                    "awesomePicture"));
//            new CouponDBDAO().addCoupon(new Coupon(2
//                    ,Category.Electricity
//                    ,"bulb"
//                    ,"30% on bulb"
//                    , Date.valueOf(date)
//                    ,Date.valueOf(date.plusDays(5))
//                    ,5
//                    ,5.0
//                    ,"awesomePicture"));
//            new CouponDBDAO().addCoupon(new Coupon(2
//                    ,Category.Electricity
//                    ,"bulbs"
//                    ,"45% on bulb"
//                    , Date.valueOf(date.minusDays(10))
//                    ,Date.valueOf(date.minusDays(5))
//                    ,5
//                    ,5.0
//                    ,"awesomePicture"));
//            new CouponDBDAO().addCoupon(new Coupon(1
//                    ,Category.Electricity
//                    ,"bulb"
//                    ,"30% on bulb"
//                    , Date.valueOf(date)
//                    ,Date.valueOf(date.plusDays(5))
//                    ,5
//                    ,5.0
//                    ,"awesomePicture"));
//            //Adding admin and demmy customers
//            new CustomerDBDAO().addCustomer(new Customer("Admin", "Nimda",
//                    DBmanager.SQL_ADMIN_EMAIL,DBmanager.SQL_ADMIN_PASSWORD));
//            new CustomerDBDAO().addCustomer(new Customer("Demmy", "Data",
//                    "hardCodedCustomer@email.com","12345678"));
//            new CustomerDBDAO().addCustomer(new Customer("Demmy2", "Data",
//                    "hardCodedCustomer22@email.com","12345678"));
//            //Adding coupon to customer
//            new CouponDBDAO().addCouponPurchase(3,3);
//            new CouponDBDAO().addCouponPurchase(3,2);
//            new CouponDBDAO().addCouponPurchase(3,1);
//
//        }
//        public static void initSQL(){
//            createDB();
//            createCompaniesTable();
//            createCategoriesTable();
//            createCustomersTable();
//            createCouponsTable();
//            createCvcTable();
//            insertCategories();
//            try{
//                System.out.println("Adding demo data...");
//                insertDemoData();
//            } catch (CouponSystemException | SQLException e) {
//                //There is no reason to panic
//                //It just means the demo data is already inside the database...
//            }
//        }



    public static void insertDemoData() throws SQLException {
        //Adding demo companies
        new CompanyDBDAO().addCompany(new Company("ori1 company",
                "ori1@example.com","12345678"));
        new CompanyDBDAO().addCompany(new Company("ori2 company",
                "ori2@example.com","12345678"));
        new CompanyDBDAO().addCompany(new Company("ori3 company",
                "ori3@example.com","12345678"));
        new CompanyDBDAO().addCompany(new Company("ori4 company",
                "ori4@example.com","12345678"));
        new CompanyDBDAO().addCompany(new Company("ori5 company",
                "ori5@example.com","12345678"));
//        Adding demo coupons to company
        LocalDate date =  LocalDate.now();
        new CouponDBDAO().addCoupon(new Coupon(2
                ,Category.electricity
                ,"oven","20% discount on this oven"
                ,Date.valueOf(date),Date.valueOf(date.plusDays(5)),
                5
                ,12.0,
                "awesomePicture"));
        new CouponDBDAO().addCoupon(new Coupon(2
                ,Category.electricity
                ,"bulb"
                ,"30% on bulb"
                , Date.valueOf(date)
                ,Date.valueOf(date.plusDays(5))
                ,5
                ,5.0
                ,"awesomePicture"));
        new CouponDBDAO().addCoupon(new Coupon(2
                ,Category.electricity
                ,"phone"
                ,"5% on phone"
                , Date.valueOf(date.minusDays(10))
                ,Date.valueOf(date.minusDays(5))
                ,5
                ,15.0
                ,"awesomePicture"));
        new CouponDBDAO().addCoupon(new Coupon(1
                ,Category.electricity
                ,"camera"
                ,"10% on bulb"
                , Date.valueOf(date)
                ,Date.valueOf(date.plusDays(5))
                ,5
                ,15.0
                ,"awesomePicture"));
        //Adding demo customers
        new CustomerDBDAO().addCustomer(new Customer("Admin", "Istrator",
                "admin@admin.com","admin",null));
        new CustomerDBDAO().addCustomer(new Customer("John", "demo",
                "john@example.com","12345678",null));
        new CustomerDBDAO().addCustomer(new Customer("Jeff", "demo",
                "jeff@example.com","12345678",null));
        //Adding demo coupons to customer
        new CouponDBDAO().addCouponPurchase(3,1);
        new CouponDBDAO().addCouponPurchase(3,2);
        new CouponDBDAO().addCouponPurchase(3,3);

    }

}

