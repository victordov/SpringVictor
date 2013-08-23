package md.victordov.db.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
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
@Entity
@Table(name = "student")
@NamedQueries(@NamedQuery(name = "studentForCourse", query = "select distinct s from Student as s join s.curses as curs where lower(s.name) like concat('%',:studName,'%') and lower(curs.cursName) like concat('%',lower(:courseName),'%')"))
public class Student implements Serializable{

    @Id
    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @javax.persistence.Column(name = "name", nullable = true, insertable = true, updatable = true, length = 100)
    @NotNull
    @Size(min=2, max=30)
    private String name;

    @javax.persistence.Column(name = "lname", nullable = true, insertable = true, updatable = true, length = 100)
    @NotNull
    @Size(min=2, max=30)
    private String lname;

    @ManyToMany(fetch = FetchType.LAZY)
    //@JoinColumn()
    @JoinTable(name="student_curs",
            joinColumns={@JoinColumn(name="student_id")},
            inverseJoinColumns={@JoinColumn(name="curs_id")})
    @JsonIgnoreProperties(value = {"students"})
    @JsonSerialize(as=Set.class)
    @XmlTransient
    private Set<Curs> curses = new HashSet<Curs>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
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
    @XmlElement(name = "id", type = Integer.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @XmlElement(name = "name", type = String.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "lname", type = String.class)
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

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (lname != null ? !lname.equals(student.lname) : student.lname != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }
    @XmlTransient
    public Set<Curs> getCurses() {
        return curses;
    }

    public void setCurses(Set<Curs> curses) {
        this.curses = curses;
    }
    @XmlTransient
    public University getUniversity() {
        return university;
    }


    public void setUniversity(University university) {
        this.university = university;
    }
}
