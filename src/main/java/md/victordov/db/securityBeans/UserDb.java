package md.victordov.db.securityBeans;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "users")
public class UserDb implements Serializable {

    //Default constructor
    public UserDb() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    @Id
    @javax.persistence.Column(name = "username", nullable = false, insertable = true, updatable = true, length = 100)
    String username;

    @javax.persistence.Column(name = "password", nullable = false, insertable = true, updatable = true, length = 100)
    String password;

    @Type(type = "yes_no")
    @javax.persistence.Column(name = "account_non_expired", nullable = false, insertable = true, updatable = true)
    boolean accountNonExpired;

    @Type(type = "yes_no")
    @javax.persistence.Column(name = "account_non_locked", nullable = false, insertable = true, updatable = true)
    boolean accountNonLocked;

    @Type(type = "yes_no")
    @javax.persistence.Column(name = "credential_non_expired", nullable = false, insertable = true, updatable = true)
    boolean credentialsNonExpired;

    @Type(type = "yes_no")
    @javax.persistence.Column(name = "account_enabled", nullable = false, insertable = true, updatable = true)
    boolean accountEnabled;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_authorities",
            joinColumns = {@JoinColumn(name = "username")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    Set<Authority> authoritySet = new HashSet<Authority>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDb userDb = (UserDb) o;

        if (accountEnabled != userDb.accountEnabled) return false;
        if (accountNonExpired != userDb.accountNonExpired) return false;
        if (accountNonLocked != userDb.accountNonLocked) return false;
        if (credentialsNonExpired != userDb.credentialsNonExpired) return false;
        if (!password.equals(userDb.password)) return false;
        if (!username.equals(userDb.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (accountNonExpired ? 1 : 0);
        result = 31 * result + (accountNonLocked ? 1 : 0);
        result = 31 * result + (credentialsNonExpired ? 1 : 0);
        result = 31 * result + (accountEnabled ? 1 : 0);
        return result;
    }
}
