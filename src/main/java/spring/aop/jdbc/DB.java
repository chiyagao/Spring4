package spring.aop.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DB {

    private ApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("aop/applicationContext-jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    /*
    * 批量更新：INSERT,UPDATE,DELETE
    * */
    @Test
    public  void  testBatchUpdate(){
        String sql = "INSERT INTO student(name,num,img,class) VALUES(?,?,?,?)";

        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA",1,"aa@.jpg","17物联网工程本科班"});
        batchArgs.add(new Object[]{"BB",2,"bb@.jpg","17物联网工程本科班"});
        batchArgs.add(new Object[]{"CC",3,"cc@.jpg","17物联网工程本科班"});
        batchArgs.add(new Object[]{"DD",4,"dd@.jpg","17物联网工程本科班"});
        batchArgs.add(new Object[]{"EE",5,"ee@.jpg","17物联网工程本科班"});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /*
    *INSERT,UPDATE,DELETE
    * */
    @Test
    public void textUpdate(){
        String sql = "UPDATE student SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,"Jack",5);
    }



    @Test
    public void textDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
