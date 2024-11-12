package org.example.staff_maganement.repository;

import org.example.staff_maganement.model.Staff;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    T findById(int id);
    boolean save(T t);
    boolean update(T t);
    boolean delete(int id);
}
