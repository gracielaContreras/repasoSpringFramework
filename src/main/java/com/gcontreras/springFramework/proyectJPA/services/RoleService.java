package com.gcontreras.springFramework.proyectJPA.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcontreras.springFramework.proyectJPA.entities.Role;
import com.gcontreras.springFramework.proyectJPA.models.AuditDetails;
import com.gcontreras.springFramework.proyectJPA.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;
    @Autowired
    private KafkaTemplate<Integer, String> getKafkaTemplate;
    @Autowired
    private ObjectMapper mapper;

    public List<Role> getRoles(){
        return  repository.findAll();
    }

    public Role create(Role role){
        Role rolCreated = repository.save(role);

        String userAuthentication = SecurityContextHolder.getContext().getAuthentication().getName();
        AuditDetails details = new AuditDetails(role.getName(),userAuthentication);

        try {
            /**
             * Utilizando el producer.
             * El siguiente código publicará un mensaje en el topic "prueba-topic"
             * con un message key igual al id del objeto y
             * un message con el contenido del objeto.
             */
            getKafkaTemplate.send(
                    "prueba-topic",  // Nombre del topic creado
                    mapper.writeValueAsString(details)); // se convierte de Objeto a String


        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error parsing the message");
        }
        return rolCreated;
    }

    public Role update(Integer id, Role role) {
        Optional<Role> result = repository.findById(id);
        if(result.isPresent()){
            return repository.save(role);
        } else {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, String.format("Role %s not found", id));
        }
    }

    public void delete(Integer id) {
        Optional<Role> result = repository.findById(id);
        if (result.isPresent()){
            repository.delete(result.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role %s not found", id));
        }
    }
}
