package dao;

import Entity.Member;
import Entity.Run;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
    void save(Member member) throws SQLException;
    Member findById(Long id) throws SQLException;
    List<Member> findAll() throws SQLException;
    void update(Member member) throws SQLException;
    void delete(Long id) throws SQLException;
    void deleteAll() throws SQLException;
}
