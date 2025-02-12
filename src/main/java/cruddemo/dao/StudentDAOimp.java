package cruddemo.dao;

import cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOimp implements StudentDAO{


    //ustala entity menagera
    private EntityManager entityMenager;


    @Autowired
    public StudentDAOimp(EntityManager entityManager){
        this.entityMenager = entityManager;
    }
    //Wstrzykuje zależność EntityManager do klasy DAO. Dzięki temu Spring automatycznie przekazuje obiekt EntityManager .



    @Override
    @Transactional
    public void save(Student theStudent) {
        entityMenager.persist(theStudent);
    }
    //@Override: Wskazuje, że metoda jest implementacją metody zdefiniowanej w interfejsie StudentDAO.
    //@Transactional: Oznacza, że metoda jest wykonywana w kontekście transakcji.
    //Oznacza to, że wszystkie operacje bazy danych  zostaną zatwierdzone jedna transakcja.
    //entityMenager.persist(theStudent): Zapisuje obiekt Student do bazy danych. Obiekt theStudent zostaje "utrwalony" w kontekście JPA.


    @Override
    public Student findById(Integer id) {

        return entityMenager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityMenager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityMenager.createQuery("FROM Student WHERE lastName =:theData", Student.class);
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityMenager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityMenager.find(Student.class, id);
        entityMenager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityMenager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }


}





















