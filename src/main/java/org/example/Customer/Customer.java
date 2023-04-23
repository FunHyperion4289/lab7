package org.example.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
public class Customer implements Serializable {
    @JsonIgnore
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private LocalDate birthday;
    private long creditCardNumber;
    private double creditCardBalance;
    private static int tempID;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(address, customer.address) &&
                customer.creditCardNumber == creditCardNumber &&
                Double.compare(customer.creditCardBalance, creditCardBalance) == 0 &&
                Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) &&
                Objects.equals(middleName, customer.middleName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, middleName, address, creditCardNumber, creditCardBalance);
    }
    public Customer(String surname, String name, String middleName, LocalDate birthday,String
            address, long creditCardNumber, double creditCardBalance){
        tempID++;
        this.id=tempID;
        this.surname=surname;
        this.name=name;
        this.middleName=middleName;
        this.birthday = birthday;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.creditCardBalance = creditCardBalance;
    }
    public Customer(){
        this("","","",LocalDate.ofEpochDay(00-00-0000),"", 0L,0.0);
    }

}