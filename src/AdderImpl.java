import java.rmi.RemoteException;

public class AdderImpl implements Adder{

    @Override
    public int add(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }
}
