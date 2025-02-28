package com.reallidi.backend.Repository;

import com.reallidi.backend.Model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Long> {

}
