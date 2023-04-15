package com.dio.patterns.service.impl;

import com.dio.patterns.model.Address;
import com.dio.patterns.model.AddressRepository;
import com.dio.patterns.model.Client;
import com.dio.patterns.model.ClientRepository;
import com.dio.patterns.service.ClientService;
import com.dio.patterns.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    // Singleton: @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ZipCodeService zipCodeService;

    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void save(Client client) {
        saveClientWithZipCode(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDb = clientRepository.findById(id);
        if (clientDb.isPresent()) {
            saveClientWithZipCode(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithZipCode(Client client) {
        String zipcode = client.getAddress().getZipcode();
        Address address = addressRepository.findById(zipcode).orElseGet(() -> {
            Address newAddress = zipCodeService.zipLookUp(zipcode);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);

        clientRepository.save(client);
    }

}
