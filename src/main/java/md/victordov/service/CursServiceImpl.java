package md.victordov.service;

import md.victordov.dao.Inf.CursDaoInf;
import md.victordov.db.beans.Curs;
import md.victordov.service.Inf.CursServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:25 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CursServiceImpl implements CursServiceInf {

    @Autowired
    private CursDaoInf cursDaoInf;

    @Override
    @Transactional(readOnly = true)
    public List<Curs> findAll() {
        return cursDaoInf.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Curs findById(Integer id) {
        return cursDaoInf.findById(id);
    }

    @Override
    public void save(Curs curs) {
        cursDaoInf.save(curs);
    }

    @Override
    public void delete(Curs curs) {
        cursDaoInf.delete(curs);
    }

    @Override
    public void update(Curs curs) {
        cursDaoInf.update(curs);
    }
}
