package com.ivan.designing.tables.controller;

import com.ivan.designing.tables.model.dto.ClientGetTemp;
import com.ivan.designing.tables.repository.client.ClientRepo;
import com.ivan.designing.tables.repository.client.ClientDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloController {

    private final ClientDAO clientDAO;

    private final ClientRepo clientRepo;

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/get/client/{id}")
    public String /*List<ClientGetDTO>*/ findClientById(@PathVariable Long id) {
        List<ClientGetTemp> res = clientRepo.findAllByClientIdIn(Arrays.asList(id));
        res.stream().forEach(clientGetTemp -> {
            System.out.println(clientGetTemp.getClientId());
        });
        return "";
//        return clientDAO.findById(id);
    }


}
