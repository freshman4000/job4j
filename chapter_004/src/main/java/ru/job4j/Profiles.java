package ru.job4j;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {

        return profiles.stream().map(Profile::getAddress)
                .sorted(Address.addressComparator)
                .distinct()
                .collect(Collectors.toList());
    }
}
