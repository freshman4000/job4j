package ru.job4j.bank;
import org.junit.Before;
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
    @Before
    public void setUp() {
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
    }
        /**
         * Testing user & account addition.
         */
    @Test
    public void whenAddThenInMap() {
        Assert.assertThat(bank.getUserAccounts("123").get(0).getRequisites(), Is.is("Texas"));
        Assert.assertThat(bank.getUserAccounts("456").get(0).getValues(), Is.is(5000.00));
    }
        /**
         * Testing user & account deletion.
         */
        @Test
        public void whenDeleteThenNullInMap() {
            bank.deleteAccountFromUser("123", bank.getUserAccounts("123").get(0));
            Assert.assertThat(bank.getUserAccounts("123").get(0).getValues(), Is.is(777.0));
            User us3 = new User("Cj", "789");
            Account cjAccount = new Account(888.0, "Florida");
            bank.addUser(us3);
            bank.addAccountToUser("789", cjAccount);
            Assert.assertThat(bank.getUserAccounts("789").get(0).getValues(), Is.is(888.0));
            bank.deleteUser(us3);
            Assert.assertThat(bank.getUserAccounts("789"), Is.is(new ArrayList()));
        }
    /**
     * Testing transfer amount to other acc and to self acc.
     */
    @Test
    public void whenGoneThenCame() {
        User us4 = new User("Aj", "987");
        Account ajAccount = new Account(100.0, "Man");
        Account ajAccount1 = new Account(200.0, "California");
        User us5 = new User("Missy", "654");
        Account missyAccount = new Account(0.0, "Illinois");
        bank.addUser(us4);
        bank.addUser(us5);
        bank.addAccountToUser("987", ajAccount);
        bank.addAccountToUser("987", ajAccount1);
        bank.addAccountToUser("654", missyAccount);
        bank.transferMoney("987", "Man", "987", "California", 99.0);
        bank.transferMoney("987", "California", "654", "Illinois", 33.0);
        Assert.assertThat(bank.getUserAccounts("987").get(0).getValues(), Is.is(1.0));
        Assert.assertThat(bank.getUserAccounts("987").get(1).getValues(), Is.is(266.0));
        Assert.assertThat(bank.getUserAccounts("654").get(0).getValues(), Is.is(33.0));
    }
}
