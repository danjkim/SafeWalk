package com.sanpo.sanpo;

import com.sanpo.sanpo.Model.Region;
import com.sanpo.sanpo.Model.Session;
import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.RegionRepository;
import com.sanpo.sanpo.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
    private final int POOL_SIZE = 10;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    RegionRepository repo;

    @Autowired
    SessionRepository repoS;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
        threadPoolTaskScheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleTaskWithFixedRate() {

        List<Region> regions = (List<Region>) repo.findAll();
        HashSet<String> set = new HashSet<>();
        System.out.println("A");
        for (Region region: regions) {
            set.add(region.getId());
        }
        for (Region region: regions) {
            int hour = 0;
            int minute = 0;
            System.out.println("B");
            List<Session> newSessions = new ArrayList<>();
            for (int i = 1; i < 48; i++) {
                StringBuilder sb = new StringBuilder();
                if (hour < 10) {
                    sb.append("0");
                    sb.append(hour);
                } else {
                    sb.append(hour);
                }
                sb.append(":");
                if (minute == 0) {
                    sb.append("00");
                } else {
                    sb.append(minute);
                }
                minute = (minute + 30) % 60;
                if (minute == 0) {
                    hour++;
                }
                for (String id: set) {
                    if (!id.equals(region.getId())) {
                        System.out.println("C");
                        Session session = new Session();
                        session.setDestinationName(id);
                        session.setId(UUID.randomUUID().toString());
                        session.setStartTime(sb.toString());
                        session.setUsers(new ArrayList<User>());
                        repoS.save(session);
                        newSessions.add(session);
                    }
                }
            }
            region.setSessions(newSessions);
            repo.save(region);
        }
    }
}