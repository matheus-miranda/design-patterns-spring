package com.dio.patterns.service;


import com.dio.patterns.model.Client;

/**
 * Strategy pattern
 */
public interface ClientService {

	Iterable<Client> getAll();

	Client getById(Long id);

	void save(Client client);

	void update(Long id, Client client);

	void delete(Long id);

}