package md.victordov.service;

import md.victordov.dao.Inf.UniversityDaoInf;
import md.victordov.db.beans.University;
import md.victordov.service.Inf.UniversityServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(readOnly = true)
public class UniversitateServiceImpl implements UniversityServiceInf {

    @Autowired
    UniversityDaoInf universityDaoInf;

    @Override
    public List<University> findAll() {
        return universityDaoInf.findAll();
    }

    @Override
    public University findById(Integer id) {
        return universityDaoInf.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(University university) {
        universityDaoInf.save(university);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(University university) {
        universityDaoInf.delete(university);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(University university) {
        universityDaoInf.update(university);
    }
}
