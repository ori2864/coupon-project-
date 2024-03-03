package SQLcommands;

import Connections.DBmanager;

public class couponCommands {
    public static final String ADD_COUPON="INSERT INTO "+ DBmanager.SQL_DB+".`coupons`" +
            "(`company_id`,`category_id`,`title`,`description`,`start_date`" +
            ",`end_date`,`amount`,`price`,`image`)" +
            "SELECT ?,?,?,?,?,?,?,?,?  " +
            "WHERE NOT EXISTS (" +
            "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` WHERE `company_id` = ? AND `title` = ?)";
public static final String UPDATE_COUPON="UPDATE "+DBmanager.SQL_DB+".`coupons` " +
        "SET `company_id` = ?, `category_id` = ?, `title` = ?," +
        " `description` = ?, `start_date` = ?, " +
        "`end_date` = ?, `amount` = ?, `price` = ?, `image` = ?" +
        " WHERE (`id` = ?);";
//9 values 1 index
    public static final String DELETE_COUPON="DELETE FROM "+DBmanager.SQL_DB+".`coupons` WHERE (`id` = ?);";
    //1 index
    public static final String GET_ALL_COUPONS="SELECT * FROM "+DBmanager.SQL_DB+".`coupons`;";
    public static final String GET_ONE_COUPON="SELECT * FROM "+DBmanager.SQL_DB+".`coupons` WHERE `id`=?;";

    public static final String COUPON_PURCHASE_AMOUNT_UPDATE=
            "UPDATE "+DBmanager.SQL_DB+".`coupons` SET `amount` =`amount`-1 WHERE (`id` = ?);";
    public static final String GET_COMPANY_COUPONS = "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` WHERE `company_id` = ?";
    public static final String GET_COMPANY_COUPONS_BY_CATEGORY = "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` WHERE `category_id` = ? AND `company_id` = ?";
    public static final String GET_COMPANY_COUPONS_BELOW_PRICE = "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` WHERE `price` < ? AND `company_id` = ?";
    public static final String GET_CUSTOMER_COUPONS=
            "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` " +
                    "WHERE `id` = ANY(SELECT `coupon_id` " +
                    "FROM "+DBmanager.SQL_DB+".`customers_vs_coupons` " +
                    "WHERE `customer_id`=?)";
    public static final String GET_CUSTOMER_COUPONS_BY_CATEGORY =
            "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` " +
                    "WHERE `id` = ANY(SELECT `coupon_id` " +
                    "FROM "+DBmanager.SQL_DB+".`customers_vs_coupons` " +
                    "WHERE `customer_id`=?)AND `category_id`=?";
    public static final String GET_CUSTOMER_COUPONS_BELOW_PRICE =
            "SELECT * FROM "+DBmanager.SQL_DB+".`coupons` " +
                    "WHERE `id` = ANY(SELECT `coupon_id` " +
                    "FROM "+DBmanager.SQL_DB+".`customers_vs_coupons` " +
                    "WHERE `customer_id`=?)AND `price`<?";
}
