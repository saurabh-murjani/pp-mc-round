package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PGServiceImpl implements PGService{

    private List<PaymentMethods> supportedModes;
    private ClientServiceImpl clientService;

    public PGServiceImpl() {
        this.supportedModes = new ArrayList<>();
        this.clientService = new ClientServiceImpl();
    }
    @Override
    public boolean addClient(int id, String name, List<PaymentMethods> methodsList) {
        // Check if payment methods are supported by PG
        if (supportedModes.containsAll(methodsList)) {
            clientService.addClient(id, name, methodsList);
            return true;
        }
        return false;
    }

    @Override
    public List<PaymentMethods> listSupportedModes() {
        return supportedModes;
    }

    @Override
    public List<PaymentMethods> listSupportedModes(int clientId) {
        if(clientService.hasClient(clientId))
            return clientService.getClient(clientId).getSupportedMethods();
        return null;
    }

    @Override
    public boolean addSupportForMode(PaymentMethods method) {
        return this.supportedModes.add(method);
    }

    @Override
    public boolean addSupportForMode(PaymentMethods method, int clientId) {
        if(clientService.hasClient(clientId)) {
            return clientService.addSupportForMode(clientId, method);
        }
        return false;
    }

    @Override
    public boolean removeMode(PaymentMethods method) {
        return this.supportedModes.remove(method);
    }

    @Override
    public boolean removeMode(PaymentMethods method, int clientId) {
        if(clientService.hasClient(clientId)) {
            return clientService.removeMode(clientId, method);
        }
        return false;
    }

    @Override
    public boolean makePayment(PaymentMethods method, String credentials) {
        return PaymentExecutionService.executePayment(method, credentials);
    }

    @Override
    public Map<String, String> showDistribution() {
        return PaymentExecutionService.showDistribution();
    }
}
