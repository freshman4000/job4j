package ru.job4j.vacancyparser;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.util.Properties;

public class QuarzLauncher {
    public static final Logger LOG = LogManager.getLogger(QuarzLauncher.class.getName());
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Properties properties = new Properties();
        try (InputStream inputStream = QuarzLauncher.class.getClassLoader().getResourceAsStream(args[0])) {
            properties.load(inputStream);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Every 24 hours at 12")
                .withSchedule(CronScheduleBuilder.cronSchedule(properties.getProperty("time"))).build();
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
        LOG.error(e.getMessage(), e);
        }
    }
}
