package bts_ciel.local.ldap_api.user;

import org.springframework.ldap.odm.annotations.*;
import javax.naming.ldap.LdapName;

@Entry(base = "ou=users", objectClasses = {"inetOrgPerson", "person"})
public class LdapUser {
    
    @Id
    private LdapName dn;  // Distinguished Name (l'identifiant LDAP)
    
    @Attribute(name = "uid")
    private String username;

    @Attribute(name = "cn")
    private String commonName;
    // Getters/Setters (ou utilise Lombok: @Data)
}