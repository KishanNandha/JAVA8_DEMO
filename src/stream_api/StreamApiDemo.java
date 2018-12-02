package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class StreamApiDemo {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        //2. What are all the unique cities where the traders work?
        //3. Find all traders from Cambridge and sort them by name.
        //4. Return a string of all traders’ names sorted alphabetically.
        //5. Are any traders based in Milan?
        //6. Print all transactions’ values from the traders living in Cambridge.
        //7. What’s the highest value of all the transactions?
        //8. Find the transaction with the smallest value.










        //Answers







        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("1---------------------------------------------------------------------");
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("2---------------------------------------------------------------------");
        //2. What are all the unique cities where the traders work?
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
        System.out.println("3---------------------------------------------------------------------");
        //3. Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println("4---------------------------------------------------------------------");
        //4. Return a string of all traders’ names sorted alphabetically.
        transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .distinct()
                .forEach(System.out::println);
        System.out.println("5---------------------------------------------------------------------");
        //5. Are any traders based in Milan?
        boolean result = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct().anyMatch(name -> "Milan".equalsIgnoreCase(name));
        System.out.println(result);
        System.out.println("6---------------------------------------------------------------------");
        //6. Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println("7---------------------------------------------------------------------");
        //7. What’s the highest value of all the transactions?
        OptionalInt intresult = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        System.out.println(intresult.orElse(0));
        System.out.println("8---------------------------------------------------------------------");
        //8. Find the transaction with the smallest value.
        Optional opresult = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst();
        System.out.println(opresult.orElse(0));
    }
}
class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}