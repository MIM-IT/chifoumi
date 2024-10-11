package chifoumi;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Chifoumi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean end = false;

		System.out.println("Bonjour et bienvenue sur le jeu du chifoumi !\n");

		//Lorsque true 'end' le jeu est finis 
		while( !end ) {
			System.out.println("Choisissez une option :");
			System.out.println("1 - Jouer");
			System.out.println("2 - Lire les Règles");
			System.out.println("3 - Quitter");
			String option = sc.next();
			
			switch(option) {
				case "1":
					play(sc);
					break;
				case "2":
					rules(sc);
					break;
				case "3":
					end = true;
					break;
				default:
					System.out.println("Ce n'est pas bon re essayez !\n");
					break;
			}
		}
	}
	
	private static void play(Scanner sc) {
		System.out.println("Choisissez une version");
		System.out.println("1 - Classique");
		System.out.println("2 - Bigbang theory");
		System.out.println("3 - Custom");
		System.out.println("4 - Retour");
		String version = sc.next();
		
		switch(version) {
			case "1":
				game(sc, Arrays.asList("rock","scissors","paper"));
				break;
			case "2":
				game(sc, Arrays.asList("rock","scissors","lizard","paper","spock"));
				break;
			case "3":
				game(sc, Arrays.asList("rock","fire","scissors","sponge","paper","air","water"));
				break;
			case "4":
				break;
			default:
				System.out.println("Ce n'est pas bon re essayez !\n");
				break;
		}
	}
	
	private static void rules(Scanner sc) {
		System.out.println("Choisissez une version");
		System.out.println("1 - Classique");
		System.out.println("2 - Bigbang theory");
		System.out.println("3 - Custom");
		System.out.println("4 - Retour");
		String version = sc.next();
		
		switch(version) {
			case "1":
				System.out.println("Règles du jeu classique :\n");
				System.out.println("La pierre émousse les ciseaux");
				System.out.println("Les ciseaux coupe la feuille");
				System.out.println("La feuille enveloppe la pierre\n");
				rules(sc);
				break;
			case "2":
				System.out.println("Règles du jeu de the bigbang theory :\n");
				System.out.println("La pierre casse les ciseaux et écrase le lézard");
				System.out.println("Les ciseaux décapitent le lézard et coupent la feuille");
				System.out.println("Le lézard mange la feuille et empoisonne Spock");
				System.out.println("La feuille désapprouve Spock et recouvre la pierre");
				System.out.println("Spock vaporise la pierre et écrabouille les ciseaux\n");
				rules(sc);
				break;
			case "3":
				System.out.println("Règles du jeu personnalisé :\n");
				System.out.println("La pierre éteint le feu, écrase les ciseaux et l'éponge");
				System.out.println("Le feu fait fondre les ciseaux, brûle l'éponge et le papier");
				System.out.println("Les ciseaux coupent l'éponge, le papier et son claquement résonne dans l'air");
				System.out.println("L'éponge mouille le papier, contient des trous d'air et absorbe l'eau");
				System.out.println("Le papier évente l'air, flotte sur l'eau et recouvre la pierre");
				System.out.println("L'air évapore l'eau, érode la pierre et éteint le feu");
				System.out.println("L'eau érode la pierre, éteint le feu et rouille les ciseaux\n");
				rules(sc);
				break;
			case "4":
				break;
			default:
				System.out.println("Ce n'est pas bon re essayez !\n");
				rules(sc);
				break;
		}
	}

	public static void game(Scanner sc, List<String> moves) {
		int player_score = 0;
		int robot_score = 0;
		
		System.out.println("Combien de tour voulez vous jouer ?");
		String tour = sc.next();
		
		while(!tour.matches("^-?\\d+$")) // si ce n'est pas un nombre
		{
		   System.out.println("La saisie n'est pas un chiffre/nombre");
		   tour = sc.next();
		}

		for (int i = 0; i < Integer.parseInt(tour); i++) {
			System.out.println("Choisissez une attaque " + moves + " :");
			String player_move  = sc.next();
			
			int player_move_index = moves.indexOf(player_move);
			int robot_move_index = (int) Math.round((moves.size() - 1) * Math.random());
			
			String robot_move = moves.get(robot_move_index);
			System.out.println(robot_move);
			
			if(player_move.equals(robot_move)){
				System.out.println("Égalité !");
				continue;
			}
			
			boolean win = false;
			
			for(int j = 1; j <= (int) (moves.size() / 2); j++) {
				if(robot_move.equals(moves.get((player_move_index + j) % 5))) {
					win = true;
					break;
				}
				
			}
			
			if(win) {
				System.out.println("Vous avez gagné la manche");
				player_score ++;
			} else {
				System.out.println("Vous avez perdu la manche");
				robot_score ++;
			}
		}
		
		System.out.println("Score : (vous) "+ player_score + " - " + robot_score + " (robot)\n");
	}
}
