package com.acseed.practice.beginningspring.ch4.dao.impl;

import com.acseed.practice.beginningspring.ch4.dao.AccountDao;
import com.acseed.practice.beginningspring.ch4.domain.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by caohongchen on 17/2/17.
 */
public class AccountDaoJdbcImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Account account) {
//        jdbcTemplate.update()
    }

    public void update(Account account) {

    }

    public void update(List<Account> accounts) {

    }

    public void delete(long accountId) {

    }

    public Account find(final long accountId) {
        return jdbcTemplate.queryForObject("select id, owner_name, balance, access_time, locked from account where id = ?",
                new RowMapper<Account>() {
                    public Account mapRow(ResultSet rs, int i) throws SQLException {
                        Account account = new Account();
                        account.setId(rs.getLong("id"));
                        account.setOwnerName(rs.getString("owner_name"));
                        account.setBalance(rs.getDouble("balance"));
                        account.setAccessTime(rs.getTimestamp("access_time"));
                        account.setLocked(rs.getBoolean("locked"));
                        return account;
                    }
                }, accountId);
    }

    public List<Account> find(List<Long> accountIds) {
        return null;
    }

    public List<Account> find(boolean locked) {
        return null;
    }
}
