package dev.mohammad.merati;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
public class mainApp {
    //region Variabels
    private static int maxService = 56;
    private static  String[] numbers = new String[maxService];
   private static  String[] names = new String[maxService];
   private static  String[] mobiles = new String[maxService];
   private static  Boolean[] exitedList = new Boolean[maxService];
   private static  Long[][] invoicePrices = new Long[maxService][];
   private static  String[][] invoiceTitels = new String[maxService][];
   private static Integer currentIndex = 0;
   //endregion
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        if (now.getHour() < 6) {
            print("working day not started yet!");
            return;
        }
        showDayMessage(now);
        while (true) {
            showMenu();
            int menu = getMenu();
            switch (menu) {
                case 1:
                    enterCarMenu();
                    break;
                case 2:
                    int remain = maxService - currentIndex;
                    int exited = 0, entered = 0;
                    for (Boolean item : exitedList) {
                        if (item == null) continue;
                        else if (item) exited++;
                        else entered++;
                    }
                    print("Remains:" + remain);
                    print("InService:" + entered);
                    print("Serviced:" + exited);
                    break;
                case 3:
                    print("please enter your service number: ");
                    Integer number = Integer.parseInt(getInput());
                    number--;
                    if (!checkNumberValidity(number)) {
                        print("your numbre is invalid");
                        break;
                    }
                    print("number: " + numbers[number]);
                    print("name: " + names[number]);
                    print("mobile: " + mobiles[number]);
                    print("status: " + (exitedList[number] ? "Serviced" : "InService"));
                    break;
                case 4:
                    print("please enter your service number: ");
                    Integer serviceNumber = Integer.parseInt(getInput());
                    serviceNumber--;
                    if (!checkNumberValidity(serviceNumber)) {
                        print("your numbre is invalid");
                        break;
                    }
                    print("please enter invoice item count: ");
                    Integer invoiceItemCount = Integer.parseInt(getInput());
                    Long totalPrice = 0l;
                    invoiceTitels[serviceNumber] = new String[invoiceItemCount];
                    invoicePrices[serviceNumber] = new Long[invoiceItemCount];
                    for (int index = 0; index < invoiceItemCount; index++) {
                        print("[" + (index + 1) + "] -> please entre invice item titel: ");
                        invoiceTitels[serviceNumber][index] = getInput();
                        print("[" + (index + 1) + "] -> please entre invice item price: ");
                        invoicePrices[serviceNumber][index] = Long.valueOf(getInput());
                        totalPrice += invoicePrices[serviceNumber][index];
                    }
                        exitedList[serviceNumber] = true;
                        print("Total price: " + totalPrice);
                        break;
                        case 0:
                            print("goodbye!");
                            return;

            }
        }

    }

    private static void enterCarMenu() {
        int remain = maxService - currentIndex;
        if (remain == 0) {
            print("Capasity is full!");
            return;
        }
        print("please enter car NO: ");
        numbers[currentIndex] = getInput();
        print("please enter car driver name: ");
        names[currentIndex] = getInput();
        print("please enter car driver mobile: ");
        mobiles[currentIndex] = getInput();
        exitedList[currentIndex] = false;
        print("your service number is: " + (currentIndex +1));
        currentIndex++;
        return;
    }

    private static boolean checkNumberValidity(Integer serviceNumber) {
        return serviceNumber >= 0 && serviceNumber <= maxService;
    }

    private static int getMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
           return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void showMenu() {
        print("please enter menu number continue: ");
        print("1: Enter a car information");
        print("2: Show remain & entered & exited cars count");
        print("3: Show car details");
        print("4: Exit a car");
        print("0: Exit from program");
    }

    private static void showDayMessage(LocalDateTime date) {
        switch (date.getDayOfWeek()) {
            case MONDAY :
                print("Happy Monday.");
                break;
            case TUESDAY :
                print("Happy Tuesday.");
                break;
            case WEDNESDAY:
                print("Happy Wednesday.");
                break;
            case THURSDAY :
                print("Happy Thursday.");
                break;
            case FRIDAY :
                print("Happy Friday.");
                break;
            case SATURDAY :
                print("Happy Saturday.");
                break;
            case SUNDAY :
                print("Happy Sunday.");
                break;
        }

    }
    private static void print(String message) {
        System.out.println(message);
    }
    private static String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
