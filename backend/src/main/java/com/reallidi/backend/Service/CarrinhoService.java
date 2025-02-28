package com.reallidi.backend.Service;

import com.reallidi.backend.Model.Carrinho;
import com.reallidi.backend.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

}
