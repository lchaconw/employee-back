package com.amaris.employees.repository;

import java.util.List;

public interface ApiRepository<T> {
    List<T> getAll();

    T getById(int id);
}
