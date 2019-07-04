package ru.job4j.profession;
/**
 * Class Surgeon.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Surgeon extends Doctor {
    /**
     * Surgery department.
     */
    private String specialisation;
    /**
     * Getter.
     * @return department.
     */
    public String getSpecialisation() {
        return specialisation;
    }
    /**
     * Making surgery.
     * @param pacient - patient.
     */
    public void makeSurgery(Pacient pacient) {}
}
