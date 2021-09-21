package br.com.limaisaias.desafioBackend.repository;

import br.com.limaisaias.desafioBackend.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
