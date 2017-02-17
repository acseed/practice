package com.acseed.practice.beginningspring.ch4.dao;

import com.acseed.practice.beginningspring.ch4.domain.Account;
import java.util.List;

/**
 * Created by caohongchen on 17/2/17.
 */
public interface AccountDao {
    void insert(Account account);

    void update(Account account);

    void update(List<Account> accounts);

    void delete(long accountId);

    Account find(long accoundId);

    List<Account> find(List<Long> accountIds);

    List<Account> find(boolean locked);

}
