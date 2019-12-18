package spring.aop.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;

    {
        ctx = new ClassPathXmlApplicationContext("aop/applicationContext-jdbc.xml");
        bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
        bookShopService = (BookShopService) ctx.getBean("bookShopService");
    }

    /*
    *  事务，买书：
    * */
    @Test
    public void testBookShopService(){
        bookShopService.purchase("AA","1001");
    }



    @Test
    public void testUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",100);
    }

    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }



}
