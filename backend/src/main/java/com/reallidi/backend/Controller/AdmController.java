package com.reallidi.backend.Controller;

import com.reallidi.backend.Model.Adm;
import com.reallidi.backend.Service.AdmService;
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
