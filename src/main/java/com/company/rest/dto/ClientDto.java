package com.company.rest.dto;


import com.company.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private int id;

    private String name;

    private String birthday;

    private int credits;

    private int deposits;

    private int cardAccount;

    public static Client toDomainObject(ClientDto clientDto) {
        return new Client(clientDto.getId(), clientDto.getName(), clientDto.getBirthday(), clientDto.getCredits(),
                clientDto.getDeposits(), clientDto.getCardAccount());
    }

    public static ClientDto toDto(Client client) {
        return new ClientDto(client.getId(), client.getName(), client.getBirthday(), client.getCredits(),
                client.getDeposits(), client.getCardAccount());
    }
}
