package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */

public class Game extends Entity {
	long id;
	String name;
	
	private List<Team> teams = new ArrayList<Team>();
	


	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	
	// @return the id
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Team addTeam(String name) {
		Team team = null;
		Iterator<Team>teamsIterator = teams.iterator();
		
		while(teamsIterator.hasNext()) { //This will iterator over the team names
			Team teamInstance = teamsIterator.next();
			if (teamInstance.getName().equalsIgnoreCase(name)) {
				team = teamInstance;
			}
			else{
				teams.add(team);
			}
		}
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
