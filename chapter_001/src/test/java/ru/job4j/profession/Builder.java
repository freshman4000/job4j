package ru.job4j.profession;
/**
 * Class Builder.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Builder extends Engineer{
    /**
     * Level of mastery from 1 to 5.
     */
    private int masterLvl;
    /**
     * Getter.
     * @return level.
     */
    public int getMasterLvl() {
        return masterLvl;
    }
    /**
     * Builds roof.
     */
    public void buildRoof() {}
}
