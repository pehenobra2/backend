package com.reallidi.backend.repository;

import com.reallidi.backend.model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Long> {

}
