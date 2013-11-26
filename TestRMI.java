import java.rmi.*;
import java.util.Scanner;

class TestRMI{
  public static void main(String[] args)
  {
    String hostname = args[0];
    String port = args[1];
    String fullAddress = String.format("%s:%s", hostname, port);
    String URL = String.format("//%s/ATM", fullAddress);
    Scanner in = new Scanner(System.in);

    System.out.println("Connection URL is " + URL);
    try {
      BankServer server = (BankServer) Naming.lookup(URL);
      Client client = new Client(server);

      // how long does it take to get a string of length 1000??
      long startTime = System.nanoTime();
      String result = client.sendString(1000);
      long endTime = System.nanoTime();

      String duration = "" + (endTime - startTime);

      System.out.printf("It took %s nano seconds to generate the string\n", duration);

      startTime = System.nanoTime();
      client.lengthOfString(duration); // use string representation of the previous evaluation
      endTime = System.nanoTime();

      duration = "" + (endTime - startTime);

      System.out.printf("It took %s nano seconds to get the length of a string\n", duration);

    } catch (Exception e) {
      System.err.printf("Error has occured: %s\n", e);
    }
  }
}
