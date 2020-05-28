package com.codegym.kiemtramodule4.controller;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.model.Country;
import com.codegym.kiemtramodule4.service.ICityService;
import com.codegym.kiemtramodule4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class CityController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @ModelAttribute("country")
    Page<Country> findAll(Pageable pageable) {
        return countryService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView listCity(@PageableDefault(size = 5) Pageable pageable){
        Page<City> city = cityService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("cities", city);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCity(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createCity(@ModelAttribute("city") City city, RedirectAttributes redirect){
        cityService.save(city);
        redirect.addFlashAttribute("message", "create city successfully !");
        return new RedirectView("/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEditCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit")
    public RedirectView editCity(@ModelAttribute("city") City city, RedirectAttributes redirect){
        cityService.save(city);
        redirect.addFlashAttribute("message", "edit city successfully !");
        return new RedirectView("/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete")
    public RedirectView deleteCity(@ModelAttribute("city") City city, RedirectAttributes redirect){
        cityService.remote(city.getId());
        redirect.addFlashAttribute("message", "delete city successfully !");
        return new RedirectView("/");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error");
        }

    }

}















