package bts_ciel.local.ldap_api.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Map;
import org.springframework.web.bind.annotation.*;  // ← imports Spring

@RestController
@RequestMapping("/api")  // ← base path for all endpoints in this controller

public class UserController {  

    @Autowired
    private LdapUserRepository ldapUserRepository;

    @GetMapping("/users")  // ← maps GET requests to /users
    public List<LdapUser> getUsers() {
        return ldapUserRepository.findAll();
    }
    // @GetMapping("/users")  // ← maps GET requests to /users
    // public Map<String, Integer> getUsers() {
    //     return Map.of("List of users", 5);  // ← returns a JSON object with count
    // }
    @GetMapping("/groups")  // ← maps GET requests to /groups
    public List<String> getGroup() {
        return Arrays.asList("group1", "group2");  // ← returns a list of groups as JSON
    }
}