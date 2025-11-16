package dev.mohammad.merati;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) {
        while (true) {
            try {
                String bestOperatorName = "";
                long bestOperatorSumPrice = 0;
                long shopSumPrice = 0;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter operators count or enter '0' to exit program :");
                int operatorsCount = Integer.parseInt(reader.readLine());
                if (operatorsCount == 0) {
                    System.out.println(" Have a nice day. ");
                    break;
                }
                for (int oprIndex = 0; oprIndex < operatorsCount; oprIndex++) {
                    System.out.println("Please enter operator " + (oprIndex + 1) + " name : ");
                    String operatorName = reader.readLine();
                    System.out.println("Please enter " + operatorName + "'s invoice count : ");
                    int invoiceCount = Integer.parseInt(reader.readLine());
                    long sumPrice = 0;
                    for (int invIndex = 0; invIndex < invoiceCount; invIndex++) {
                        System.out.println("Please enter " + operatorName + "'s invoice " + (invIndex + 1) + " Price : ");
                        long invocePrice = Long.parseLong(reader.readLine());
                        sumPrice += invocePrice;
                        shopSumPrice += invocePrice;
                    }
                    System.out.println("summary price for " + operatorName + " : " + sumPrice);
                    long averege = sumPrice / invoiceCount;
                    System.out.println("average price for " + operatorName + " : " + averege);
                    if (sumPrice <= 5000000) {
                        System.out.println(operatorName + " is low level operator!");
                    } else if (sumPrice > 5000000 && sumPrice <= 10000000) {
                        System.out.println(operatorName + " is medium level operator!");
                    } else if (sumPrice > 10000000) {
                        System.out.println(operatorName + " is high level operator!");
                    }
                    System.out.println("Operator " + (oprIndex + 1) + " registered.");
                    System.out.println("Remains operator count : " + (operatorsCount - oprIndex - 1));
                    if (sumPrice > bestOperatorSumPrice) {
                      bestOperatorName = operatorName;
                      bestOperatorSumPrice = sumPrice;
                    }

                }
                System.out.printf("Shop Sum Price :" + shopSumPrice +"\n");
                System.out.printf("Best Operator is " + bestOperatorName + " with summary" + bestOperatorSumPrice + "\n");
            }catch (Exception e) {
                System.out.println("Please enter a valid input!");
            }
        }
    }
}
