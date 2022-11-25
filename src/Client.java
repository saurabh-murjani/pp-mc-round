package src;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int clientId;
    private String clientName;
    private List<PaymentMethods> supportedMethods;

    public Client(int id, String name, List<PaymentMethods> methodList) {
        this.clientId = id;
        this.clientName = name;
        this.supportedMethods = new ArrayList<>();
        supportedMethods.addAll(methodList);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<PaymentMethods> getSupportedMethods() {
        return supportedMethods;
    }

    public void setSupportedMethods(List<PaymentMethods> supportedMethods) {
        this.supportedMethods = supportedMethods;
    }
}
