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
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "university")
@XmlAccessorType(XmlAccessType.NONE)
@JsonAutoDetect
public class University implements Serializable{

    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "universityName")
    private String universityName;

    @XmlElement(name = "address")
    private String address;

    @JsonIgnoreProperties(value = {"university"})
    @JsonSerialize(as = Set.class)
    private Set<md.victordov.formObjects.Student> students = new HashSet<md.victordov.formObjects.Student>();


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

    public Set<md.victordov.formObjects.Student> getStudents() {
        return students;
    }

    public void setStudents(Set<md.victordov.formObjects.Student> students) {
        this.students = students;
    }
}
