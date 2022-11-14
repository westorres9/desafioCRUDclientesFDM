package com.devsuperior.desafioCRUDcliente.services;

import com.devsuperior.desafioCRUDcliente.dto.ClientDTO;
import com.devsuperior.desafioCRUDcliente.entities.Client;
import com.devsuperior.desafioCRUDcliente.repositories.ClientRepository;
import com.devsuperior.desafioCRUDcliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(Pageable pageable) {
        Page<Client> page = repository.findAll(pageable);
        return page.map(x-> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> opt = repository.findById(id);
        Client entity = opt.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
        return new ClientDTO(entity);
    }


}
