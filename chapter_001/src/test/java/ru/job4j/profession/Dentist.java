package ru.job4j.profession;
/**
 * Class Dentist.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Dentist extends Doctor {
    /**
     * Dentistry qualification.
     */
    private int dentistryLvl;
    /**
     * Getter.
     * @return level.
     */
    public int getDentistryLvl() {
        return dentistryLvl;
    }
    /**
     * Tooth filling.
     * @param pacient - pacient.
     */
    public void fillTooth(Pacient pacient) { }
}
