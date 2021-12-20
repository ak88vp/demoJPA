package ak88.repository;

import ak88.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
    Iterable<Student> findByName( String name);
    Iterable<Student> findByNameContaining( String name);

}
