import java.rmi.*;
import java.rmi.server.*;

@SuppressWarnings("serial")
public class BankServerImpl extends UnicastRemoteObject implements BankServer
{
  private int currentBalance;
  private int accountNumber;

  public static void main(String[] args)
  {
    try {
      BankServer server = new BankServerImpl ();
      Naming.rebind("ATM", server);
    } catch (Exception e) {
      System.err.println(e);
      System.exit(-1);
    }

    System.out.println("Server is ready ...");
  }

  public BankServerImpl() throws RemoteException {
    currentBalance = 0;
  }

  public BankServerImpl(int accountNumber) throws RemoteException {
    currentBalance = 0;
    this.accountNumber = accountNumber;
  }

  public int deposit(int inc) throws RemoteException {
    currentBalance = currentBalance + inc;
    return currentBalance;
  }

  public int withdraw(int dec) throws RemoteException {
    currentBalance = currentBalance - dec;
    return currentBalance;
  }

  public int balance() throws RemoteException {
    return currentBalance;
  }

  public int getAccNo() throws RemoteException{
    return 123456789;
  }
}
