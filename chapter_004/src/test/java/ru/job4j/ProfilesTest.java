package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test.
 */
public class ProfilesTest {
    /**
     * Testing creation of address list from profiles list.
     */
    @Test
    public void when3profilesThen3Addresses() {
        List<Profile> profiles = new ArrayList<>();
        Address a1 = new Address("Moscow", "Tverskaya", 18, 228);
        Address a2 = new Address("St.Petersburg", "Lenina", 234, 23);
        Address a3 = new Address("Kazan", "Krasnaya", 1, 1);
        profiles.add(new Profile(a1));
        profiles.add(new Profile(a2));
        profiles.add(new Profile(a3));
        Assert.assertThat(Profiles.collect(profiles), Is.is(Arrays.asList(a1, a2, a3)));
    }
}
