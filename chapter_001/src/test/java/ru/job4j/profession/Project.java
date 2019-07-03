package ru.job4j.profession;
import java.util.Date;
/**
 *Class Project describes technical documentation.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 03.07.2019.
 * @version 1.0.
 */
public class Project {
    /**
     * Name of project.
     */
    private String name;
    /**
     * Deadline date.
     */
    private Date deadLine;
    /**
     * Constructor.
     * @param name of project.
     * @param deadLine of project.
     */
    public Project(String name, Date deadLine) {
        this.name = name;
        this.deadLine = deadLine;
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
     * @return deadline.
     */
    public Date getDeadLine() {
        return deadLine;
    }
}