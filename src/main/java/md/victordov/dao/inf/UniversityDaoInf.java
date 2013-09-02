package md.victordov.dao.inf;

import md.victordov.db.beans.University;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:12 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UniversityDaoInf {
    List<University> findAll();
    University findById(Integer id);
    void save(University university);
    void delete(University university);
    void update(University university);
}
