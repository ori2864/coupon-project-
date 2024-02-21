package SQLcommands;

public class couponCommands {
    public static final String ADD_COUPON="INSERT INTO `coupon`.`coupons` " +
            "(`company_id`,`category_id`,`title`,`description`," +
            "`start_date`,`end_date`,`amount`,`price`,`image`)" +
            "VALUES (?,?,?,?,?,?,?,?,?);";
public static final String UPDATE_COUPON="UPDATE `coupon`.`coupons` " +
        "SET `company_id` = ?, `category_id` = ?, `title` = ?," +
        " `description` = ?, `start_date` = ?, " +
        "`end_date` = ?, `amount` = ?, `price` = ?, `image` = ?" +
        " WHERE (`id` = ?);";
//9 values 1 index
    public static final String DELETE_COUPON="DELETE FROM `coupon`.`coupons` WHERE (`id` = ?);";
    //1 index
    public static final String GET_ALL_COUPONS="SELECT * FROM `coupon`.`coupons`;";
    public static final String GET_ONE_COUPON="SELECT * FROM `coupon`.`coupons` WHERE `id`=?;";
    //TODO ADD&DELETE COUPON PURCHASES
    public static final String COUPON_PURCHASE_AMOUNT_UPDATE=
            "UPDATE `coupon`.`coupons` SET `amount` =`amount`-1 WHERE (`id` = ?);";
    public static final String GET_COMPANY_COUPONS = "SELECT * FROM coupon.coupons WHERE `company_id` = ?";
    public static final String GET_COUPONS_BY_CATEGORY = "SELECT * FROM `coupon`.`coupons` WHERE `category_id` = ?";
    public static final String GET_COUPONS_BELOW_PRICE = "SELECT * FROM `coupon`.`coupons` WHERE `price` < ?";

}
