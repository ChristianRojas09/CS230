package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	//next player identifier
	private static long nextPlayerId = 1;

	//next team identifier
	private static long nextTeamId = 1;

	// Add missing pieces to turn this class a singleton 
	private static GameService service;

	private GameService() { //default constructor
	}

	public static GameService getInstance(){
		//check for GameService
		if(service == null) {
			service = new GameService();
			System.out.println("New Game Created.");
		}
		else{
			System.out.println("Game already exists.");
		}
		return service;
	}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		Iterator<Game> gamesIterator = games.iterator();
		//iterate over the games list
		while(gamesIterator.hasNext()) {
			Game gameInstance = gamesIterator.next();
			if(gameInstance.getName().equalsIgnoreCase(name)) {
				return gameInstance; //if game already exists, return the instance
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same id
		Iterator<Game> gamesIterator = games.iterator();
		// if found, simply assign that instance to the local variable
		while(gamesIterator.hasNext()) {
			Game gameInstance = gamesIterator.next();
			if(gameInstance.getId() == id) {
				//if game already exists, return game instance
				return gameInstance;
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Iterator<Game> gamesIterator = games.iterator();
		while(gamesIterator.hasNext()) { //iterate over games list
			Game gameInstance = gamesIterator.next();
			if(gameInstance.getName().equalsIgnoreCase(name)) {
				//if game already exists, return instance
				return gameInstance;
			}
		}
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	public long getNextPlayerId() {
		return nextPlayerId;
	}

	public long getNextTeamId() {
		return nextTeamId;
	}

	public GameService() {
	}
}
