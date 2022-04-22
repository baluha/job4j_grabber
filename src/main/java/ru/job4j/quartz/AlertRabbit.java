package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {
    public static void main(String[] args) throws Exception {
        Properties properties = getProperties();
        Class.forName(properties.getProperty("driver-class-name"));
        try (Connection cnt = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("postgres"),
                properties.getProperty("password"))) {
            try {
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                scheduler.start();
                JobDataMap data = new JobDataMap();
                data.put("connection", cnt);
                JobDetail job = newJob(Rabbit.class)
                        .usingJobData(data)
                        .build();
                SimpleScheduleBuilder times = simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever();
                Trigger trigger = newTrigger()
                        .startNow()
                        .withSchedule(times)
                        .build();
                scheduler.scheduleJob(job, trigger);
                Thread.sleep(5000);
                scheduler.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream is = AlertRabbit.class.getClassLoader().getResourceAsStream("rabbitshema.properties")) {
            properties.load(is);
        }
        return properties;
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            Connection con = (Connection) context.getJobDetail().getJobDataMap().get("connection");
            try (PreparedStatement ps
                         = con.prepareStatement("INSERT INTO RABBIT(CREATED_DATE) VALUES (CURRENT_TIMESTAMP)")) {
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}