package md.victordov.db.securityBeans;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "role_name")
    String roleName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_authorities",
            joinColumns = {@JoinColumn(name = "authority_id")},
            inverseJoinColumns = {@JoinColumn(name = "username")})
    Set<UserDb> userDbSet = new HashSet<UserDb>();

    @Override
    public String getAuthority() {
        return roleName;
    }
}
