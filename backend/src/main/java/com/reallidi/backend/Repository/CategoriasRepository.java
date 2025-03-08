package com.reallidi.backend.Repository;

import com.reallidi.backend.Model.Categorias;
import com.reallidi.backend.Model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    List<Categorias> findAllByOrderByNomeAsc();

    List<Categorias> findAllByNomeIn(List<String> nomes);

}
