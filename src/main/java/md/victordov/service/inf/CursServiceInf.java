package md.victordov.service.inf;

import md.victordov.db.beans.Curs;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CursServiceInf {
    List<Curs> findAll();
    Curs findById(Integer id);
    void save(Curs curs);
    void delete(Curs curs);
    void update(Curs curs);
}
