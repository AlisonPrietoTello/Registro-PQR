package com.apirest.Registro_pqr.models.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportesServices {

    @Autowired
    private DataSource dataSource;

    // METODO PARA GENERAR PDF
    public byte[] mostrarPqr(final Integer id) throws JRException, FileNotFoundException, SQLException {
        Connection conn = DataSource.getConnection();
        String reporteName = "TRAMITE_" + UUID.randomUUID().toString() + ".pdf";
        final ByteArrayOutputStream pdfBuffer = new ByteArrayOutputStream();
        Path file = Paths.get("C:/reportes/resources/").resolve("Pqr.jrxml").toAbsolutePath();
        System.out.println(file.toString());
        JasperReport jasperReport = JasperCompileManager.compileReport(file.toString());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ruta", "C:/reportes/resources/");
        parameters.put("id", id);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        JasperExportManager.exportReportToPdfStream(jasperPrint, pdfBuffer);
        conn.close();
        return pdfBuffer.toByteArray();
    }

}
