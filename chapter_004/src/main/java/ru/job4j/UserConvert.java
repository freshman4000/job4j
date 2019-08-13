package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Class that takes list of names and returns the list of users with these names.
 */
public class UserConvert {
    public static class User {
        private final String name;

        /**
         * Constructor.
         *
         * @param name of the user.
         */
        public User(String name) {
            this.name = name;
        }

        /**
         * Method that returns string representing user fields in needed manner.
         *
         * @return String object.
         */
        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + '}';
        }

        /**
         * Method that says how exactly users have to be compared to ech other
         * to figer out if they are equal.
         *
         * @param o Object -> User to be compared.
         * @return predicate.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return name.equals(user.name);
        }

        /**
         * Method that generates specified hash for every User.
         *
         * @return
         */
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    /**
     * Method that uses list of names to assign them to new Users and returns list of new Users.
     *
     * @param names of the users.
     * @param op    functional interface.
     * @return list of created new Users.
     */
    public List<User> convert(List<String> names, Function<String, User> op) {
        List<User> users = new ArrayList<>();
        names.forEach(n -> users.add(op.apply(n)));
        return users;
    }
}

