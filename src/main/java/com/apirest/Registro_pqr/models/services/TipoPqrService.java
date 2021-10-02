package com.apirest.Registro_pqr.models.services;

import java.util.List;

import com.apirest.Registro_pqr.models.dao.TipoPqrDao;
import com.apirest.Registro_pqr.models.entity.TipoPqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPqrService {

    @Autowired
    private TipoPqrDao dao;

    public List<TipoPqr> findAll() {
        return dao.findAll();
    }

    public TipoPqr findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public TipoPqr save(TipoPqr tipopqr) {
        return dao.save(tipopqr);
    }

}
