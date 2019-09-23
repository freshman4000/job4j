package ru.job4j.vacancyparser;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import ru.job4j.QuartzJob;

public class SqlQuartsJob extends QuartzJob {
    public static String prop = "";

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        new SqlRuExecutor(new SqlRuController(prop), new SqlRuParser(1), prop).execute();
    }
}
