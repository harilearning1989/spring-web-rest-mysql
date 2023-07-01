package com.web.demo.ldap.services;


import com.web.demo.ldap.dtos.PersonDTO;

import java.util.List;

public interface PersonService {

    public List<PersonDTO> getAllPersons();
    public List<String> getAllPersonNames();
    public PersonDTO getPersonNamesByUid(String userId);
}
