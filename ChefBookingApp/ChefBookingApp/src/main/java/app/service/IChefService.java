package app.service;

import java.util.List;

import app.model.Chef;

public interface IChefService {
	 Chef get(int id) throws ChefNotFoundException;

	 List<Chef> getAll() throws ChefNotFoundException;

	 void add(Chef chef);

	 void update(Chef chef);

	 void delete(Chef chef);

}
