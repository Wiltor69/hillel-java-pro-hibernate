package ua.hillel.jpahibernate;

public interface StudentRepo {
    void addStudent(Student student);
    Student getById(Integer id);

    void delStudent(Student student);

}
