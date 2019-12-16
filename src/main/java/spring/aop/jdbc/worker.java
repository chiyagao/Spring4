package spring.aop.jdbc;

public class worker {

    private Integer id;
    private String workerName;
    private int age;
    private int job_id;
    private String job_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    @Override
    public String toString() {
        return "worker{" +
                "id=" + id +
                ", workerName='" + workerName + '\'' +
                ", age=" + age +
                ", job_id=" + job_id +
                ", job_name='" + job_name + '\'' +
                '}';
    }
}
