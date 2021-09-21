package br.com.limaisaias.desafioBackend.service;

import br.com.limaisaias.desafioBackend.exception.BusinessException;
import br.com.limaisaias.desafioBackend.model.Model;
import br.com.limaisaias.desafioBackend.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;

@Service
public class ModelService {

    @Autowired
    ModelRepository repository;

    public Model create(Model model) throws BusinessException {

        Optional<Model> optional = repository.findById(model.getLogic());

        if (optional.isPresent()) {
            throw new BusinessException("Model already registered. ");
        }

        return repository.save(model);
    }

    public Optional<Model> findByLogic(Integer logic) {
        return repository.findById(logic);
    }

    public Model update(Integer logic, Model model) throws BusinessException {

        Optional<Model> optional = repository.findById(logic);

        if (optional.isEmpty()) {
            throw new BusinessException("Logic was not found in the database.");
        }

        ModelMapper modelMapper = new ModelMapper();

        Model newModel = modelMapper.map(model, Model.class);

        return repository.save(newModel);
    }
}
