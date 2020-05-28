package com.codegym.kiemtramodule4.service.impl;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.repository.CityRepository;
import com.codegym.kiemtramodule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remote(Long id) {
        cityRepository.deleteById(id);
    }
}
