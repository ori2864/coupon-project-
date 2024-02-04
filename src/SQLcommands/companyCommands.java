package SQLcommands;

public class companyCommands {
    public static final String IS_COMPANY_EXISTS="SELECT COUNT(*) as 'isExists' FROM `coupon`.`companies` WHERE `email`=? and `password`=?;";
    //2 values
    public static final String ADD_COMPANY = "INSERT INTO `coupon`.`companies` " +
            "(`name`,`email`,`password`)" +
            " VALUES (?,?,?);";

    public static final String DELETE_COMPANY = "DELETE FROM `coupon`.`companies` WHERE `id`=?";
    //1 index
    public static final String UPDATE_COMPANY = "UPDATE `coupon`.`companies` " +
            "SET `name` = ?, `email` = ?, `password` = ?" +
            " WHERE (`id` = ?);";
    //3 values 1 index
    public static final String GET_ALL_COMPANIES = "SELECT * FROM `coupon`.`companies`;";
    public static final String GET_ONE_COMPANY = "SELECT * FROM `coupon`.`companies` WHERE `id`=?;";
    //1 value
}

