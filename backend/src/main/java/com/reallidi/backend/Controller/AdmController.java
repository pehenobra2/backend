package com.reallidi.backend.controller;

import com.reallidi.backend.model.Adm;
import com.reallidi.backend.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdmController {

    @Autowired
    private AdmService admService;

}
