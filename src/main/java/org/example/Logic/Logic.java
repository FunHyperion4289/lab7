package org.example.Logic;

import org.example.Customer.Customer;

import java.time.LocalDate;
import java.util.*;
public class Logic {
    public void addEll(List<Customer> customers, String surname, String name, String middleName, LocalDate birthday, String address, long creditCardNumber, double creditCardBalance){
        Customer customer=new Customer(surname,name,middleName, birthday,address,creditCardNumber,creditCardBalance);
        customers.add(customer);
    }
    public void remEll(List<Customer> customers, int id){
        customers.removeIf(customer ->customer.getId()==id);
    }
    public void showAllProducts(List<Customer> list) {
        if (list.isEmpty()) {
            return;
        }
        list.forEach(System.out::println);
    }
    public boolean inputValidate(String input) {
        return input.contains("\n") || input.contains("\t") || input.isEmpty();
    }
    public List<Customer> defineName(String xName, List<Customer> customers) {
        List<Customer> customers1 =new ArrayList<>();
        for (Customer customer: customers) {
            if (xName.equals(customer.getName()))
            {
                customers1.add(customer);
            }
        }
        return customers1;
    }
    public List<Customer> compareCreditCardNumbers(long x1, long x2, List<Customer> customers) {
        List<Customer> customers1 =new ArrayList<>();
        for (Customer customer: customers) {
            if (x1 <= customer.getCreditCardNumber() && x2>= customer.getCreditCardNumber()) {
                customers1.add(customer);
            }
        }
        return customers1;
    }
    public List<Customer> customersWithDept( List<Customer> customers) {
        List<Customer> customers1 =new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCreditCardBalance() < 0) {
                customers1.add(customer);
            }
        }
        return customers1;
    }
    public List<Customer> filterByBalanceORCard(List<Customer> customers) {
        List<Customer> customers1 = new ArrayList<>(customers);
        customers1.sort(Comparator.comparingDouble(Customer::getCreditCardBalance).thenComparingLong(Customer::getCreditCardNumber));
        return customers1;
    }
    public List<Integer> listYears(List<Customer> customers) {
        Set<Integer> years = new HashSet<>();
        for (Customer customer : customers) {
            years.add(customer.getBirthday().getYear());
        }
        List<Integer> customer1 = new ArrayList<>(years);
        return customer1;
    }
    public Map<Integer, Customer> mapByYear(List<Customer> customers) {
        Map<Integer, Customer> mapByYear = new HashMap<>();
        for (Customer customer : customers) {
            int year = customer.getBirthday().getYear();
            if (!mapByYear.containsKey(year) || customer.getCreditCardBalance() > mapByYear.get(year).getCreditCardBalance()) {
                mapByYear.put(year, customer);
            }
        }
        return mapByYear;
    }

}
