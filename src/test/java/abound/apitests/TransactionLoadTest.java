package abound.apitests;

import abound.annotations.LoadTest;

public class TransactionLoadTest
{
    @LoadTest(invocationCount = -1, threadPoolSize = -1, description = "Load test for transaction API")
    public void validateTransactionLoad() {}
}
