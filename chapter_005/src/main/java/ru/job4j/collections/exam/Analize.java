package ru.job4j.collections.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int deleted = 0;
        int changed = 0;
        Map<Integer, User> prev = new HashMap<>();
        Map<Integer, User> cur = new HashMap<>();
        previous.forEach(x -> prev.put(x.id, x));
        current.forEach(x -> cur.put(x.id, x));

        for (User user : previous) {
            if (!cur.containsKey(user.id)) {
                deleted++;
            }
        }
        for (User user : current) {
            if (!prev.containsKey(user.id)) {
                added++;
            } else {
                if (!prev.get(user.id).getName().equals(user.getName())) {
                    changed++;
                }
            }
        }
        return new Info(added, changed, deleted);
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        public String toString() {
            return String.format("Added = %s | Changed = %s | Deleted = %s", added, changed, deleted);
        }
    }

}
