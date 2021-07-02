package game;
import fixtures.Room;
public class Player {
	Room currRoom;
	Room prevRoom;
	Room nextRoomL;
	Room nextRoomR;
	public Player() {
	}
	public Player(Room currRoom, Room prevRoom, Room nextRoomL, Room nextRoomR) {
		this.currRoom = currRoom;
		this.prevRoom = prevRoom;
		this.nextRoomL = nextRoomL;
		this.nextRoomR = nextRoomR;
	}
	
	protected Room getCurrRoom() {
		return currRoom;
	}
	protected void setCurrRoom(Room currRoom) {
		this.currRoom = currRoom;
	}
	protected Room getPrevRoom() {
		return prevRoom;
	}
	protected void setPrevRoom(Room prevRoom) {
		this.prevRoom = prevRoom;
	}
	protected Room getNextRoomL() {
		return nextRoomL;
	}
	protected void setNextRoomL(Room nextRoomL) {
		this.nextRoomL = nextRoomL;
	}
	protected Room getNextRoomR() {
		return nextRoomR;
	}
	protected void setNextRoomR(Room nextRoomR) {
		this.nextRoomR = nextRoomR;
	}
}
