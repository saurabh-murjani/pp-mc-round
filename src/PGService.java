package src;

import java.util.List;
import java.util.Map;

public interface PGService {

    List<PaymentMethods> listSupportedModes();
    List<PaymentMethods> listSupportedModes(int clientId);
    boolean addSupportForMode(PaymentMethods method);
    boolean addSupportForMode(PaymentMethods method, int clientId);
    boolean removeMode(PaymentMethods method);
    boolean removeMode(PaymentMethods method, int clientId);
    Map<String, String> showDistribution();
    boolean makePayment(PaymentMethods method, String credentials);
    boolean addClient(int id, String name, List<PaymentMethods> methodsList);
}
