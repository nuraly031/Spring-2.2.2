package web.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "number")
    private int number;


    public Car(int id,String name, String color, int number) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.number = number;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}