package ru.job4j;

import java.util.Comparator;
import java.util.Objects;

public class Address {
    private String city;
    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
   public static Comparator<Address> addressComparator = new Comparator<Address>() {
        @Override
        public int compare(Address o1, Address o2) {
            return o1.street.compareTo(o2.street);
        }
    };
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return this.apartment == address.apartment && this.city.equals(address.city)
                && this.home == address.home && this.street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}

