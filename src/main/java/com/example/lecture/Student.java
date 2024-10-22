package com.example.lecture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
public class Student {
    private int ID;
    @Getter
    private String FirstName;
    @Getter
    private String LastName;
    @Getter
    private float Av;
    @Getter
    private String City;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getID() {
        return ID;
}
}
