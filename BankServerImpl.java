import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;

@SuppressWarnings("serial")
public class BankServerImpl extends UnicastRemoteObject implements BankServer
{
  private int currentBalance;
  private int accountNumber;
  private static BankServer oldServer;
  public static HashMap<Integer, BankServer> accountsTable = new HashMap<Integer, BankServer>();

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
    return this.accountNumber;
  }

  public static BankServer oldServer(){
    return oldServer;
  }

  public static void saveServer(BankServer server){
    oldServer = server;
    BankServerImpl.accountsTable = AccountFactory.accountsTable;
  }
}
