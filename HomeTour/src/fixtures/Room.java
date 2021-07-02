package fixtures;
import java.util.*;
public class Room extends Fixture{
	String name;
	//Room[] exits = new Room[4];
	int fWall;
	int lWall;
	int rWall;
	int bWall;
	int[] walls = new int[3];
	public Room(String name) {
		this.name = name;
		//Random rand = new Random();
		//int random = rand.nextInt(4);
		//int[] walls = new walls[4];
	}
	public Room(String name, int fWall, int lWall, int rWall, int bWall, String shortDescription, String longDescription) {
		this.name = name;
		this.fWall = fWall;
		this.lWall = lWall;
		this.rWall = rWall;
		this.bWall = bWall;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		//{forward, left, right, back}
		//this.walls = {fWall, lWall, rWall, bWall}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getfWall() {
		return fWall;
	}
	public void setfWall(int fWall) {
		this.fWall = fWall;
	}
	public int getbWall() {
		return bWall;
	}
	public void setbWall(int bWall) {
		this.bWall = bWall;
	}
	public int getrWall() {
		return rWall;
	}
	public void setrWall(int rWall) {
		this.rWall = rWall;
	}
	public int getlWall() {
		return lWall;
	}
	public void setlWall(int lWall) {
		this.lWall = lWall;
	}
	public void printWalls() {
		int fWall = this.fWall; 
		int lWall = this.lWall;
		int rWall = this.rWall;
		int bWall = this.bWall;
		String name = this.name;
		System.out.println(name + " walls: {(f)" + fWall + ", (l)" + lWall + ", (r)" + rWall + ", (b)" + bWall + "}");
	}
	
	
	}
	/*
	public void setExits(Room[] exits) {
		this.exits = exits;
	}*/
	
	/*public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[?]; // size is your choice
	}
		
	public Room[] getExits() {
		
	}
		
	public Room getExit(String direction) {
		
	}*/
