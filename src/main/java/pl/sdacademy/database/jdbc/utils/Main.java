package pl.sdacademy.database.jdbc.utils;

import java.sql.*;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        //insertRun(2, "Bieg po złote runo", "Malawa", new java.util.Date(), new java.util.Date(), 100);
        //deleteRun(2);

        //###########################
        /*for (int j = 3; j < 1000; j++) {
            String name = UUID.randomUUID().toString().substring(0, 7);
            String place = UUID.randomUUID().toString().substring(0, 7);
            int members_limit = (int) (Math.random() * 100);
            insertRun(j, name, place, new java.util.Date(), new java.util.Date(), members_limit);
        }*/

        deleteAllRuns();

        //printAllRuns();
        //updateRun();
        //System.out.println(UUID.randomUUID().toString().substring(0, 7));
        //System.out.println((int) (Math.random() * 100));
    }

    private static void insertRun(Integer id, String name, String place,
                                  java.util.Date startDate, java.util.Date startTime,
                                  int members_limit) throws SQLException {

        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("insert into runs(id, name, place, start_date, start_time, members_limit) values(?, ?, ?, ?, ?, ?)");

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, place);

        java.sql.Date sqlStartDate = new Date(startDate.getTime());
        java.sql.Date sqlStartTime = new Date(startTime.getTime());

        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, members_limit);

        statement.executeUpdate();
    }

    private static void deleteRun(Integer id) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("delete from runs where id =?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    private static void deleteAllRuns() throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from runs");
        statement.close();
    }

    private static void printAllRuns() throws SQLException{
        Connection connection = JdbcUtils.getInstance().getConnection();
        /*Statement statement = connection.createStatement();
        statement.execute("select * from runs");*/
        Statement  statment  = connection.createStatement();
        ResultSet  results  = statment.executeQuery("SELECT  name  FROM  runs");
        while(results.next()) {
            String  invoiceName  = results.getString("name");
            System.out.println(invoiceName);}
        connection.close();
    }

    private static void updateRun(Integer id, String name, String place,
                                  java.util.Date startDate, java.util.Date startTime,
                                  int members_limit) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("update runs set id=?, name=?, place=?, startTime=?, startTime=?, members_limit=?");

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, place);

        java.sql.Date sqlStartDate = new Date(startDate.getTime());
        java.sql.Date sqlStartTime = new Date(startTime.getTime());

        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, members_limit);

        statement.executeUpdate();

    }

}
