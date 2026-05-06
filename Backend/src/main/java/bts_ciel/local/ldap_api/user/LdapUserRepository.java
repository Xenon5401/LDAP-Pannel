package bts_ciel.local.ldap_api.user;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LdapUserRepository extends LdapRepository<LdapUser> {
    // Tu peux ajouter des méthodes de recherche personnalisées
    Optional<LdapUser> findByUsername(String username);
    List<LdapUser> findAll();
}
