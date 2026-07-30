package anas_java.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Async("singleTaskExecutor")
    @Test
    void helloAsync() throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            helloAsync.hello();
        }

        log.info("after call hello async");
        Thread.sleep(Duration.ofSeconds(4));
    }


    @Test
    void helloName() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.hello("Mulyono");
        log.info("after call hello(Mulyono)");
        String response = future.get();
        log.info(response);
    }
}