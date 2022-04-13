package Currencies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.TreeMap;

public class Currencies {
  private static final DecimalFormat df = new DecimalFormat("0.000");

  public static void main(String[] args) throws IOException {
    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
    TreeMap<String, String> listCurrencies = new TreeMap<>();
    while (true) {
      System.out.print("Enter command: ");
      String userCommand = user.readLine();
      if ("quit".equalsIgnoreCase(userCommand)) {
        System.out.println("Quit-command receieved, exiting...");
        break;
      }
      String[] arrofUserCommand = userCommand.split(" ", 3);
      if(arrofUserCommand.length < 3){
        System.out.println("Missing arguments");
        continue;
      }
      switch (arrofUserCommand[0]) {
        case "rate": {
          String key = arrofUserCommand[1].toUpperCase();
          String value = df.format(Double.parseDouble(arrofUserCommand[2]));
          listCurrencies.put(key, value);
          System.out.printf("Stored the rate 1 EUR = %s %s%n", key, value);
          break;
        }
        case "rates": {
          System.out.println("Stored euro rates:");
          for (var keyValue : listCurrencies.entrySet()) {
            System.out.println(keyValue.getKey() + " " + keyValue.getValue());
          }
          break;
        }
        case "convert": {
          String quantityStr = df.format(Double.parseDouble(arrofUserCommand[1]));
          String keyChanged = arrofUserCommand[2].toUpperCase();
          String value = listCurrencies.get(keyChanged);
          if (value == null) {
            System.out.printf("No rate for %s has been stored", keyChanged);
          }
          else {
            Double quantity = Double.parseDouble(quantityStr);
            Double rate = Double.parseDouble(value);
            String moneyChange = df.format(quantity / rate);
            System.out.printf("%s %s = %s EUR%n", quantityStr, keyChanged, moneyChange);
          }
          break;
        }
        default: {
          System.out.println("Stupid, Dump. Insert again, bitch");
          break;
        }
      }
    }
  }
}
