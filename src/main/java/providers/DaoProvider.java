package providers;

import dao.MemberDao;
import dao.RunDao;
import jdbc.dao.JdbcMemberDaoImpl;
import jdbc.dao.JdbcRunDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    private RunDao runDao;
    private MemberDao memberDao;

    private DaoProvider() {
        runDao = new JdbcRunDaoImpl();
        memberDao = new JdbcMemberDaoImpl();
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public RunDao getRunDao() {
        return runDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }
}
