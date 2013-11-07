import java.rmi.*;
import java.rmi.server.*;

public class BankServerImpl extends UnicastRemoteObject implements BankServer
{
  public static void main(String[] args)
  {
    try
    {
      BankServer server = new BankServerImpl ();
      Naming.rebind (" ATM ", server);
    }
    catch ( Exception e)
    {
      System.err.println(e);
    }
    System.out.println (" server ready ");
  }
  int currentBalance ;
  public BankServerImpl () throws RemoteException
  {
    currentBalance = 0;
  }
  public int deposit (int inc) throws RemoteException
  {
    currentBalance = currentBalance +inc ;
    return currentBalance ;
  }
  public int withdraw (int dec) throws RemoteException
  {
    currentBalance = currentBalance -dec ;
    return currentBalance ;
  }
  public int balance () throws RemoteException
  {
    return currentBalance ;
  }
}
