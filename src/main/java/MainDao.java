import Entity.Member;
import Entity.Run;
import dao.MemberDao;
import dao.RunDao;
import jdbc.dao.JdbcRunDaoImpl;
import providers.DaoProvider;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class MainDao {
    public static void main(String[] args) throws SQLException {
        RunDao runDao = DaoProvider.getInstance().getRunDao();
        MemberDao memberDao = DaoProvider.getInstance().getMemberDao();

        runDao.deleteAll();
        memberDao.deleteAll();

        long memberId = 1;
        for(int i = 1; i < 1000; i++) {
            Run run = new Run();
            run.setId((long)i);
            run.setName(UUID.randomUUID().toString());
            run.setStartTime(new java.util.Date());
            run.setStartDate(new java.util.Date());
            run.setMemberLimit(100);

            runDao.save(run);

            for(int j = 0; j < 10; j++) {
                Member member = new Member();
                member.setId(memberId++);
                member.setName(UUID.randomUUID().toString());
                member.setLastName(UUID.randomUUID().toString());
                member.setStartNumber((int)(Math.random()*100));
                member.setRunId(run.getId());

                memberDao.save(member);
            }
        }
        List<Run> runList = runDao.findAll();
        for(Run run : runList) {
            System.out.println(run.getName() + " members list: " + run.getMemberList().size());
        }
    }
}
