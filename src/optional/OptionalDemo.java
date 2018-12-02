package optional;

import java.util.HashMap;
import java.util.Optional;

public class OptionalDemo {
    public static void  main(String[] args) {

        //simple optionals

        //replacement of Car car = null;
        Optional<Car> car2 = Optional.empty();

        //this states that car object can be empty
        Car car= new Car();
        Optional<Car> optCar = Optional.ofNullable(car);

        //Optional with map

        //before java 8
        Insurance insurance = new Insurance(1,"testi");
        String name = null;
        if(insurance != null){
            name = insurance.getName();
        }

        //after java 8
        //if optInsurance is empty than no error and name2 will be empty
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name2 = optInsurance.map(Insurance::getName);

        //Optional with flat map
        //REFER getCarinsuranceNameAfterJava8


        /*Wrappinga potentially null value in an optional:*/

        // this will return null if there’s no value in the map associated with the String “key.”
        HashMap map = new HashMap();
        Object value = map.get("key");

        //solution use Optional
        Optional<Object> value2 = Optional.ofNullable(map.get("key"));

    }


   /* public String getCarinsuranceNameBeforeJava8(Person person) {
        if(person != null) {
            if(person.getCar() != null) {
                if(person.getCar().getInsurance() != null) {
                    return  person.getCar().getInsurance().getName();
                }
            }
        }
    }*/

   //optional with map and flatmap
    public String getCarinsuranceNameAfterJava8(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    //optional with filter
    /*The filter method takes a predicate as an argument.
    If a value is present in the Optional object and it matches the predicate,
    the filter method returns that value; otherwise, it returns an empty Optional object*/
    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    //wrong way of checking optionals
    public Optional<Insurance> wrongWayChecking(Optional<Person> optionalPerson, Optional<Car> optionalCar) {
        if(optionalPerson.isPresent() && optionalCar.isPresent()) {
            //Optional.of method is used to create optional of object tht wont be null
            // (coz isPresent is true so we can use this)
            //get() method will throw notFound exception of optional object is empty
            //but here we are making ure tht optional values contains values with isPresent

            return Optional.of(findCheapestInsueance(optionalPerson.get(),optionalCar.get()));
        }
        else {
            return  Optional.empty(); //returns empty optional object
        }
    }

    public Optional<Insurance> rightWayCecking(Optional<Person> optionalPerson, Optional<Car> optionalCar) {

        /*Here you invoke a flatMap on the first optional, so if this is empty,
        the lambda expression passed to it won’t be executed at all and this invocation will just return an empty optional.
        same goes with map.*/
        return optionalPerson.flatMap(p -> optionalCar.map(c -> findCheapestInsueance(p,c)));
    }


    public Optional<Integer> stringToInt(String s) {
        try {
            return  Optional.ofNullable(Integer.parseInt(s));
        }
        catch (Exception e) {
            return  Optional.empty();
        }
    }

    public Insurance findCheapestInsueance(Person person,Car car)
    { return new Insurance();}
}
