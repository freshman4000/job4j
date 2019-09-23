package ru.job4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public abstract class QuartzJob implements Job {

    public abstract void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}