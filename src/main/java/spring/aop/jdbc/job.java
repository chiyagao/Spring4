package spring.aop.jdbc;

public class job {

    private int id;
    private String job_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    @Override
    public String toString() {
        return "job{" +
                "id=" + id +
                ", job_name='" + job_name + '\'' +
                '}';
    }
}
