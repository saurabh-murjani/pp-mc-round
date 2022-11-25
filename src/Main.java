package src;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PGServiceImpl PGService = new PGServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();

        // Add client ID->1 Name->Flipkart PaymentMethodsSupported->CC, DC, UPI
        List<PaymentMethods> methodsList1 = new ArrayList<>();
        methodsList1.add(PaymentMethods.CC);
        methodsList1.add(PaymentMethods.DC);
        methodsList1.add(PaymentMethods.UPI);
        if(PGService.addClient(1, "Flipkart", methodsList1))
            System.out.println("Client On-Boarded");
        else
            System.out.println("Client On-Boarding failed, one of the requested payment mode is not supported by Gateway");

        // Add client ID->2 Name->Myntra PaymentMethodsSupported->CC, DC, NB
        List<PaymentMethods> methodsList2 = new ArrayList<>();
        methodsList1.add(PaymentMethods.CC);
        methodsList1.add(PaymentMethods.DC);
        methodsList1.add(PaymentMethods.NB);
        PGService.addClient(1, "Myntra", methodsList2);
        if(PGService.addClient(1, "Flipkart", methodsList1))
            System.out.println("Client On-Boarded");
        else
            System.out.println("Client On-Boarding failed, one of the requested payment mode is not supported by Gateway");

        // Check if client 2 (Myntra) exists
        if(clientService.hasClient(2))
            System.out.println("Client exists");
        else
            System.out.println("Client does not exist");


        // Remove client 2 (Myntra)
        clientService.removeClient(2);

        // Check if client 2 (Myntra) exists
        if(clientService.hasClient(2))
            System.out.println("Client exists");
        else
            System.out.println("Client does not exist");


    }
}
