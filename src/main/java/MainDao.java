import Entity.Run;
import dao.RunDao;
import jdbc.dao.JdbcRunDaoImpl;

import java.sql.SQLException;

public class MainDao {
    public static void main(String[] args) throws SQLException {
        RunDao runDao = new JdbcRunDaoImpl();
        Run run = runDao.findById(10l);
    }
}
