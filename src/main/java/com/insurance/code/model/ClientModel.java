package com.insurance.code.model;

import com.insurance.code.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@NoArgsConstructor
@Table(name = "client_details")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    private String name;
    private String dateofBirth;
    private String address;
    private String phoneNumber;

    public ClientModel(Integer id, ClientDTO clientDTO) {
        this.clientId = id;
        this.name = clientDTO.getName();
        this.dateofBirth = clientDTO.getDateofBirth();
        this.address = clientDTO.getAddress();
        this.phoneNumber = clientDTO.getPhoneNumber();
    }
    public ClientModel(ClientDTO clientDTO) {
        this.name = clientDTO.getName();
        this.dateofBirth = clientDTO.getDateofBirth();
        this.address = clientDTO.getAddress();
        this.phoneNumber = clientDTO.getPhoneNumber();
    }
}
