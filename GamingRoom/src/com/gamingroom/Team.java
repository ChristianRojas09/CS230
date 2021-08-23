package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	long id;
	String name;
	
	private List<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	public Player addPlayer(String name) {
		Player player = null; //local instance
		Iterator<Player> playersIterator = players.iterator(); //instance iterator
		while(playersIterator.hasNext()) { //while loops iterates over the player list
			Player playerInstance = playersIterator.next();
			
			//check to make sure player name does not already exist
			if(playerInstance.getName().equalsIgnoreCase(name)) {
				player = playerInstance;
			}
			else {
				players.add(player);
			}
		}
		return player;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
