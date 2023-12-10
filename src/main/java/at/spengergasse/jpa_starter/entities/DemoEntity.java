package at.spengergasse.jpa_starter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DemoEntity {
    @Id
    @GeneratedValue
    private int id;

    @Override
    public String toString() {
        return "DemoEntity{" +
                "id=" + id +
                '}';
    }
}
