import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // add a new person to the database using entity manager
        // persistenceUnitName is defined in src/main/resources/META-INF/persistence.xml
        EntityManager em = Persistence.createEntityManagerFactory("demo").createEntityManager();
        Person person = new Person(0, "John", LocalDate.of(1990, 1, 1));
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        // find person with id 1 using criteria builder
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(Person.class);
        var root = cq.from(Person.class);
        cq.select(root).where(cb.equal(root.get("id"), 1));
        var query = em.createQuery(cq);
        var person1 = query.getSingleResult();



        System.out.println("id 1 from criteria builder");
        System.out.println(person1);


        Person person2 = em.find(Person.class, 1);

        // find person with name John using JPQL
        var person3 = em.createQuery("SELECT p FROM Person p WHERE p.name = 'John'", Person.class).getResultList();

        for (var p : person3) {
            System.out.println(p);
        }

        // example of the entity graph
        // em.getEntityGraph("person-with-addresses");

        // System.out.println(person2);
        em.close();
    }
}
