package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    public List<Rental> getRentals(){return rentals; }

    public String getName() {
        return name;
    }

    public String textStatement() {
        StatementGenerator generator = getStatementGenerator();
        return generator.generateTextStatement();

    }

    private StatementGenerator getStatementGenerator(){
        return StatementGenerator.factory(this);
    }
}

