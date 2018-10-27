package jdbc.dao;

import Entity.Member;
import Entity.Run;
import dao.MemberDao;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberDaoImpl implements MemberDao {

    private Connection connection = JdbcUtils.getInstance().getConnection();

    public void save(Member member) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("insert into members(id, name, last_name, start_number, run_id) values(?, ?, ?, ?, ?)");

        statement.setLong(1, member.getId());
        statement.setString(2, member.getName());
        statement.setString(3, member.getLastName());
        statement.setInt(4, member.getStartNumber());
        statement.setLong(5, member.getRunId());

        statement.executeUpdate();
    }

    public Member findById(Long id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("select* from members where id=?");
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next() == true) {
            Member member = new Member();
            member.setId(resultSet.getLong("id"));
            member.setName(resultSet.getString("name"));
            member.setLastName(resultSet.getString("last_name"));
            member.setStartNumber(resultSet.getInt("start_number"));
            member.setRunId(resultSet.getLong("run_id"));

            return member;
        }

        return null;
    }

    public List<Member> findAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select* from members");

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Member> result = new ArrayList();

        while (resultSet.next() == true) {
            Member member = new Member();
            member.setId(resultSet.getLong("id"));
            member.setName(resultSet.getString("name"));
            member.setLastName(resultSet.getString("last_name"));
            member.setStartNumber(resultSet.getInt("start_number"));
            member.setRunId(resultSet.getLong("run_id"));
            result.add(member);
        }
        return result;
    }

    public void update(Member member) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("update members set id=?, name=?, place=?, START_DATE=?, start_Time=?, members_limit=?");

        statement.setLong(1, member.getId());
        statement.setString(2, member.getName());
        statement.setString(3, member.getLastName());
        statement.setInt(4, member.getStartNumber());
        statement.setLong(5, member.getRunId());

        statement.executeUpdate();
    }

    public void delete(Long id) throws SQLException {
        Member member = new Member();
        PreparedStatement statement = connection
                .prepareStatement("delete from runs where id =?");
        statement.setLong(1, member.getId());
        statement.executeUpdate();
    }

    public void deleteAll() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from members");
        statement.close();
    }
}
