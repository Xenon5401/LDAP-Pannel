package bts_ciel.local.ldap_api.user;

import org.springframework.ldap.odm.annotations.*;
import javax.naming.ldap.LdapName;
import java.util.List;
import java.util.ArrayList;

@Entry(base = "ou=users", objectClasses = {"inetOrgPerson", "person"})
public class LdapUser {
    
    @Id
    private LdapName dn;  // Distinguished Name (l'identifiant LDAP)
    
    @Attribute(name = "uid")
    private String username;

    @Attribute(name = "cn")
    private String commonName;

    @Attribute(name = "memberOf")
    private List<String> memberOf;  // Liste des groupes LDAP

    // Get
    public String getUsername() {
        return username;
    }

    public String getCommonName() {
        return commonName;
    }

    public LdapName getDn() {
        return dn;
    }

    public List<String> getMemberOf() {
        return memberOf != null ? memberOf : new ArrayList<>();
    }

}