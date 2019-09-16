package ru.job4j.vacancyparser;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job {
    public static String prop = "";
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    new Executor(new Controller(prop),
                        new HTMLParser("https://www.sql.ru/forum/job-offers", 1),
                        prop).execute();
    }
}
