package SQLcommands;

public class customerCommands {
    public static final String IS_CUSTOMER_EXISTS="SELECT COUNT(*) as 'isExists' FROM `coupon`.`customers` WHERE `email`=? and `password`=?;";

    public static final String ADD_CUSTOMER="INSERT INTO `coupon`.`customers` " +
            "(`first_name`,`last_name`,`email`,`password`)" +
            "VALUES (?,?,?,?);";


    public static final String UPDATE_CUSTOMER = "UPDATE `coupon`.`customers` " +
            "SET `first_name` = ?,`last_name` = ?, `email` = ?, `password` = ? " +
            "WHERE (`id` = ?);";
    //4 values 1 index


    public static final String DELETE_CUSTOMER = "DELETE FROM `coupon`.`customers` WHERE `id`=?";
    //1 index
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM `coupon`.`customers`;";
    public static final String GET_ONE_CUSTOMER = "SELECT * FROM `coupon`.`customers` WHERE `id`=?;";
    //1 value
}



