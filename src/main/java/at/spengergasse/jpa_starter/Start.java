package at.spengergasse.jpa_starter;

import at.spengergasse.jpa_starter.entities.DemoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start implements CommandLineRunner {
    @Autowired  // injected by SpringBoot framework
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        DemoEntity entity = new DemoEntity();
        entityManager.persist(entity);
        System.out.println("stored entity: " + entity);
    }
}
