package com.acseed.practice.beginningspring.ch4;

import com.acseed.practice.beginningspring.ch4.dao.AccountDao;
import com.acseed.practice.beginningspring.ch4.domain.Account;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by caohongchen on 17/2/16.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch4Configuration.class);
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
//        Connection connection = dataSource.getConnection();
////
//        System.out.println(connection.isClosed());
//        connection.close();
//        System.out.println(connection.isClosed());

        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
//        System.out.println(accountDao);
//        Account account = new Account();
//        account.setLocked(false);
//        account.setOwnerName("john doe");
//        account.setBalance(10000);
//        account.setAccessTime(new Date());
//        accountDao.insert(account);

        Account account = accountDao.find(100L);
        System.out.println(account.getId());
        System.out.println(account.getOwnerName());
        System.out.println(account.getAccessTime() );
        System.out.println(account.getBalance());
        System.out.println(account.isLocked());
    }
}
