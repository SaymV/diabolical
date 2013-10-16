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
	public Character getCharacterById(Long id) {
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
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = characterToEntity(c);
		datastore.put(entity);
		c.setId(entity.getKey().getId());
		return c;
	}

	/**
	 * Helper for "converting" a Datastore Entity into a Character object.
	 */
	private Character entityToCharacter(Entity characterEntity) {
		Character result = new Character();
		result.setId(characterEntity.getKey().getId());
		result.setName((String)characterEntity.getProperty("name"));
		result.setGender(Gender.valueOf((String)characterEntity.getProperty("gender")));
		result.setClassType((String)characterEntity.getProperty("classType"));
		result.setLevel((Long)characterEntity.getProperty("level"));
		result.setMoney((Long)characterEntity.getProperty("money"));
		return result;
	}
	
	/**
	 * Helper for vice versa.
	 */
	private Entity characterToEntity(Character character) {
		Entity result = new Entity("Character");
		result.setProperty("name", character.getName());
		result.setProperty("gender", character.getGender().name());
		result.setProperty("classType", character.getClassType());
		result.setProperty("level", character.getLevel());
		result.setProperty("money", character.getMoney());
		return result;
	}
}
