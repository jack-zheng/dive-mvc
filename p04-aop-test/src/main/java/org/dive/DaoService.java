package org.dive;


import org.springframework.transaction.annotation.Transactional;

public class DaoService {
    @Transactional
    public void save(String data) {
        System.out.println("Saving data: " + data);
    }
}
