package bts_ciel.local.ldap_api.user;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Map;
import org.springframework.web.bind.annotation.*;  // ← imports Spring

@RestController
@RequestMapping("/api")  // ← base path for all endpoints in this controller

public class UserController {  

    @Autowired
    private LdapUserRepository ldapUserRepository;

    @GetMapping("/users")  // ← maps GET requests to /users
    public List<String> getUsers() {
        return ldapUserRepository.findAll().stream()
                .map(LdapUser::getUsername)
                .collect(Collectors.toList());
    }
    // @GetMapping("/users")  // ← maps GET requests to /users
    // public Map<String, Integer> getUsers() {
    //     return Map.of("List of users", 5);  // ← returns a JSON object with count
    // }
    @GetMapping("/users/groups")  // ← maps GET requests to /users/{username}
    public Map<String, List<String>> getGroup() {
        return ldapUserRepository.findAll().stream()
                .collect(Collectors.toMap(LdapUser::getUsername, LdapUser::getMemberOf));
    }
}