package com.PorfolioArgPrograma.Porfolio.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint para recibir reportes de Content Security Policy.
 * El frontend envia reportes de violacion de CSP a este endpoint.
 */
@RestController
@RequestMapping("/csp-report")
@CrossOrigin
public class CspReportController {

    private static final Logger logger = LoggerFactory.getLogger(CspReportController.class);

    @PostMapping
    public ResponseEntity<Void> report(@RequestBody(required = false) Map<String, Object> report) {
        if (report != null) {
            logger.warn("CSP violation report: {}", report);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
