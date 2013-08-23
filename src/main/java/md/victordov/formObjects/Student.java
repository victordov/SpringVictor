package md.victordov.formObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/12/13
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.NONE)
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Student implements Serializable{

    @XmlElement(name = "id", type = Integer.class)
    private Integer id;

    @XmlElement(name = "name", type = String.class)
    @NotNull
    @Size(min=2, max=30)
    private String name;

    @XmlElement(name = "lname", type = String.class)
    @Size(min=2, max=30)
    private String lname;

    @JsonIgnoreProperties(value = {"students"})
    @JsonSerialize(as=Set.class)
    @XmlTransient

    private Set<Curs> curses = new HashSet<Curs>();

    @JsonIgnoreProperties(value = {"students"})
    @JsonSerialize(as=University.class)
    @XmlElement(name="university")
    private University university;

    public Student(){

    }

    public Student(String name, String lname){
        this.name  = name;
        this.lname = lname;
    }

    public Student(String name, String lname, Set<Curs> curses){
        this(name, lname);
        this.curses = curses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString(){
      return new StringBuilder(this.getId()+", " + this.getName()+", " + this.getLname()).toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        md.victordov.db.beans.Student student = (md.victordov.db.beans.Student) o;

        if (id != null ? !id.equals(student.getId()) : student.getId() != null) return false;
        if (lname != null ? !lname.equals(student.getLname()) : student.getLname()!= null) return false;
        if (name != null ? !name.equals(student.getName()) : student.getName()!= null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }

    public Set<Curs> getCurses() {
        return curses;
    }

    public void setCurses(Set<Curs> curses) {
        this.curses = curses;
    }

    public University getUniversity() {
        return university;
    }


    public void setUniversity(University university) {
        this.university = university;
    }
}
