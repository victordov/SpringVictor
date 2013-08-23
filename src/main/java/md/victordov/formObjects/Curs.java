package md.victordov.formObjects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/12/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "university")
@XmlAccessorType(XmlAccessType.NONE)
@JsonAutoDetect
public class Curs implements Serializable{


    @XmlElement(name = "id")
    private int id;


    @XmlElement(name = "cursName")
    private String cursName;

    @JsonIgnoreProperties(value = {"curses"})
    @JsonSerialize(as = Set.class)
    private Set<md.victordov.formObjects.Student> students = new HashSet<md.victordov.formObjects.Student>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCursName() {
        return cursName;
    }

    public void setCursName(String cursName) {
        this.cursName = cursName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Curs curs = (Curs) o;

        if (id != curs.id) return false;
        if (cursName != null ? !cursName.equals(curs.cursName) : curs.cursName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cursName != null ? cursName.hashCode() : 0);
        return result;
    }

    public Set<md.victordov.formObjects.Student> getStudents() {
        return students;
    }

    public void setStudents(Set<md.victordov.formObjects.Student> students) {
        this.students = students;
    }
}
