package ru.job4j.bank;

/**
 * Bank user - client.
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 * result * name.hashCode();
        result = 17 * result * passport.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;

        return this.name.equals(user.name)
                && this.passport.equals(user.passport);
    }
}
