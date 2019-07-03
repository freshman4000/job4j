package ru.job4j.profession;
/**
 * Class Pacient.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Pacient {
    private String name;
    private String sex;
    private Prescription prescription;
    /**
     * Constructor.
     * @param name of pacient.
     * @param sex of pacient.
     */
    public Pacient(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    /**
     * Setter.
     * @param prescription - prescription.
     */
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    /**
     * Getter.
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter.
     * @return sex.
     */
    public String getSex() {
        return sex;
    }
    /**
     * Getter.
     * @return prescription.
     */
    public Prescription getPrescription() {
        return prescription;
    }
}
