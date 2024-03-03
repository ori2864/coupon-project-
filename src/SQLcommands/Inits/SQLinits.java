package SQLcommands.Inits;

import Connections.DBmanager;

import static Connections.DBmanager.SQL_DB;

public class SQLinits {
    public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS `"+DBmanager.SQL_DB+"`";
    public static final String DROP_DATABASE = "Drop DATABASE `" + DBmanager.SQL_DB+"`";
    public static final String CREATE_TABLE_COMPANIES ="CREATE TABLE IF NOT EXISTS "+DBmanager.SQL_DB+".`companies` (" +
            "  `id` int NOT NULL AUTO_INCREMENT," +
            "  `name` varchar(45) NOT NULL," +
            "  `email` varchar(45) NOT NULL," +
            "  `password` varchar(10) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  UNIQUE KEY `name_UNIQUE` (`name`)," +
            "  UNIQUE KEY `companiescol_UNIQUE` (`email`))";
    public static final String CREATE_TABLE_COUPONS="CREATE TABLE IF NOT EXISTS "+DBmanager.SQL_DB+".`coupons` (" +
            "  `id` int NOT NULL AUTO_INCREMENT," +
            "  `company_id` int NOT NULL," +
            "  `category_id` int NOT NULL," +
            "  `title` varchar(45) NOT NULL," +
            "  `description` varchar(45) NOT NULL," +
            "  `start_date` date NOT NULL," +
            "  `end_date` date NOT NULL," +
            "  `amount` int NOT NULL," +
            "  `price` double NOT NULL," +
            "  `image` varchar(45) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  KEY `company_id_key_idx` (`company_id`)," +
            "  KEY `category_id_key_idx` (`category_id`)," +
            "  CONSTRAINT `category_id_key` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE," +
            "  CONSTRAINT `company_id_key` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE" +

            ") ";
    public static final String CREATE_TABLE_CUSTOMERS=
            "CREATE TABLE IF NOT EXISTS "+DBmanager.SQL_DB+".`customers` (" +
            "  `id` int NOT NULL AUTO_INCREMENT," +
            "  `first_name` varchar(45) NOT NULL," +
            "  `last_name` varchar(45) NOT NULL," +
            "  `email` varchar(45) NOT NULL," +
            "  `password` varchar(45) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  UNIQUE KEY `email_UNIQUE` (`email`))";
    public static final String CREATE_TABLE_CUSTOMERS_VS_COUPONS=
            "CREATE TABLE IF NOT EXISTS "+DBmanager.SQL_DB+".`customers_vs_coupons` (" +
            "  `customer_id` int NOT NULL," +
            "  `coupon_id` int NOT NULL," +
            "  PRIMARY KEY (`customer_id`,`coupon_id`)," +
            "  KEY `coupon_id_key_idx` (`coupon_id`)," +
            "  CONSTRAINT `coupon_id_key` FOREIGN KEY (`coupon_id`)" +
                    " REFERENCES "+DBmanager.SQL_DB+".`coupons` (`id`) " +
                    "ON DELETE CASCADE " +
                    "ON UPDATE CASCADE," +
            "  CONSTRAINT `customer_id_key` FOREIGN KEY (`customer_id`)" +
                    " REFERENCES "+DBmanager.SQL_DB+".`customers` (`id`) " +
                    "ON DELETE CASCADE " +
                    "ON UPDATE CASCADE"+
                    ")";
    public static final String CREATE_TABLE_CATEGORIES =
            "CREATE TABLE IF NOT EXISTS "+DBmanager.SQL_DB+".`categories` (" +
            "  `id` int NOT NULL AUTO_INCREMENT," +
            "  `name` varchar(45) NOT NULL," +
            "  PRIMARY KEY (`id`)" +
            ")" ;
    public static final String CREATE_CATEGORIES_v1 =
       "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (`1`, 'food');" +
       "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (`2`, 'electricity');" +
       "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (`3`, 'restaurant');" +
       "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (`4`, 'vacation');";
    public static final String CREATE_CATEGORY=
            "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (?, ?);";
    public static final String CREATE_CATEGORY2=
            "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (?, ?); "+
            "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (?, ?); "+
            "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (?, ?); "+
            "INSERT INTO "+DBmanager.SQL_DB+".`categories` (`id`, `name`) VALUES (?, ?);";
}
