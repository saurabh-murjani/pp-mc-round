package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientServiceImpl implements ClientService {

    private Map<Integer, Client> clientMap;

    public ClientServiceImpl() {
        this.clientMap = new HashMap<Integer, Client>();
    }

    @Override
    public boolean addClient(int id, String name, List<PaymentMethods> methodList) {
        this.clientMap.put(id, new Client(id, name, methodList));
        return true;
    }

    @Override
    public boolean removeClient(int id) {
        this.clientMap.remove(id);
        return true;
    }

    @Override
    public boolean hasClient(int id) {
        return this.clientMap.containsKey(id);
    }

    @Override
    public Client getClient(int id) {
        return clientMap.get(id);
    }

    @Override
    public boolean addSupportForMode(int id, PaymentMethods method) {
        Client client = clientMap.get(id);
        if(client.getSupportedMethods().contains(method)) {
            System.out.println("Mode already supported");
            return true;
        }
        List<PaymentMethods> supportedModes = client.getSupportedMethods();
        if(supportedModes.add(method)) {
            client.setSupportedMethods(supportedModes);
            clientMap.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMode(int id, PaymentMethods method) {
        Client client = clientMap.get(id);
        if(client.getSupportedMethods().contains(method)) {
            List<PaymentMethods> supportedModes = client.getSupportedMethods();
            supportedModes.remove(method);
            client.setSupportedMethods(supportedModes);
            clientMap.put(id, client);
            return true;
        } else {
            System.out.println("Mode is not supported already, can't remove");
        }
        return false;
    }
}
