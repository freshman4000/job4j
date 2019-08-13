package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class that manages clients db and processes transfers.
 */
public class Bank {
    /**
     * Database of the clients and accounts.
     */
    private static Map<User, List<Account>> clients = new HashMap<>();

    /**
     * Inner static class - Bank singleton initializer.
     */
    private static final class Inner {
        private static final Bank INSTANCE = new Bank();
    }

    /**
     * Bank singleton getter.
     */
    public static Bank getBank = Inner.INSTANCE;

    /**
     * Constructor.
     **/
    private Bank() {
    }

    /**
     * Adds new user.
     *
     * @param user to be added.
     **/
    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Deletes user.
     *
     * @param user which was deleted.
     */
    public void deleteUser(User user) {
        if (clients.get(user) != null) {
            clients.remove(user);
        }
    }

    /**
     * Adds account to user.
     *
     * @param passport of user.
     * @param account  of user.
     */
    public void addAccountToUser(String passport, Account account) {
        Optional<User> us = clients.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
        us.ifPresent(user -> clients.get(user).add(account));
    }

    /**
     * Remove account from user.
     *
     * @param passport of user.
     * @param account  of user.
     */
    public void deleteAccountFromUser(String passport, Account account) {
       Optional<User> us = clients.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
        us.ifPresent(user -> clients.get(user).remove(account));
    }

    /**
     * Returns list of users accounts.
     *
     * @param passport of the user.
     * @return list of users accounts.
     */
    public List<Account> getUserAccounts(String passport) {
        return clients.entrySet().stream()
                .filter(x -> x.getKey().getPassport().equals(passport))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Method that gets actual account by user and account.
     *
     * @param user    user.
     * @param account needed account.
     * @return account.
     */
    public Account getActualAccount(User user, Account account) {
        Optional<Account> acc = clients.entrySet().stream()
                .filter(x -> x.getKey().equals(user))
                .flatMap(x -> x.getValue().stream())
                .filter(x -> x.equals(account))
                .findFirst();
        return acc.orElse(null);
    }

    /**
     * Transfers amount from one account to another.
     *
     * @param srcPassport  passport of user from whose account transfer should take place.
     * @param srcRequisite requisites account form which transfer will take place.
     * @param destPassport passport of user to whose account transfer should take place.
     * @param dstRequisite requisites account to which transfer will take place.
     * @param amount       transfer amount.
     * @return if transfer was successful.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account from = checker(srcPassport, srcRequisite);
        Account to = checker(destPassport, dstRequisite);
        return from != null && to != null && from.transfer(to, amount);
    }

    /**
     * Gets account by not null pass and requisites.
     *
     * @param passport   passport.
     * @param requisites requisites.
     * @return account.
     */
    private Account checker(String passport, String requisites) {
        Optional<Account> acc = clients.entrySet().stream()
                    .filter(x -> x.getKey().getPassport().equals(passport))
                    .map(Map.Entry::getValue)
                    .flatMap(Collection::stream)
                    .filter(x -> x.getRequisites().equals(requisites))
                    .findFirst();

        return passport != null && requisites != null && acc.isPresent() ? acc.get() : null;
    }
}


