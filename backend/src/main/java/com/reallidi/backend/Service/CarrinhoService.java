package com.reallidi.backend.service;

import com.reallidi.backend.model.Carrinho;
import com.reallidi.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository CarrinhoRepository;

}
