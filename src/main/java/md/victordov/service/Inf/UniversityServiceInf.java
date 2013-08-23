package md.victordov.service.Inf;

import md.victordov.db.beans.University;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UniversityServiceInf {
    List<University> findAll();
    University findById(Integer id);
    void save(University university);
    void delete(University university);
    void update(University university);
}
