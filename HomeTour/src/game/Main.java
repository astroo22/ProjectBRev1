package game;
import java.util.*;
import fixtures.Room;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//switch boring fun
			//use maps?
		System.out.println("Welcome to the Trainwreck!");
		Scanner scan = new Scanner(System.in);
		RoomManager rm = new RoomManager();
		rm.init();
		String input = "";
		do {
			System.out.println("Where would you like to go?");
			input = scan.nextLine();
			if(input != null && rm.checkExit(input)) {
				rm.movePlayer(input);
			}
			else { 
				rm.checkOther(input);
			}

		}while(!input.equals("quit"));	
	}
	/*
	private static void printRoom(Player player) {

	}

	private static String[] collectInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("catchy text to get input");
		String input = scan.nextLine();
		String[] str = input.split(" ");
		return str;
	}
		
	private static void parse(String[] command, Player player) {

	}
	*/

}
