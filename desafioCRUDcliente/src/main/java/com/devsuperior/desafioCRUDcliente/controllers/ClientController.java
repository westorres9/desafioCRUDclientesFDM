package com.devsuperior.desafioCRUDcliente.controllers;

import com.devsuperior.desafioCRUDcliente.dto.ClientDTO;
import com.devsuperior.desafioCRUDcliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAllPaged(Pageable pageable) {
        Page<ClientDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }
}
