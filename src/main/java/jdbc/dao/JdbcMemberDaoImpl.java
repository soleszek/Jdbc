package jdbc.dao;

import Entity.Run;
import dao.MemberDao;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcMemberDaoImpl implements MemberDao {

    private Connection connection = JdbcUtils.getInstance().getConnection();

    public void save(Run run) throws SQLException {
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
        return null;
    }

    public List<Run> findAll() throws SQLException {
        return null;
    }

    public void update(Run run) throws SQLException {

    }

    public void delete(Long id) throws SQLException {

    }
}
