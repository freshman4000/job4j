package ru.job4j.profession;
/**
 * Class Engineer.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Engineer extends Profession {
    /**
     * TeamLead experience from 1 to 10.
     */
    private int teamLeadLvl;
    /**
     * Getter.
     * @return level.
     */
    public int getTeamLeadLvl() {
        return teamLeadLvl;
    }
    /**
     * Read technical documentation.
     * @param project to work with.
     */
    public void readDocs(Project project) { }
}
