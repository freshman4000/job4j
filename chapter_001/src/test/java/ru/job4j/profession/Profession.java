package ru.job4j.profession;
import java.util.Date;
/**
 * Common class for all professions.
 * @author Vit Efremov
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Profession {
    /**
     * Name of professional.
     */
    private String name;
    /**
     * Last name of professional.
     */
    private String surname;
    /**
     * Birth date.
     */
    private Date birthday;
    /**
     * Education possession.
     */
    private String education;
    /**
     * Getter.
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter.
     * @return Last name.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Getter.
     * @return birth date.
     */
    public Date getBirthday() {
        return birthday;
    }
    /**
     * Getter.
     * @return Education.
     */
    public String getEducation() {
        return education;
    }
}
