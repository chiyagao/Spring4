package spring.beans.properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DB {

    private ApplicationContext ctx = null;

    {
        ctx = new ClassPathXmlApplicationContext("ioc/beans-properties.xml");
    }

    @Test
    public void textDataSource() throws SQLException {

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");

        System.out.println(dataSource.getConnection());
    }
}

