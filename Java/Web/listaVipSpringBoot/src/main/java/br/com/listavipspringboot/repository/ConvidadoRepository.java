package br.com.listavipspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.listavipspringboot.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
