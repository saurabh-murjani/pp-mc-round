package src;

import java.util.List;
import java.util.Map;

public class PaymentExecutionService {

    private static Map<String, String> distributionMap;
    public static boolean executePayment(PaymentMethods method, String credentials) {
        // TODO Choose bank based on these parameters in this exact order of priority ->  Allocation Percentage , Commission Expense, Randomness
        // Allocation percentage will be a factor of success rate of payments with each bank

        return false;
    }

    private static void updateAllocationPercentage() {

    }
    public static Map<String, String> showDistribution() {
        return distributionMap;
    }
}
