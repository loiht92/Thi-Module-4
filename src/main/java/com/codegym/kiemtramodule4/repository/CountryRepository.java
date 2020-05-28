package com.codegym.kiemtramodule4.repository;

import com.codegym.kiemtramodule4.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
