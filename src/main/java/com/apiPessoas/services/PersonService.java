package com.apiPessoas.services;

import com.apiPessoas.models.Address;
import com.apiPessoas.models.Person;
import com.apiPessoas.repositories.AddressRepository;
import com.apiPessoas.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found with id " + id));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Person person = getPersonById(id);
        person.setName(updatedPerson.getName());
        person.setBirthDate(updatedPerson.getBirthDate());
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<Address> getPersonAddresses(Long personId) {
        Person person = getPersonById(personId);
        return person.getAddresses();
    }

    public Address createPersonAddress(Long personId, Address address) {
        Person person = getPersonById(personId);
        address.setPerson(person);
        person.getAddresses().add(address);
        return addressRepository.save(address);
    }

    public void setMainAddress(Long personId, Long addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new EntityNotFoundException("Address not found with id " + addressId));
        if (!address.getPerson().getId().equals(personId)) {
            throw new IllegalArgumentException("Address does not belong to person with id " + personId);
        }
        Person person = getPersonById(personId);
        for (Address a : person.getAddresses()) {
            if (a.getId().equals(addressId)) {
                a.setMain(true);
            } else {
                a.setMain(false);
            }
        }
        addressRepository.save(address);
    }
}
