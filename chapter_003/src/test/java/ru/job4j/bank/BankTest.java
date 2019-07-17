package ru.job4j.bank;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.ArrayList;

/**
    * Test.
    */
public class BankTest {
    /**
     * Bank singleton.
     */
    Bank bank = Bank.getBank;

        /**
         * Testing user & account addition..
         */
    @Test
    public void whenAddThenInMap() {
        User us1 = new User("Vit", "123");
        User us2 = new User("Ant", "456");
        bank.addUser(us1);
        bank.addUser(us2);
        Account account = new Account(1000.0, "Texas");
        Account account1 = new Account(5000.0, "Iowa");
        bank.addAccountToUser("123", account);
        bank.addAccountToUser("456", account1);
        Assert.assertThat(bank.getUserAccounts("123").get(0), Is.is(account));
        Assert.assertThat(bank.getUserAccounts("456").get(0).getRequisites(), Is.is("Iowa"));
    }
        /**
         * Testing user & account deletion.
         */
        @Test
        public void whenDeleteThenNullInMap() {
            User us1 = new User("Vit", "123");
            User us2 = new User("Ant", "456");
            bank.addUser(us1);
            Account account = new Account(1000.0, "Texas");
            Account account1 = new Account(5000.0, "Iowa");
            bank.addAccountToUser("123", account);
            bank.addAccountToUser("123", account1);
            bank.deleteAccountFromUser("123", account);
            Assert.assertThat(bank.getUserAccounts("123").get(0), Is.is(account1));
            bank.deleteUser(us1);
            Assert.assertThat(bank.getUserAccounts("123"), Is.is(new ArrayList()));
        }
    /**
     * Testing transfer amount to other acc and to self acc.
     */
    @Test
    public void whenGoneThenCame() {
        User us1 = new User("Vit", "123");
        User us2 = new User("Ant", "456");
        bank.addUser(us1);
        bank.addUser(us2);
        Account account0 = new Account(555.0, "Texas");
        Account account1 = new Account(777.0, "Nebraska");
        Account account2 = new Account(5000.0, "Iowa");
        bank.addAccountToUser("123", account0);
        bank.addAccountToUser("123", account1);
        bank.addAccountToUser("456", account2);
        bank.transferMoney("123", "Texas", "123", "Nebraska", 555.0);
        bank.transferMoney("123", "Nebraska", "456", "Iowa", 332.0);
        Assert.assertThat(bank.getUserAccounts("123").get(0).getValues(), Is.is(0.0));
        Assert.assertThat(bank.getUserAccounts("123").get(1).getValues(), Is.is(1000.0));
        Assert.assertThat(bank.getUserAccounts("456").get(0).getValues(), Is.is(5332.0));
    }
}
