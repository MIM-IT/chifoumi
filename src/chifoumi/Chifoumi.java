package chifoumi;
import java.util.Scanner;

public class Chifoumi {
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Combien de tour  ?");
		String tour = sc.next();
		System.out.println("Vous allez jouer " + tour + " tour(s).");
		
		String version = "";
			
		while( !(version.equalsIgnoreCase("1") || version.equalsIgnoreCase("2"))) {
			System.out.println("Deux versions {classique/spock}. 1 ou 2 ?");
			version = sc.next();
			
			if(  !(version.equalsIgnoreCase("1") || version.equalsIgnoreCase("2")) ) {
				// Si version n'est pas égal à 1 ou 2
				System.out.println("Ce n'est pas bon re essayez !");
			}
		}
	}

}
