package org.example;
import org.example.File.FileProcess;
import org.example.Customer.Customer;
import org.example.Logic.Logic;
import org.example.Menu.MenuItem;
import org.example.Menu.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;



public class Main {
    public static void main(String[] args) { Main main = new Main();
        main.run();

    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();
        FileProcess fileProcess = new FileProcess();
        List<Customer> list = new ArrayList<>();

        list = fileProcess.ReadFile(list);
        List<Customer> finalList = list;
        List<MenuItem> menuItems = Arrays.asList(

                new MenuItem("Вийти з програми", () -> { System.exit(0);
                }),

                new MenuItem("Додати дані", () -> {

                    String surname = null; Callable<String> sNameInput = () -> {

                        System.out.println("Введіть прізвище: ");
                        String sName = scanner.nextLine();

                        if (logic.inputValidate(sName)) {

                            System.out.println("Введена назва містить неприпустимі символи");
                            return null;
                        }
                        return sName;
                    };

                    try {

                        do {

                            surname = sNameInput.call();

                        } while (surname == null);
                    } catch (Exception err) { err.printStackTrace();
                    }


                    String name = null;
                    Callable<String> nameInput = () -> {

                        System.out.println("Введіть ім'я: ");
                        String nName = scanner.nextLine();

                        if (logic.inputValidate(nName)) {

                            System.out.println("Введена назва містить неприпустимі символи");
                            return null;
                        }

                        return nName;
                    };

                    try {

                        do {

                            name = nameInput.call();

                        } while (name == null);
                    } catch (Exception err) { err.printStackTrace();
                    }



                    String middleName = null; Callable<String> mNameInput = () -> {

                        System.out.println("Введіть по батькові: ");
                        String mName = scanner.nextLine();

                        if (logic.inputValidate(mName)) {

                            System.out.println("Введена назва містить неприпустимі символи");
                            return null;
                        }

                        return mName;
                    };

                    try {

                        do {

                            middleName = mNameInput.call();

                        } while (middleName == null);
                    } catch (Exception err) { err.printStackTrace();
                    }








                    LocalDate birthday = null;
                    Callable<LocalDate> bdInput = () -> {

                        System.out.println("Введіть дату народження: ");
                        String bd = scanner.nextLine();

                        if (logic.inputValidate(bd)) {

                            System.out.println("Введена назва містить неприпустимі символи");
                            return null;
                        }

                        return LocalDate.parse(bd, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    };

                    try {

                        do {

                            birthday = bdInput.call();

                        } while (birthday == null);
                    } catch (Exception err) { err.printStackTrace();
                    }


                    String address = null; Callable<String> adrInput = () -> {

                        System.out.println("Введіть адресу: ");
                        String adr = scanner.nextLine();

                        if (logic.inputValidate(adr)) {

                            System.out.println("Введена назва містить неприпустимі символи");
                            return null;
                        }

                        return adr;
                    };

                    try {

                        do {

                            address = adrInput.call();

                        } while (address == null);
                    } catch (Exception err) { err.printStackTrace();
                    }


                    long creditCardNumber = 0;
                    Callable<Long> creditCardNumberInput = () -> {

                        System.out.println("Введіть номер кредитної карти: "); long cardNumber;

                        try {

                            cardNumber = scanner.nextLong();
                            scanner.nextLine();

                        } catch (InputMismatchException err) {

                            System.out.println("Введений номер містить некоректні символи");
                            scanner.next(); return Long.valueOf(-1);
                        }

                        return cardNumber;
                    };

                    try {


                        do {

                            creditCardNumber = creditCardNumberInput.call();

                        } while (creditCardNumber == -1.0);
                    } catch (Exception err) { err.printStackTrace();
                    }


                    double creditCardBalance = 0;
                    Callable<Double> creditCardBalanceInput = () -> {

                        System.out.println("Введіть кількість грошей на рахунку: ");
                        double cardBalance; try {
                            cardBalance = scanner.nextDouble(); scanner.nextLine();

                        } catch (InputMismatchException err) {

                            System.out.println("Введений час містить некоректні символи");
                            scanner.next(); return -1.0;
                        }

                        return cardBalance;
                    };

                    try {


                        do {

                            creditCardBalance = creditCardBalanceInput.call();

                        } while (creditCardBalance == -1.0);
                    } catch (Exception err) { err.printStackTrace();
                    }

                    logic.addEll(finalList, surname, name, middleName, birthday, address, creditCardNumber,creditCardBalance);
                    fileProcess.WriteFile(finalList);

                }),

                new MenuItem("Видалити клієнта", () -> {

                    logic.showAllProducts(finalList); System.out.println("Введіть id для видалення"); int productToDelete = scanner.nextInt(); scanner.nextLine();

                    logic.remEll(finalList, productToDelete);
                    fileProcess.WriteFile(finalList);

                }),

                new MenuItem("Список всіх клієнтів", () -> { logic.showAllProducts(finalList);
                }),

                new MenuItem("Список покупців, у яких номер картки знаходиться в заданому інтервалі", () -> {

                    System.out.println("Введіть першу картку:");
                    long x1 = scanner.nextLong();
                    System.out.println("Введіть другу картку:");
                    long x2 = scanner.nextLong();
                    System.out.println(logic.compareCreditCardNumbers(x1,x2, finalList));

                }),

                new MenuItem("Список покупців із вказаним іменем", () -> {

                    System.out.println("Введіть ім'я:");
                    String xName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println(logic.defineName(xName, finalList));

                }),

                new MenuItem("Список покупців, які мають заборгованість", () -> {


                    System.out.println(logic.customersWithDept(finalList));

                }),
                new MenuItem("Список покупців відсортованих за балансом, а потім за номером карти", () -> {


                    System.out.println(logic.filterByBalanceORCard(finalList));

                }),
                new MenuItem("Список років народження без повторів", () -> {


                    System.out.println(logic.listYears(finalList));

                }),
                new MenuItem("Cписок для кожного року народження, що визначає, у якого на картці найбільша сума грошей", () -> {


                    System.out.println(logic.mapByYear(finalList));

                })
        );
        Menu menu = new Menu(menuItems); menu.run();

    }

}






//import lab6.Customer.Customer;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Main prog = new Main();
//        prog.run();
//    }
//    public void run() {
//        Customer[] customers = fillProductsArray();
//        System.out.println("Введіть ім'я клієнта:");
//        Scanner scanner = new Scanner(System.in);
//        String xName = scanner.nextLine();
//        System.out.println("Введіть початок інтервалу:");
//        long x1 = scanner.nextLong();
//        System.out.println("Введіть кінець інтервалу:");
//        long x2 = scanner.nextLong();
//        System.out.println("Список покупців із вказаним ім'ям:");
//        System.out.println(Arrays.toString(defineName(xName, customers)));
//        System.out.println("Список покупців, у яких номер кредитної картки знаходиться в заданому інтервалі:");
//        System.out.println(Arrays.toString(compareCreditCardNumbers(x1, x2, customers)));
//        System.out.println("Список покупців, які мають заборгованість (від’ємний баланс на карті):");
//        System.out.println(Arrays.toString(customersWithDebt(customers)));
//    }
//    public Customer[] fillProductsArray() {
//        return new Customer[]{
//                new Customer(1, "Михайлов", "Олександр", "Вікторович", "Севастопольська 14/25", 7199452114525621L, 300.6),
//                new Customer(2, "Підгорний", "Максим", "Володимирович", "Соборна 24/43", 1546195491345431L, 20.5),
//                new Customer(3, "Вихор", "Іван", "Олегович", "Шевченка 14/4", 5424543560546543L, 30.7),
//                new Customer(4, "Скивка", "Євгеній", "Анатолійович", "пр. Центральний 16/6", 6540303595439123L, -10.0)
//        };
//    }
//    public Customer[] defineName(String xName, Customer[] customers) {
//        int k=0;
//        Customer[] customer1 =new Customer[customers.length];
//        for (Customer customer : customers) {
//            if (xName.equals(customer.getName())) {
//                customer1[k] = customer;
//                k++;
//            }
//        }
//        return Arrays.copyOf(customer1,k);
//    }
//    public Customer[] compareCreditCardNumbers(long x1, long x2, Customer[] customers) {
//        int k=0;
//        Customer[] customer1 =new Customer[customers.length];
//        for (Customer customer : customers) {
//            if (x1 <= customer.getCreditCardNumber() && x2 >=
//                    customer.getCreditCardNumber()) {
//                customer1[k] = customer;
//                k++;
//            }
//        }
//        return Arrays.copyOf(customer1,k);
//    }
//    public Customer[] customersWithDebt(Customer[] customers) {
//        int k=0;
//        Customer[] customer1 =new Customer[customers.length];
//        for (Customer customer : customers) {
//            if (customer.getCreditCardBalance() < 0) {
//                customer1[k] = customer;
//                k++;
//            }
//        }
//        return Arrays.copyOf(customer1,k);
//    }
//}
