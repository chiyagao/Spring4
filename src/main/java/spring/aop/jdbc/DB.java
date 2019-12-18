package spring.aop.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DB {

    private ApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;
    private workerDao workerDao;
    private jobDao jobDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("aop/applicationContext-jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        workerDao = ctx.getBean(workerDao.class);
        jobDao = ctx.getBean(jobDao.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);

    }

    /*
    *使用具名参数，可以使用update(String sql,org.springframework.jdbc.core.namedparam.SqlParameterSource paramSource)进行更新
    * 1.SQL 语句中的参数名和封装类的属性一致！
    * 2.使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数。
    * */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO worker(name,age,job_id,job_name) " +
                "VALUES (:workerName,:age,:job_id,:job_name)";

        worker w = new worker();
        w.setWorkerName("ABC");
        w.setAge(18);
        w.setJob_id(2);
        w.setJob_name("拖地");

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(w);
        namedParameterJdbcTemplate.update(sql,paramSource);
    }


    /*
    * 使用具名参数update(String sql,java.util.Map<String, ?> paramMap) 进行更新
    * 1.多个参数，对应参数名，便于维护
    * 2.没有封装类也可以对应参数名。
    * */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO worker(name,age,job_id,job_name) VALUES (:name,:age,:jId,:jName)";

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("name","FF");
        paramMap.put("age","20");
        paramMap.put("jId","1");
        paramMap.put("jName","扫地");

        namedParameterJdbcTemplate.update(sql,paramMap);
    }


    /*
    * 使用class jobDao extends JdbcDaoSupport
    * */
    @Test
    public void testJobDao(){
        System.out.println(jobDao.getJob(1));
    }

    /*
    * 测试tworkerDao
    * */
    @Test
    public void testWorkerDao(){
        System.out.println(workerDao.getWorker(1));
    }



    /*
    * 获取单个列的值，或做统计查询
    * 使用 queryForObject(String sql,Class<Long> requiredType)
    * */
    @Test
    public void testQueryForObject1(){
        String sql = "SELECT count(id) FROM worker";
        long count = jdbcTemplate.queryForObject(sql,Long.class);

        System.out.println(count);
    }

    /*
    * 查询实体类的集合
    * 使用 query 而不是 queryForObject 方法
    * */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id , name , age , job_id , job_name FROM worker WHERE id > ?";
        RowMapper<worker> rowMapper = new BeanPropertyRowMapper<>(worker.class);
        List<worker> workers = jdbcTemplate.query(sql,rowMapper,3);

        System.out.println(workers);
    }


    /*
    * 从数据库中获取一条记录，实际得到对应的一个对象
    * 调用 queryForObject(String sql , RowMapper<E> , Object... args)方法：
    * 1. RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
    * 2. SQL 中实现了 表的列名和类的属性名之间映射，例如 name as workerName ，name 为表中字段， workerName 为类的属性。
    * 3. 不支持级联属性，即不支持映射到其他表名.字段名。
    * */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id, name as workerName ,age,job_id as Job,job_name as 'job_name' FROM worker WHERE id = ?";
        RowMapper<worker> rowMapper = new BeanPropertyRowMapper<>(worker.class);
        worker a = jdbcTemplate.queryForObject(sql,rowMapper,1);

        System.out.println(a);
    }


    /*
    * 批量更新：INSERT,UPDATE,DELETE
    * 最后一个参数是 Object[] 的 List 类型
    * */
    @Test
    public  void  testBatchUpdate(){
        String sql = "INSERT INTO worker(name,age,job_id,job_name) VALUES(?,?,?)";

        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA",1,3,"洗碗"});
        batchArgs.add(new Object[]{"BB",2,2,"拖地"});
        batchArgs.add(new Object[]{"CC",3,4,"倒垃圾"});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /*
    *INSERT,UPDATE,DELETE
    * */
    @Test
    public void textUpdate(){
        String sql = "UPDATE worker SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,"Jack",2);
    }



    @Test
    public void textDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
