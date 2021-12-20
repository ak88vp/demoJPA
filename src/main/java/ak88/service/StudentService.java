package ak88.service;

import ak88.model.Student;

public interface StudentService extends IGeneralService<Student> {
    Iterable<Student> findByName( String name);
    Iterable<Student> findByNameContaining( String name);
    Iterable<Student> findAllByOrderByAgeDesc();
    Iterable<Student> findAllByOrderByAgeAsc();
}
