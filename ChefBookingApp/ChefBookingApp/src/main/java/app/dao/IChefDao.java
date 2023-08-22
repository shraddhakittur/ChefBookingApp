package app.dao;

import java.util.List;

import app.model.Chef;

public interface IChefDao {

 Chef get(int id);

 List<Chef> findChefs();

 void insert(Chef chef);

 void update(Chef chef);

 void delete(Chef chef);
}