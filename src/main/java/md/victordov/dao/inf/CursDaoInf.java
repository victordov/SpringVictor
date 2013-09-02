package md.victordov.dao.inf;

import md.victordov.db.beans.Curs;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CursDaoInf {
    List<Curs> findAll();
    Curs findById(Integer id);
    void save(Curs curs);
    void delete(Curs curs);
    void update(Curs curs);
}
