package spring.aop.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


/*
* 不推荐使用 JdbcDaoSupport，推荐使用 JdbcTemplate 作为 Dao 类的成员变量
* */
@Repository
public class jobDao extends JdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource){
        setDataSource(dataSource);
    }

    public job getJob(int id){
        String sql = "SELECT id,job_name FROM job WHERE id = ? ";
        RowMapper<job> rowMapper = new BeanPropertyRowMapper<>(job.class);
        //提供了getJdbcTemplate()
        return getJdbcTemplate().queryForObject(sql,rowMapper,id);
    }





}
