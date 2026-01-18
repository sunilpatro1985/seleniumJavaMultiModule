package base.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
        private int count = 0;
        private static final int MAX_RETRY = 2; // Total 3 attempts (1st run + 2 retries)

        @Override
        public boolean retry(ITestResult result) {
            if (!result.isSuccess() && count < MAX_RETRY) {
                count++;
                return true; // Tells TestNG to run the test again
            }
            return false; // Stop retrying
        }
    }
