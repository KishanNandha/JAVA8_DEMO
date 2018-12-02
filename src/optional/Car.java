package optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Car {
    private int id;
    private String name;
    //private Insurance insurance;
    private Optional<Insurance> insurance;

    public Car() {
    }

    public Car(int id, String name, Optional<Insurance> insurance) {
        this.id = id;
        this.name = name;
        this.insurance = insurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
