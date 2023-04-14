package ua.hillel.jpahibernate;

import jakarta.persistence.EntityManager;

public class CustomEntityManagerFactory implements StudentRepo{


    private EntityManager entityManager;

    public CustomEntityManagerFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addStudent(Student student) {
        entityManager.getTransaction().begin();

        entityManager.persist(student);
        entityManager.flush();

        entityManager.getTransaction().commit();
    }


    @Override
    public Student getById(Integer id) {
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);

        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public void delStudent(Student student) {
        entityManager.getTransaction().begin();

        entityManager.remove(student);
        entityManager.flush();

        entityManager.getTransaction().commit();

    }
}
