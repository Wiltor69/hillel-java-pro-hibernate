package ua.hillel.jpahibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("homework28");
        EntityManager entityManager = factory.createEntityManager();

        try{
            StudentRepo repo = new CustomEntityManagerFactory(entityManager);


            Student student = new Student();
            student.setName("Mark Shamis");
            student.setEmail("mark@gmail.com");

            Student student2 = new Student();
            student2.setName("John Stark");
            student2.setEmail("stark@gmail.com");

            Student student3 = new Student();
            student3.setName("Addy Hilmor");
            student3.setEmail("hil@gmail.com");

            Student student4 = new Student();
            student4.setName("Rob Black");
            student4.setEmail("black@gmail.com");

            repo.addStudent(student);
            repo.addStudent(student2);
            repo.addStudent(student3);
            repo.addStudent(student4);

            repo.getById(3);
            repo.delStudent(student4);


        } catch (Exception e){
            System.out.println(e);
        }
        finally {
            factory.close();
            entityManager.close();
        }
    }
}
