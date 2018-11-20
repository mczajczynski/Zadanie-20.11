package pl.maciek.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

@Repository
public class AnimalRepository {

    private EntityManager entityManager;

    public AnimalRepository(EntityManagerFactory entityManagerFactory) {
        entityManager = entityManagerFactory.createEntityManager();
    }
    public List<Animal> showShelter() {
        TypedQuery<Animal> query = entityManager.createQuery("select m from Animal m", Animal.class);
        List<Animal> animals = query.getResultList();
        return animals;
    }

    public void remove(Animal animal) {
        entityManager.getTransaction().begin();
        entityManager.remove(animal);
        entityManager.getTransaction().commit();
    }

    public Animal findAnimalId(Long id) {
        Animal animal = entityManager.find(Animal.class, id);
        return animal;
    }


}
