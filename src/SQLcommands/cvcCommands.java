package SQLcommands;

public class cvcCommands {
    public static final String ADD_CVC_COUPON_PURCHASE=
            "INSERT INTO `coupon`.`customers_vs_coupons` (`customer_id`, `coupon_id`) " +
            "SELECT ?, ? " +
            "WHERE EXISTS (SELECT 1 FROM `coupon`.`coupons` " +
            "WHERE `id` = ? AND `amount` >= 1);";
    public static final String DELETE_CVC_COUPON_PURCHASE =
            "DELETE FROM `coupon`.`customers_vs_coupons` " +
            "WHERE (`customer_id` = ?) and (`coupon_id` = ?);";
    public static final String GET_ALL_COUPONS_FOR_CUSTOMER =
            "SELECT * FROM `coupon`.`customers_vs_coupons` WHERE `customer_id` = ?";
}
