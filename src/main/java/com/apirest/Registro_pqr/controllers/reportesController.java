package com.apirest.Registro_pqr.controllers;

import com.apirest.Registro_pqr.models.services.ReportesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/api/v1")
public class reportesController {

    @Autowired
    private ReportesServices service;

    @GetMapping("reporte/pqr/{id}")
    public ResponseEntity<?> mostrarPqr(@PathVariable("id") Integer id) throws Exception {
        String filename = "PQR.pdf";
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
        ResponseEntity<byte[]> response = new ResponseEntity<>(service.mostrarPqr(id), cabecera, HttpStatus.OK);
        return response;
    }

}
