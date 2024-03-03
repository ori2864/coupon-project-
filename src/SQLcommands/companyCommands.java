package SQLcommands;

import Connections.DBmanager;

import static Connections.DBmanager.SQL_DB;

public class companyCommands {
    public static final String IS_COMPANY_EXISTS="SELECT COUNT(*) as 'isExists' FROM `coupon`.`companies` WHERE `email`=? and `password`=?;";
    //2 values
    public static final String ADD_COMPANY =
            "INSERT INTO "+DBmanager.SQL_DB+".`companies` " +
            "(`name`,`email`,`password`)" +
            " VALUES (?,?,?);";

    public static final String DELETE_COMPANY = "DELETE FROM "+DBmanager.SQL_DB+".`companies` WHERE `id`=?";
    //1 index
    public static final String UPDATE_COMPANY = "UPDATE "+DBmanager.SQL_DB+".`companies` " +
            "SET  `email` = ?, `password` = ?" +
            " WHERE (`id` = ?);";
    //2 values 1 index
    public static final String GET_ALL_COMPANIES = "SELECT * FROM "+DBmanager.SQL_DB+".`companies`;";
    public static final String GET_ONE_COMPANY = "SELECT * FROM "+DBmanager.SQL_DB+".`companies` WHERE `id`=?;";
    //1 value
    public static final String GET_COMPANY_DETAILS = "SELECT * FROM "+DBmanager.SQL_DB+".`companies` WHERE `email`=? AND `password` = ?";

}

