package com.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/v1/customers", "/v1/customers/"})
public class CustomerController {

    public static final List<String> NAMES = List.of("William", "Brenon", "Wildnei", "Fabricio");

    @GetMapping
    public List<String> list() {
        return NAMES;
    }

    //http://localhost:8080/v1/customers/filter?name=Brenon
    //http://localhost:8080/v1/customers/filter
    @GetMapping("filter")
    public List<String> filter(@RequestParam(defaultValue = "") String name) {
        return NAMES.stream().filter(n -> n.equalsIgnoreCase(name)).toList();
    }

    //http://localhost:8080/v1/customers/filterOptional?name=brenon
    @GetMapping("filterOptional")
    public List<String> filter(@RequestParam Optional<String> name) {
        return NAMES.stream().filter(n -> n.equalsIgnoreCase(name.orElse(""))).toList();
    }

    //http://localhost:8080/v1/customers/filterList?names=William,Wildnei
    @GetMapping("filterList")
    public List<String> filter(@RequestParam List<String> names) {
        return NAMES.stream().filter(names::contains).toList();
    }


}
