package com.shopapp.mailingservice.prometheus;


import com.shopapp.mailingservice.controller.MailingController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Data
public class MetricsService {

    Logger logger = LoggerFactory.getLogger(MetricsService.class);

    private Counter requestCounter;
    private AtomicLong logFileSize;

    private final MeterRegistry meterRegistry;

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initMetrics();
    }

    private void initMetrics() {
        logger.info("METHOD: initMetrics");
        requestCounter = Counter.builder("total_mailing_service_request")
                .description("Total number of requests")
                .register(meterRegistry);

        logFileSize = meterRegistry.gauge("log_file_size_mailing_service", new AtomicLong(0));

    }

    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFreeLogFileSpace() {
        logger.info("METHOD: scheduleFreeLogFileSpace");
        Path path = Paths.get("logs/mailing-service.log");
        FileStore file = null;
        try {
            file = Files.getFileStore(path);
            long freeSizeInGB = (file.getUsableSpace() / (1024 * 1024));
            logger.info("FREE SPACE IN GB: " + freeSizeInGB);
            logFileSize.set(freeSizeInGB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increaseRequestNumber(){
        logger.info("METHOD: increaseRequestNumber");
        requestCounter.increment();
    }
}
