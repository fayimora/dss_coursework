import java.rmi.*;

public interface BankServer extends Remote
{
  public int deposit (int inc ) throws RemoteException;
  public int withdraw (int dec ) throws RemoteException;
  public int balance () throws RemoteException;
}
