package jdbc.dao;

import Entity.Run;
import dao.RunDao;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunDaoImpl implements RunDao {

    private Connection connection = JdbcUtils.getInstance().getConnection();

    public void save(Run run) throws SQLException {
        //Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("insert into runs(id, name, place, start_date, start_time, members_limit) values(?, ?, ?, ?, ?, ?)");

        statement.setLong(1, run.getId());
        statement.setString(2, run.getName());
        statement.setString(3, run.getName());

        java.sql.Date sqlStartDate = new Date(run.getStartDate().getTime());
        java.sql.Date sqlStartTime = new Date(run.getStartTime().getTime());

        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, run.getMemberLimit());

        statement.executeUpdate();
    }

    public Run findById(Long id) throws SQLException {
        //Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("select* from runs where id=?");
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next() == true) {
            Run run = new Run();
            run.setId(resultSet.getLong("id"));
            run.setName(resultSet.getString("name"));
            run.setPlace(resultSet.getString("place"));
            run.setMemberLimit(resultSet.getInt("members_limit"));
            run.setStartDate(resultSet.getDate("start_date"));
            run.setStartTime(resultSet.getDate("start_time"));
            return run;
        }
        return null;
    }

    public List<Run> findAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select* from runs");

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Run> result = new ArrayList<Run>();

        while (resultSet.next() == true) {
            Run run = new Run();
            run.setId(resultSet.getLong("id"));
            run.setName(resultSet.getString("name"));
            run.setPlace(resultSet.getString("place"));
            run.setMemberLimit(resultSet.getInt("members_limit"));
            run.setStartDate(resultSet.getDate("start_date"));
            run.setStartTime(resultSet.getDate("start_time"));
            result.add(run);
        }
        return result;
    }

    public void update(Run run) throws SQLException {

        PreparedStatement statement = connection
                .prepareStatement("update runs set id=?, name=?, place=?, START_DATE=?, start_Time=?, members_limit=?");

        statement.setLong(1, run.getId());
        statement.setString(2, run.getName());
        statement.setString(3, run.getName());

        java.sql.Date sqlStartDate = new Date(run.getStartDate().getTime());
        java.sql.Date sqlStartTime = new Date(run.getStartTime().getTime());

        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, run.getMemberLimit());

        statement.executeUpdate();
    }

    public void delete(Long id) throws SQLException{

        Run run = new Run();
        PreparedStatement statement = connection
                .prepareStatement("delete from runs where id =?");
        statement.setLong(1, run.getId());
        statement.executeUpdate();
    }
}
