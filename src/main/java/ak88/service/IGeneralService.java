package ak88.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> { // interface sử dụng generic mô tả các phương chung mà tất cả các service cần có
    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

}
