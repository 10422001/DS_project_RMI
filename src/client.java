import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {



    private void connect2() {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            Adder adder = (Adder) reg.lookup("AddService");
            System.out.println(adder.add(34, 4));
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void connect() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(4444);
        Adder ad = (Adder) reg.lookup("AddService");
//        int result = ad.add(87, 92);
        int n1 = 87;
        int n2 = 92;
        int result = ad.add(n1, n2);
        System.out.println(result);
        System.out.println("calc done");
    }
    public static void main(String[] args) throws NotBoundException, RemoteException {
        client client = new client();
        client.connect();
    }
}