package game;
import fixtures.Room;
public class RoomManager{

	Room[] house;
	Room startingRoom;
	Player p1;
	//{forward, left, right, back, shortdescription, longdescription}
	public RoomManager() {
	}
	public void init() {
		Room kit = new Room("Kitchen",1,1,0,0,
				"Truely a place only for those who can handle the heat.",
				"A large robust brick oven acts as a beautiful and authentic centerpeice \nto a kitchen built for use over its looks. The kitchen \nis furnished with a beautiful copper cooking set.");
		Room lv = new Room("Living Room",0,1,1,0, "That couch sure does look comfy.",
				"A perfect napping room filled with plants and many napping surfaces.\nAlso includes a TV and related entertainment equipment. \nWithin also lies a goodboy who seems to be napping quietly.");
		Room bd = new Room("Bed Room",1,0,1,0,"A bedchamber fit for a King!",
				"If comfort is your dream look no further.\n20,000 Thread count silk sheets and pillows which are both \nsoft and strong enough to endure anything you can think of in the bed room. Who doesn't love jumping on the bed!");
		Room ld = new Room("Laundry Room",0,1,0,1, "It smells like wet dog in here...",
				"Not the ideal place to spend your time so this room was built \nwith a laundry production line mindset. \nFully automated. Just drop your clothing in the bin and walk away!");
		Room sum = new Room("Summoning Room",0,1,1,0,"Run",
				"There seems to be some large circle with a lot of complex looking \nsymbols and runes around the entirity of the circle.");
		Room br = new Room("Bath Room",0,0,1,1, "A luxurious bathtub with a circular window.",
				"This sheet white porcelain bathtub overlooks a beautiful meadow through its massive circular window.\n You don't know why anybody would ever leave this tub.");
		startingRoom = lv;
		house = new Room[]{kit,lv,bd,ld,sum,br};
		p1 = new Player(lv, lv, bd, kit);
		printCommands();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//lv.printWalls();
	}
	public void printCommands() {
		System.out.println("Available direction commands: ");
		System.out.println("left,right,forward,back");
		System.out.println("examine, inspect, help");
	}
	public void checkOther(String direction) {
		Room currRoom = p1.getCurrRoom();
		String input = direction.toLowerCase();
		//System.out.println(input);
		switch(input) {
		//java 8 issue !~~~~~~~~~~~~~~~~
		//case "", "", "" 
			case "inspect":
				System.out.println(currRoom.getShortDescription());
				break;
			case "help":
				printCommands();
				break;
			case "examine":
				System.out.println(currRoom.getLongDescription());
				if(currRoom.getName().equals("Summoning Room")) {
					System.out.println("It seems you might have made a mistake in getting too close to the circle!");
					try {
						Thread.sleep(4000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Magic encircles the room!");
					int delay = 5000;
					long start = System.currentTimeMillis();
					while(start >= System.currentTimeMillis() - delay);
					System.out.println("Suddenly the runes glow and an arch demon emerges from the summoning circle!!!");
					try {
						Thread.sleep(3000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("You quickly check your available commands and realize something awful... ");
					start = System.currentTimeMillis();
					while(start >= System.currentTimeMillis() - delay);
					System.out.println("The programmer didn't have enough time to give you a way to fight back yet.");
					start = System.currentTimeMillis();
					while(start >= System.currentTimeMillis() - delay);
					System.out.println("You fall to the ground with nothing but panic in your eyes.");
					start = System.currentTimeMillis();
					while(start >= System.currentTimeMillis() - delay);
					System.out.println("In one motion the demon impales you through the gut you and lifts you into the air.");
					start = System.currentTimeMillis();
					while(start >= System.currentTimeMillis() - delay);
					System.out.println("Your last thought as the demon licks your blood raining down on his face... ");
					try {
						Thread.sleep(5000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("\"I was never meant to succeed.\"");
					try {
						Thread.sleep(5000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("You died!");
					System.exit(0);
				}
				break;
			default: 
				System.out.println("Sorry I didn't understand that command please try again!");
		}
	}
	public boolean checkExit(String direction){
		Room currRoom = p1.getCurrRoom();
		String input = direction.toLowerCase();
		//System.out.println(input);
		switch(input) {
			case "left":
				//System.out.println("hit2");
				//System.out.println(currRoom.getlWall());
				//p1.getCurrRoom().printWalls();
				if(currRoom.getlWall() == 0) {
					//System.out.println("hit3");
					return false;
				}
				else {
					return true;
				}
			case "right":
				//System.out.println("hit2");
				///////////starting tomorrow here. print out wall variables somethings not getting set right
				//p1.getCurrRoom().printWalls();
				//System.out.println(currRoom.getrWall());
				if(currRoom.getrWall() == 0) {
					//System.out.println("hit3");
					return false;
				}
				else
					return true;
			case "forward":
				if(currRoom.getfWall() == 0)
					return false;
				else
					return true;
			case "back":
				if(currRoom.getbWall() == 0)
					return false;
				else
					return true;
			default:
					//System.out.println("Didn't understand that command! try again!");
				return false;
			}
	}
	protected void movePlayer(String direction) {
		Room currRoom = p1.getCurrRoom();
		Room prevRoom = p1.getCurrRoom();
		Room nextRoomL = p1.getNextRoomL();
		Room nextRoomR = p1.getNextRoomR();
		switch(direction.toLowerCase()) {
			case "left":
				//System.out.println(currRoom.getName());
				if(currRoom.getName().equals("Living Room")) {
					p1.setCurrRoom(nextRoomL);
					//p1.setNextRoomL(nextRoomL);
					p1.setNextRoomR(currRoom);
					//this is forward bad naming 
					//goes to bathroom
					p1.setNextRoomL(house[5]);
					//reset prev
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Living Room to The Bed Room.");
					break;
				}
				if(currRoom.getName().equals("Kitchen")) {
					//move to lv
					p1.setCurrRoom(nextRoomL);
					//set next to kitchen or self
					p1.setNextRoomR(prevRoom);
					//far left
					p1.setNextRoomL(house[2]);
					//reset prev
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Kitchen to the Living Room.");
					break;
				}
				if(currRoom.getName().equals("Laundry Room")) {
					p1.setCurrRoom(nextRoomL);
					//set nextL to br
					p1.setNextRoomL(house[5]);
					//set nextR to ld
					p1.setNextRoomR(prevRoom);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Laundry room to the Summoning Room.");
					break;
				}
				if(currRoom.getName().equals("Summoning Room")) {
					p1.setCurrRoom(nextRoomL);
					//set nextL to bd
					p1.setNextRoomL(house[2]);
					//set nextR to sum
					p1.setNextRoomR(prevRoom);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Summoning Room to the Bath Room.");
					break;
				}
			case "right":
				if(currRoom.getName().equals("Living Room")) {
					p1.setCurrRoom(nextRoomR);
					//set nextL to 
					p1.setNextRoomL(prevRoom);
					//set nextR to 
					p1.setNextRoomR(house[3]);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Living Room to the Kitchen.");
					break;
				}
				if(currRoom.getName().equals("Bed Room")) {
					p1.setCurrRoom(nextRoomR);
					//set nextL to 
					p1.setNextRoomL(prevRoom);
					//set nextR to 
					p1.setNextRoomR(house[0]);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Bed Room to the Living Room.");
					break;
				}
				if(currRoom.getName().equals("Bath Room")) {
					p1.setCurrRoom(nextRoomR);
					//set nextL to 
					p1.setNextRoomL(prevRoom);
					//set nextR to 
					p1.setNextRoomR(house[3]);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Bath Room to the Summoning Room.");
					break;
					
				}
				if(currRoom.getName().equals("Summoning Room")) {
					p1.setCurrRoom(nextRoomR);
					//set nextL to 
					p1.setNextRoomL(prevRoom);
					//set nextR to 
					p1.setNextRoomR(house[0]);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Summoning Room to the Laundry Room");
					break;	
				}
				System.out.println("missed?");
				break;
				
			case "forward":
				if(currRoom.getName().equals("Bed Room")) {
					p1.setCurrRoom(nextRoomL);
					//set nextL to bd
					p1.setNextRoomL(prevRoom);
					//set nextR to summoning room
					p1.setNextRoomR(house[4]);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from Bed Room to the Bath Room.");
					break;
				}
				if(currRoom.getName().equals("Kitchen")) {
					p1.setCurrRoom(nextRoomR);
					//set nextL to 
					p1.setNextRoomL(house[3]);
					//set nextR to 
					p1.setNextRoomR(prevRoom);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Kitchen to the Laundry Room.");
					break;
				}	
			case "back":
				if(currRoom.getName().equals("Bath Room")) {
					p1.setCurrRoom(nextRoomL);
					//set nextL to 
					p1.setNextRoomL(prevRoom);
					//set nextR to 
					p1.setNextRoomR(house[1]);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Bath Room to the Bed Room.");
					break;
				}
				if(currRoom.getName().equals("Laundry Room")) {
					p1.setCurrRoom(nextRoomR);
					//set nextL to 
					p1.setNextRoomL(house[1]);
					//set nextR to 
					p1.setNextRoomR(prevRoom);
					//set prev 
					p1.setPrevRoom(prevRoom);
					System.out.println("Moving from the Laundry Room to the Kitchen.");
					break;
				}
			default:
				System.out.println("Something went wrong you should never hit this! line273");
			}
	}
	protected Room[] getHouse() {
		return house;
	}
	protected void setHouse(Room[] house) {
		this.house = house;
	}
	protected Room getStartingRoom() {
		return startingRoom;
	}
	protected void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
}
