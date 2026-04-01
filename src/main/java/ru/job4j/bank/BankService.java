package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        User sourceUser = findByPassport(sourcePassport);
        User destinationUser = findByPassport(destinationPassport);
        if (sourceUser != null && destinationUser != null) {
            List<Account> sourceAccounts = users.get(sourceUser);
            List<Account> destinationAccounts = users.get(destinationUser);
            Account sourceAccount = null;
            Account destinationAccount = null;

            for (Account account : sourceAccounts) {
                if (account.getRequisite().equals(sourceRequisite)) {
                    sourceAccount = account;
                    break;
                }

            }
            for (Account account : destinationAccounts) {
                if (account.getRequisite().equals(destinationRequisite)) {
                    destinationAccount = account;
                    break;
                }
            }
            if (sourceAccount != null && destinationAccount != null) {
                if (sourceAccount.getBalance() >= amount) {
                    sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                    destinationAccount.setBalance(destinationAccount.getBalance() + amount);
                    result = true;
                }
            }
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}