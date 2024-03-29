package org.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentService service;


    @Transactional
    public Student save(Student student) {
        studentDao.createStudent(student);

        return service.getStudent(student.getUsername());
    }

    @Transactional(propagation = Propagation.NEVER)
    public Student getStudent(String username) {
//        return studentDao.getStudentByUsername(username);
        return null;
    }
}
