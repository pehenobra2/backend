package com.reallidi.backend.Service;

import com.reallidi.backend.Model.Adm;
import com.reallidi.backend.Repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmService {

    @Autowired
    private AdmRepository admRepository;

}
