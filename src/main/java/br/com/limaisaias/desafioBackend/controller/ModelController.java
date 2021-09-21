package br.com.limaisaias.desafioBackend.controller;

import br.com.limaisaias.desafioBackend.exception.BusinessException;
import br.com.limaisaias.desafioBackend.model.Model;
import br.com.limaisaias.desafioBackend.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("v1/model")
public class ModelController {

    @Autowired
    private ModelService service;

    @PostMapping(consumes = MediaType.TEXT_HTML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create( Model model) throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(model));
    }

    @GetMapping("/{logic}")
    public ResponseEntity<?> findByLogic(@PathVariable Integer logic) {

        Optional<Model> optional = service.findByLogic(logic);

        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());
    }

    @PutMapping(value = "/{logic}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Integer logic, @Valid @RequestBody Model model) throws BusinessException {
        return ResponseEntity.ok(service.update(logic, model));
    }
}
