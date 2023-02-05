package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// BU SINIF FAIL OLAN TEST CASE LERI TEKRAR CALISTIRIR
public class ListenersRetry implements IRetryAnalyzer {
    private int retryCount = 0;

    // maxRetryCount EK OLARAK CALISMA SAYISI, BU ORNEKTE FAIL OLAN TESTLER
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount<maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
