package src;

import java.util.List;

public interface ClientService {

    boolean addClient(int id, String name, List<PaymentMethods> methodsList);
    boolean removeClient(int id);
    boolean hasClient(int id);
    Client getClient(int id);
    boolean addSupportForMode(int id, PaymentMethods method);
    boolean removeMode(int id, PaymentMethods method);
}
