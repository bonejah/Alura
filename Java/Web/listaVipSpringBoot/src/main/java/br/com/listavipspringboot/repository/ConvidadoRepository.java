package br.com.listavipspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.listavipspringboot.models.Convidado;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
