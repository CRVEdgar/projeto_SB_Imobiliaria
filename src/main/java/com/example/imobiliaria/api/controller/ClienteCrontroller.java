package com.example.imobiliaria.api.controller;

import com.example.imobiliaria.api.assemblerConvert.ClienteConvertAssembler;
import com.example.imobiliaria.api.assemblerConvert.ClienteConvertDISAssembler;
import com.example.imobiliaria.api.model.dto.ClienteDTO;
import com.example.imobiliaria.domain.repository.ClienteRepository;
import com.example.imobiliaria.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteCrontroller {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConvertAssembler clienteConvertAssembler;

    @Autowired
    private ClienteConvertDISAssembler clienteConvertDISAssembler;

    @GetMapping
    public List<ClienteDTO> listar(){
        return clienteConvertAssembler
                .convert_Lista_para_DTO(clienteService.findAll());
    }

    @GetMapping("/{clienteId}")
    public ClienteDTO buscar(@PathVariable Long clienteId){
        return clienteConvertAssembler
                .convert_para_DTO(clienteService.findById(clienteId));
    }

    
}
