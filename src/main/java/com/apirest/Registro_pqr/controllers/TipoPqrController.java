package com.apirest.Registro_pqr.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.Registro_pqr.models.entity.TipoPqr;
import com.apirest.Registro_pqr.models.services.TipoPqrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/api/v1")
public class TipoPqrController {

    @Autowired
    private TipoPqrService service;

    @GetMapping("/tipopqr/list")
    public List<TipoPqr> findAll() {
        return service.findAll();
    }

    @GetMapping("/tipopqr/{id}")
    public TipoPqr findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/tipopqr/new")
    public ResponseEntity<?> createGanio(@RequestBody TipoPqr tipopqr) {
        TipoPqr tipopqrNew;
        Map<String, Object> response = new HashMap<>();
        try {
            tipopqrNew = service.save(tipopqr);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Error al agregar el artículo!");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El artículo ha sido creado con éxito!");
        response.put("almacen", tipopqr);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/tipoPqr/updated")
    public ResponseEntity<?> Listupdate(@RequestBody TipoPqr tipopqr) {
        TipoPqr tipopqrUpdated;
        Map<String, Object> response = new HashMap<>();
        try {
            tipopqrUpdated = service.save(tipopqr);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el registro del artículo");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El artículo ha sido actualizado con éxito!");
        response.put("almacen", tipopqrUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

}
