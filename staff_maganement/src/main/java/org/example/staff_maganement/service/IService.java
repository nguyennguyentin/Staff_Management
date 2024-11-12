package org.example.staff_maganement.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findById(int id);
    void save(T t);
    void update(T t);
    void delete(int id);
}
