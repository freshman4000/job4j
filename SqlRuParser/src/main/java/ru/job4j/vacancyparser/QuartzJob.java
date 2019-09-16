package ru.job4j.vacancyparser;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    new Executor(new Controller("parser.properties"),
                        new HTMLParser("https://www.sql.ru/forum/job-offers", 1),
                        "parser.properties").execute();
    }
}
