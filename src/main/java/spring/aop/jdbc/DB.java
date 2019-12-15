package spring.aop.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;


public class DB {

    private ApplicationContext ctx = null;

    {
        ctx = new ClassPathXmlApplicationContext("aop/applicationContext-jdbc.xml");
    }

    @Test
    public void textDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
