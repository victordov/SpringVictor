package md.victordov.db.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
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
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "university")
@XmlAccessorType(XmlAccessType.NONE)
@JsonAutoDetect
@Entity
@Table(name="university")
@NamedQueries(@NamedQuery(name = "withAssocEntities",query = "select distinct(u) from University u left join fetch u.students"))
public class University implements Serializable{

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "id")
    private int id;

    @javax.persistence.Column(name = "university_name", nullable = true, insertable = true, updatable = true, length = 100)
    @XmlElement(name = "universityName")
    private String universityName;

    @javax.persistence.Column(name = "address", nullable = true, insertable = true, updatable = true, length = 100)
    @XmlElement(name = "address")
    private String address;

    @OneToMany(mappedBy = "university")
    @JsonIgnoreProperties(value = {"university"})
    @JsonSerialize(as = Set.class)
    private Set<Student> students = new HashSet<Student>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (universityName != null ? !universityName.equals(that.universityName) : that.universityName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (universityName != null ? universityName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        //result = 31 * result + (students != null ? students.hashCode() : 0); question regarding comparing to compare or not
        return result;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
