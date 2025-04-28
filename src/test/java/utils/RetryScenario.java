package utils;

import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryScenario {

    private static final Logger logger = LoggerFactory.getLogger(RetryScenario.class);
    private static final int MAX_RETRIES = 1;  // Retry failed tests once
    private int retryCount = 0;

    public boolean shouldRetry(Scenario scenario) {
        if (scenario.isFailed() && retryCount < MAX_RETRIES) {
            retryCount++;
            logger.info("Marking scenario for retry: {}. Attempt {}/{}", 
                        scenario.getName(), retryCount, MAX_RETRIES);
            return true;
        }
        return false;
    }

    public int getRetryCount() {
        return retryCount;
    }
}