import java.util.Random;

public class Bonus {
	
	
	
	public static void createBonus(int cordX, int cordY, personnage listePerso [], int numPerso){
		
		int nombreBonus = 10;
		
		
		Random rand = new Random();
		int typeBonus = rand.nextInt(nombreBonus)+1;
		
		labyrinthe.carteC[cordX][cordY] = typeBonus;
		
		
		if (typeBonus == 1){	// flamme bleue
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 2){	// flamme jaune
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 3){	// flamme rouge
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 4){	//  bombes rouges
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 5){	//  vie +1
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 6){	//  speed up
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 7){	//  speed down
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 8){	//  Bombe Plus
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 9){	//  Bombe Moins
			// Affichage visuel du bonus sur le plateau
		}
		else if (typeBonus == 10){	// flamme verte
			// Affichage visuel du bonus sur le plateau
		}

		
		
	}
	
		
	public static void checkBonus(personnage listePerso []){
		
		for (int i = 0; i<listePerso.length; i++){
			int cordXperso = listePerso[i].posX/32;
			int cordYperso = 16-listePerso[i].posY/32;
			for (int j=0; j<labyrinthe.hauteur; j++){
				for (int k=0; k<labyrinthe.largeur; k++){
					if (labyrinthe.carteC[k][j] != 0 && cordXperso ==k && cordYperso == j){
						Bonus.takeBonus(labyrinthe.carteC[k][j], listePerso, i);
						System.out.println("BONUS TAKEN de type "+labyrinthe.carteC[k][j]);
						labyrinthe.carteC[k][j] = 0;
						
					}
					
				}
			}
		}
	}
		
		
		
	public static void takeBonus(int typeBonus, personnage listePerso [], int numPerso){
		
		// flamme bleue
		if (typeBonus == 1){
			if (listePerso[numPerso].rayonExplosion > 1){ // Test si on a le droit de diminuer le rayon d'explosion
				listePerso[numPerso].rayonExplosion = listePerso[numPerso].rayonExplosion - 1;
			}
		}
		
		// flamme jaune
		if (typeBonus == 2){
			if (listePerso[numPerso].rayonExplosion < 10){ // Test si on a le droit d'augmenter le rayon d'explosion
				listePerso[numPerso].rayonExplosion++;
			}

		}
		
		// flamme rouge
		if (typeBonus == 3){
			listePerso[numPerso].rayonExplosion  = 10;
		}
		
		//  bombes rouges
		if (typeBonus == 4){
	//		listePerso[numPerso].typeBombe = 1; // bug
		}
		
		//  vie +1
		if (typeBonus == 5){
			listePerso[numPerso].vie++;
		}
		
		//  speed up
		if (typeBonus == 6){
			if(listePerso[numPerso].vitesse <32){
				listePerso[numPerso].vitesse = listePerso[numPerso].vitesse*2;
			}
		}
		
		//  speed down
		if (typeBonus == 7){
			if(listePerso[numPerso].vitesse > 8){
				listePerso[numPerso].vitesse = listePerso[numPerso].vitesse/2;
			}
		}
		
		//  Bombe Plus
		if (typeBonus == 8){
			if(listePerso[numPerso].bombesMax < 7){ // Test si on a le droit d'augmenter le nombre max de bombes
				listePerso[numPerso].bombesMax++;
			}
		}
		
		//  Bombe Moins
		if (typeBonus == 9){
			if(listePerso[numPerso].bombesMax >2){ // Test si on a le droit de diminuer le nombre max de bombes
				listePerso[numPerso].bombesMax = listePerso[numPerso].bombesMax -1;
			}
		}
		
		// flamme verte
		if (typeBonus == 10){
			if (listePerso[numPerso].rayonExplosion < 10){ // Test si on a le droit d'augmenter le rayon d'explosion
				listePerso[numPerso].rayonExplosion++;
			}
			if (listePerso[numPerso].timerExplosion > 3){ // Test si on a le droit de diminuer le temps d'explosion d'une bombe
				listePerso[numPerso].timerExplosion = listePerso[numPerso].timerExplosion -1;
			}
		}
	}
}
