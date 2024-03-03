package SQLcommands;

import Connections.DBmanager;

public class cvcCommands {
    public static final String ADD_CVC_COUPON_PURCHASE=
            "INSERT INTO "+ DBmanager.SQL_DB+".`customers_vs_coupons` (`customer_id`, `coupon_id`) " +
            "SELECT ?, ? " +
            "WHERE EXISTS (SELECT 1 FROM "+DBmanager.SQL_DB+".`coupons` " +
            "WHERE `id` = ? AND `amount` >= 1);";
    public static final String DELETE_CVC_COUPON_PURCHASE =
            "DELETE FROM "+DBmanager.SQL_DB+".`customers_vs_coupons` " +
            "WHERE (`customer_id` = ?) and (`coupon_id` = ?);";
    public static final String GET_ALL_COUPONS_FOR_CUSTOMER =
            "SELECT * FROM "+DBmanager.SQL_DB+".`customers_vs_coupons` WHERE `customer_id` = ?";

    public static final String GET_COUPON_PURCHASES_BY_CATEGORY =
            "SELECT * FROM "+DBmanager.SQL_DB+".`customers_vs_coupons` " +
                    "WHERE `customer_id`=?  " +
                    "AND `coupon_id` = ANY (SELECT `id` FROM "+DBmanager.SQL_DB+".`coupons` " +
                    "WHERE `category_id`=?);";
}
