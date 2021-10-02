package com.apirest.Registro_pqr.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.Registro_pqr.models.entity.Pqr;
import com.apirest.Registro_pqr.models.services.PqrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class PrqController {

    @Autowired
    private PqrService service;

    // MOSTRAR TODO
    @GetMapping("/pqr/list")
    public List<Pqr> listAll() {
        return service.listAll();
    }

    // MOSTRAR POR ID
    @GetMapping("/pqr/{id}")
    public Pqr findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // CREAR NUEVO PQR
    @PostMapping("/pqr/new")
    public ResponseEntity<?> createGanio(@RequestBody Pqr pqr) {
        Pqr pqrNew;
        Map<String, Object> response = new HashMap<>();
        try {
            pqrNew = service.save(pqr);
        } catch (DataAccessException e) {
            response.put("mensaje", "¡Error al agregar el artículo!");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El artículo ha sido creado con éxito!");
        response.put("almacen", pqrNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    // ACTUALIZAR DATOS
    @PutMapping("/pqr/updated")
    public ResponseEntity<?> Listupdate(@RequestBody Pqr pqr) {
        Pqr pqrUpdated;
        Map<String, Object> response = new HashMap<>();
        try {
            pqrUpdated = service.save(pqr);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el registro del artículo");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El artículo ha sido actualizado con éxito!");
        response.put("almacen", pqrUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/pqr/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.delete(id);
            response.put("mensaje", "El parametro con id ha sido eliminado con éxito!");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar El Usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
