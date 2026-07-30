package anas_java.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class Job {

    private AtomicLong atomicLong = new AtomicLong();

    @Scheduled(cron = "*/4 * * * * *")
    public void cron() {
        log.info("run cronjob");
    }

    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedDelay = 2)
    public void runJob() {
        Long value = atomicLong.incrementAndGet();
        log.info("{} run job {}", value, Thread.currentThread());
    }

    public Long getValue() {
        return atomicLong.get();
    }


}
