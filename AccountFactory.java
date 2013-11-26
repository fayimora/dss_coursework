import java.rmi.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

class AccountFactory
{
  private HashMap<Integer, BankServer> accountsTable = new HashMap<Integer, BankServer>();

  public BankServer newAccount() throws RemoteException {
    int accountNumber = new Random().nextInt();
    BankServer s = new BankServerImpl(accountNumber);
    this.accountsTable.put(accountNumber, s);
    return s;
  }

  public BankServer getAccount(int accountNumber) throws NoSuchAccountException {
    if(this.accountsTable.containsKey(accountNumber))
      return accountsTable.get(accountNumber);
    else
      throw new NoSuchAccountException(accountNumber);
  }
}
