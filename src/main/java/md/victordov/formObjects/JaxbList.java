package md.victordov.formObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/30/13
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "List")
@XmlSeeAlso({JavaBean.class})
public class JaxbList<T> implements Serializable {
    protected List<T> list;

    public JaxbList() {
    }

    public JaxbList(List<T> list) {
        this.list = list;
    }

    @XmlElement(name = "Item")
    public List<T> getList() {
        return list;
    }
}