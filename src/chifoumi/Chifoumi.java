package chifoumi;
import java.util.HashMap;
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
		jeu(sc,Integer.parseInt(tour));
	}

	public static void jeu(Scanner sc, int tour) {
		HashMap <String,String> attaque = new HashMap< String, String >();

		attaque.put("L","S P");
		attaque.put("S","Sc P");
		attaque.put("Sc","L P");
		attaque.put("P","R L");
		attaque.put("R","Sc L");

		String[] moves = {"L","S","Sc","P","R"};
		
		/*on fait jouer le robot grace à la selection aléatoire d'un de mes 5 élèments
		 du tablleau de string moves[], qu'il faudra caster en int. La méthode random renvoie un 
		 random entre [0,1] donc on multiplie pas ranbge of index 4.
		 */
		int score_joueur = 0;
		int score_robot = 0; 

		for (int i = 0; i < tour; i++) {
			System.out.println("Quelle attaque ?");
			String joueur  = sc.next();
			String robot = moves[(int)(4 * Math.random())];
			if( attaque.get(joueur).contains(robot)) {
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
