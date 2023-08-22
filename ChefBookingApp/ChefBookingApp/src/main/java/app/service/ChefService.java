package app.service;

import java.util.List;

import app.dao.ChefDao;
import app.dao.IChefDao;
import app.model.Chef;

public class ChefService implements IChefService {
	
	IChefDao chefDao = new ChefDao();

	@Override
	public Chef get(int id) throws ChefNotFoundException {
		Chef chef =  chefDao.get(id);
		if(chef==null) {
			throw new ChefNotFoundException("Chef with the given id not found !");
		}
		return chef;
	}

	@Override
	public List<Chef> getAll() throws ChefNotFoundException {
		List<Chef> chefs = chefDao.findChefs();
		if (chefs.isEmpty()) {
			throw new ChefNotFoundException("No chefs were found !");
		}
		return chefs;
	}

	@Override
	public void add(Chef chef) {
		chefDao.insert(chef);
	}

	@Override
	public void update(Chef chef) {
		chefDao.update(chef);
	}

	@Override
	public void delete(Chef chef) {
		chefDao.delete(chef);
	}
	
}
