package com.devsuperior.desafioCRUDcliente;

import com.devsuperior.desafioCRUDcliente.dto.ClientDTO;
import com.devsuperior.desafioCRUDcliente.entities.Client;
import com.devsuperior.desafioCRUDcliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(Pageable pageable) {
        Page<Client> page = repository.findAll(pageable);
        return page.map(x-> new ClientDTO(x));
    }
}
