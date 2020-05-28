package com.codegym.kiemtramodule4.repository;

import com.codegym.kiemtramodule4.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
