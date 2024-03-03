package SQLcommands;

import Connections.DBmanager;

public class customerCommands {
    public static final String IS_CUSTOMER_EXISTS="SELECT COUNT(*) as 'isExists' FROM "+ DBmanager.SQL_DB+".`customers` WHERE `email`=? and `password`=?;";

    public static final String ADD_CUSTOMER="INSERT INTO "+DBmanager.SQL_DB+".`customers` " +
            "(`first_name`,`last_name`,`email`,`password`)" +
            "VALUES (?,?,?,?);";


    public static final String UPDATE_CUSTOMER = "UPDATE "+DBmanager.SQL_DB+".`customers` " +
            "SET `first_name` = ?,`last_name` = ?, `email` = ?, `password` = ? " +
            "WHERE (`id` = ?);";
    //4 values 1 index


    public static final String DELETE_CUSTOMER = "DELETE FROM "+DBmanager.SQL_DB+".`customers` WHERE `id`=?";
    //1 index
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM "+DBmanager.SQL_DB+".`customers`;";
    public static final String GET_ONE_CUSTOMER = "SELECT * FROM "+DBmanager.SQL_DB+".`customers` WHERE `id`=?;";
    //1 value
    public static final String GET_CUSTOMER_DETAILS="SELECT * FROM "+DBmanager.SQL_DB+".`customers` WHERE `email`=? AND `password` = ?";
}



