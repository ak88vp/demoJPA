package ak88.service;

import ak88.model.Student;
import ak88.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Iterable<Student> findByNameContaining(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Student> findAllByOrderByAgeDesc() {
        return studentRepository.findAllByOrderByAgeDesc();
    }

    @Override
    public Iterable<Student> findAllByOrderByAgeAsc() {
        return studentRepository.findAllByOrderByAgeAsc();
    }
}
