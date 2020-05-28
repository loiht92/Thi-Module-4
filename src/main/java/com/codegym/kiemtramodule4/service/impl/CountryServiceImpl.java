package com.codegym.kiemtramodule4.service.impl;

import com.codegym.kiemtramodule4.model.Country;
import com.codegym.kiemtramodule4.repository.CountryRepository;
import com.codegym.kiemtramodule4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remote(Long id) {
        countryRepository.deleteById(id);
    }
}
