package com.web.demo.controls;

import com.web.demo.ldap.dtos.PersonDTO;
import com.web.demo.ldap.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ldap")
public class LdapRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get-user-names")
    public ResponseEntity<List<String>> getLdapUserNames() {
        return new ResponseEntity<>(personService.getAllPersonNames(), HttpStatus.OK);
    }
    @GetMapping("/get-users")
    public ResponseEntity<List<PersonDTO>> getLdapUsers() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }
    @GetMapping("/get-user")
    public ResponseEntity<PersonDTO> findLdapPerson(@RequestParam(name = "user-id") String userId) {
        return new ResponseEntity<>(personService.getPersonNamesByUid(userId), HttpStatus.OK);
    }
}
