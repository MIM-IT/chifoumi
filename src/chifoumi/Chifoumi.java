package chifoumi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;




public class Chifoumi {



	public static void main(String[] args) {
		List<String> moves = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		boolean end = false; //Lorsque true 'end' le jeu est finis 
		System.out.println("Combien de tour  ?");
		String tour = sc.next();
		System.out.println("Vous allez jouer " + tour + " tour(s).");

		String version = "";
		while( !end ) {
			System.out.println("Deux versions {classique/spock}. 1 ou 2 ?");
			System.out.println("Tapez end pour quitter : ");
			version = sc.next();
			
			switch(version) {
			case "1":
				System.out.println("allez jeu 1");
				break;
			case "2":
				jeu(sc,Integer.parseInt(tour),moves);
				break;
				
			case "end":
				end = true;
				break;
			default:
				System.out.println("Ce n'est pas bon re essayez !");
				break;
				
			}
			
		}
	
	}

	public static void jeu(Scanner sc, int tour,List<String> moves) {
		
		moves = Arrays.asList("rock","scissors","lizard","paper","spock");
		int score_joueur = 0;
		int score_robot = 0; 

		for (int i = 0; i < tour; i++) {
			System.out.println("Quelle attaque ?");
			String joueur  = sc.next();
			
			int index_player_gesture = moves.indexOf(joueur);
			int index_robot_gesture = (int)(4 * Math.random());
			
			String robot = moves.get(index_robot_gesture);
			System.out.println(robot);
			if(robot.equals(moves.get((index_player_gesture + 2) % 5)) || robot.equals(moves.get((index_player_gesture +1 ) % 5)) ) {
				System.out.println("Vous avez gagné la manche");
				score_joueur ++;

			}else if(joueur.equals(robot)){
				System.out.println("Egalité !");

			}else {
				System.out.println("Vous avez perdu la manche");
				score_robot ++;
			}
			
		}
		System.out.println("Votre score : "+ score_joueur + "\n" + "Score robot : " + score_robot);
	}


	}
