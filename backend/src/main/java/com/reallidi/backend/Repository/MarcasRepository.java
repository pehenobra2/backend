package com.reallidi.backend.Repository;

import com.reallidi.backend.Model.Cliente;
import com.reallidi.backend.Model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long> {

    List<Marcas> findAllByOrderByNomeAsc();

    Marcas findByNome(String nome);
}
