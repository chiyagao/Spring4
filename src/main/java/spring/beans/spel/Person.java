package spring.beans.spel;

public class Person {

    private String name;
    private Car car;

    //引用 address bean 的 city 属性
    private String City;

    //根据 car 的 price 确定 info:
    //price >= 300000;金领
    //否则;白领
    private String info;
    private String mail;
    private Boolean isMail;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMail(Boolean mail) {
        isMail = mail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", City='" + City + '\'' +
                ", info='" + info + '\'' +
                ", mail='" + mail + '\'' +
                ", isMail=" + isMail +
                '}';
    }

    public void setIsMail(boolean isMail) {
        this.isMail = isMail;
    }

    public boolean getIsMail() {
        return isMail;
    }
}
