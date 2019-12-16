package spring.aop.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//开发的时候就这样写：
@Repository
public class workerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public worker getWorker(Integer id){
        String sql = "SELECT id , name as workerName , age , job_id , job_name FROM worker WHERE id = ?";
        RowMapper<worker> rowMapper = new BeanPropertyRowMapper<>(worker.class);
        worker w = jdbcTemplate.queryForObject(sql,rowMapper,id);

        return w;
    }
}
