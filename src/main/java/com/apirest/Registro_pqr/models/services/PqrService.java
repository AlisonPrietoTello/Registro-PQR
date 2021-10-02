package com.apirest.Registro_pqr.models.services;

import java.util.List;

import com.apirest.Registro_pqr.models.dao.PqrDao;
import com.apirest.Registro_pqr.models.entity.Pqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PqrService {

    @Autowired
    private PqrDao dao;

    public List<Pqr> listAll() {
        return dao.findAll();
    }

    public Pqr findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public Pqr save(Pqr pqr) {
        return dao.save(pqr);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

}
