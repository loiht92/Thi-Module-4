package com.codegym.kiemtramodule4.service;

import com.codegym.kiemtramodule4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICityService {
    Page<City> findAll(Pageable pageable);

    Optional<City> findById(Long id);

    void save(City city);

    void remote(Long id);
}
