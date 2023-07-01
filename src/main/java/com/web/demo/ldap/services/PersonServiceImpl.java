package com.web.demo.ldap.services;

import com.web.demo.ldap.dtos.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private LdapTemplate ldapTemplate;
    @Override
    public List<String> getAllPersonNames() {
        List<String> list =
                ldapTemplate.search(
                        query().where("objectclass").is("person"),
                new PersonNameAttributesMapper());
        return list;
    }
    @Override
    public List<PersonDTO> getAllPersons() {
        return ldapTemplate.search(query().where("objectclass").is("person"), new PersonAttributesMapper());
    }
    @Override
    public PersonDTO getPersonNamesByUid(String userId) {
        List<PersonDTO> people = ldapTemplate.search(query().where("uid").is(userId), new PersonAttributesMapper());
        return ((null != people && !people.isEmpty()) ? people.get(0) : null);
    }
    private class PersonAttributesMapper implements AttributesMapper<PersonDTO> {
        public PersonDTO mapFromAttributes(Attributes attrs) throws NamingException {
            PersonDTO person = new PersonDTO();
            person.setUserId(null != attrs.get("uid") ? (String) attrs.get("uid").get() : null);
            person.setFullName((String) attrs.get("cn").get());
            person.setLastName((String) attrs.get("sn").get());
            person.setDescription(null != attrs.get("description") ? (String) attrs.get("description").get() : null);
            return person;
        }
    }
    private class PersonNameAttributesMapper implements AttributesMapper<String> {
        public String mapFromAttributes(Attributes attrs) throws NamingException {
            return attrs.get("cn").get().toString();
        }
    }
}
