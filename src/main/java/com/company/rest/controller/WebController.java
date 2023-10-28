package com.company.rest.controller;

import com.company.domain.Credit;
import com.company.rest.dto.ClientDto;
import com.company.rest.dto.CreditDto;
import com.company.service.ClientService;
import com.company.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WebController {

    private final ClientService clientService;
    private final CreditService creditService;

    @GetMapping("/i")
    public List<ClientDto> getAllClientList() {
        return clientService.getAll().stream().map(ClientDto::toDto).collect(Collectors.toList());
    }

    @GetMapping("/clientprofile/{id}/clientcr")
    public CreditDto getClientCredit(@PathVariable int id) {
        Credit credit = creditService.getById(clientService.getById(id).getCredits());
        if (credit == null) {
            return null;
        }
        return CreditDto.toDto(credit);
    }
}
