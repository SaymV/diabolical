package edu.lmu.cs.diabolical.ws.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public class CharacterDaoDatastoreImpl implements CharacterDao {

	@Override
	public List<Character> getCharacters(String name, String className,
			Gender gender, Integer minLevel, Integer maxLevel) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Character");
		PreparedQuery pq = datastore.prepare(q);

		List<Character> result = new ArrayList<Character>();
		for (Entity characterEntity: pq.asIterable()) {
			result.add(entityToCharacter(characterEntity));
		}

		return result;
	}

	@Override
	public Character getCharacterById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCharacter(Character c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Character createOrUpdateCharacter(Character c) {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Character createCharacter(Character c) {
		// TODO Auto-generated method stub
		return c;
	}

	/**
	 * Helper for "converting" a Datastore Entity into a Character object.
	 */
	private Character entityToCharacter(Entity characterEntity) {
		return new Character();
	}
}
