package com.apiPessoas.controllers;

import com.apiPessoas.models.Address;
import com.apiPessoas.models.Person;
import com.apiPessoas.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personService.updatePerson(id, updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/{personId}/addresses")
    public List<Address> getPersonAddresses(@PathVariable Long personId) {
        return personService.getPersonAddresses(personId);
    }

    @PostMapping("/{personId}/addresses")
    public Address createPersonAddress(@PathVariable Long personId, @RequestBody Address address) {
        return personService.createPersonAddress(personId, address);
    }

    @PutMapping("/{personId}/addresses/{addressId}/main")
    public void setMainAddress(@PathVariable Long personId, @PathVariable Long addressId) {
        personService.setMainAddress(personId, addressId);
    }
}
