package com.company;

import java.sql.*;

public class Main {

    private static final String SQL_USER_NAME = "m";
    private static final String SQL_PASSWORD = "pass";
    private static final String URL = "jdbc:mysql://130.211.54.235:3306/";
    private static final String DB_NAME = "maayandb";

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        insertNewUser("Bree", "Politzer", "051234567", "bree@gmail.com", "waff waff");
        getUsers();

    }

    private static void insertNewUser(String firstName, String lastName, String phone, String email, String pass){
        String query = "INSERT INTO users (first_name, last_name, phone_number, email, password) VALUES (?,?,?,?,?)";

        // try with resources... closes automatically
        try(
                Connection con = DriverManager.getConnection(URL + DB_NAME, SQL_USER_NAME, SQL_PASSWORD);
                PreparedStatement preparedStatement = con.prepareStatement(query);
        ){
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, pass);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
        try {
            Connection con = DriverManager.getConnection(URL + DB_NAME, SQL_USER_NAME, SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        */
    }

    private static void getUsers(){
        try{
            Connection con = DriverManager.getConnection(URL + DB_NAME, SQL_USER_NAME, SQL_PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_name, email, password FROM users");
            while(resultSet.next()){
                String firstName = resultSet.getString(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                System.out.println(firstName + ", " + email + ", " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }



    }

}
