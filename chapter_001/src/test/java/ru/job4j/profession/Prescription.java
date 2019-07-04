package ru.job4j.profession;
import java.util.Date;
/**
 * Class prescription.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Prescription {
    /**
     * Date of prescription.
     */
    private Date date;
    /**
     * Level of emergency.
     */
    private int level;
    /**
     * Constructor.
     * @param date of prescription.
     * @param level of emergency.
     */
    public Prescription(Date date, int level) {
        this.date = date;
        this.level = level;
    }
    /**
     * Setter.
     * @param date of prescription.
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Setter.
     * @param level of emergency.
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Getter.
     * @return date.
     */
    public Date getDate() {
        return date;
    }
    /**
     * Getter.
     * @return level.
     */
    public int getLevel() {
        return level;
    }
}
