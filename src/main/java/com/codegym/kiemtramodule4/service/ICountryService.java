package com.codegym.kiemtramodule4.service;
import com.codegym.kiemtramodule4.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICountryService {
    Page<Country> findAll(Pageable pageable);

    Optional<Country> findById(Long id);

    void save(Country country);

    void remote(Long id);
}
