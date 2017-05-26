import java.util.Random;

public class Bombe {

	// Localisation de la bombe
	private int xBombe;
	private int yBombe;
	
	
	
	// Caracteristiques de la bombe
	long timerExplosion ;       											// Temps entre le posage et l'explosion de la bombe
	static long finExplosion;												// sert a voir la bombe exploser
	int rayonExplosion;     												// Rayon d'explosion de la bombe
	int typeBombe;															// 0:Bombe Normale 		// 1: Bombe Rouge
	
	
	public Bombe(int xBombe, int yBombe, int rayonExplosion, int typeBombe, long timerExplosion){
		this.xBombe = xBombe;
		this.yBombe = yBombe;
		this.rayonExplosion = rayonExplosion;
		this.typeBombe = typeBombe;
		this.timerExplosion = timerExplosion;
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////  EXPLOSION BOMBE  ///////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////	
	
	
	public static void explosion(Bombe Bombe, personnage listePerso [], int numPerso){	// Gestion de l'explosion d'une bombe
		
	
		// Coordonees de la bombe dans les matrices
		int cordX = Bombe.xBombe/32;
		int cordY = 16 - Bombe.yBombe/32;
		
		
		
		
		
		///////////////////////////////  CASE CENTRALE  /////////////////////////////
		
		animExplosion(cordX,cordY);											// Animation d'explosion
		for (int k=0; k<listePerso.length; k++){							// On enleve une vie si un perso est au dessus d'une case qui explose
			if ((listePerso[k].posX)/32 == cordX && 16-(listePerso[k].posY)/32 == cordY){
				listePerso[k].vie = listePerso[k].vie - 1;
			}
		}

		
		
		
		
		
		
		///////////////////////////////  CASES AU DESSUS  /////////////////////////////
		
		for (int j=1; j<5; j++){
			
				cordX = Bombe.xBombe/32;
				cordY = 16 - Bombe.yBombe/32;
				
			for (int i=0; i<Bombe.rayonExplosion; i++){
				
				
				if (j==1) {cordY = cordY - 1;}								//haut							
				if (j==2) {cordY = cordY + 1;}								//bas
				if (j==3) {cordX = cordX - 1;}								//gauche
				if (j==4) {cordX = cordX + 1;}								//droite
				
				if (labyrinthe.carte[cordY][cordX] == 1){ 					// Si on tombe sur une case incassable, on arrete de check dans cette direction
					if (Bombe.typeBombe == 0){ 								// Si la bombe est normale, l explosion s arrete
						i = Bombe.rayonExplosion; 							// On sort ainsi de la boucle for car il n'y a plus a checker de case au dessus
					}
				}
				
				
		
				else if (labyrinthe.carte[cordY][cordX] == 2){ 				// Si on tombe sur une case cassable...
					animExplosion(cordX,cordY);								// ... on la casse
					
					if (Bombe.typeBombe == 0){ 								// Si la bombe est normale, l explosion s arrete 
						i = Bombe.rayonExplosion; 							// On sort ainsi de la boucle for car si on casse une case, l'explosion ne va pas plus loin
					}
									
					// BONUS	
					Random rand = new Random();
					int chanceBonus = rand.nextInt(5);						// 1 chance sur 5 de faire pop un bonus
					if (chanceBonus == 0){
						Bonus.createBonus(cordX,cordY,listePerso,numPerso);
					}
				}			
				
				
				
				else if (labyrinthe.carte[cordY][cordX] == 3){				// Un joueur ne peut etre que sur une case free
					animExplosion(cordX,cordY);								// Animation
					for (int k=0; k<listePerso.length; k++){				// On enleve une vie si un perso est au dessus d'une case qui explose
						if ((listePerso[k].posX)/32 == cordX && 16-(listePerso[k].posY)/32 == cordY){
							listePerso[k].vie = listePerso[k].vie - 1;
						}
					}
				}
				
				
				
				else if (labyrinthe.carte[cordY][cordX] == 4){				// On fait exploser une bombe si elle se trouve sur cette case
					animExplosion(cordX,cordY);								// Animation
					
					if (labyrinthe.carteB0[cordX][cordY] != null){
						Bombe.explosion(labyrinthe.carteB0[cordX][cordY],listePerso,numPerso);
					}
					else if (labyrinthe.carteB1[cordX][cordY] != null){
						Bombe.explosion(labyrinthe.carteB1[cordX][cordY],listePerso,numPerso);
					}
				}
			}
		}
		
		
		
		
		
		// Apres l explosion de la bombe, on doit l'enlever de la liste de bombe, pour que le joueur puisse reposer des bombes :
		if (labyrinthe.carteB0[Bombe.xBombe/32][16 - Bombe.yBombe/32] != null){
			labyrinthe.carteB0[Bombe.xBombe/32][16 - Bombe.yBombe/32] = null;		
		}
		else if (labyrinthe.carteB1[Bombe.xBombe/32][16 - Bombe.yBombe/32] != null){
			labyrinthe.carteB1[Bombe.xBombe/32][16 - Bombe.yBombe/32] = null;		
		}
		listePerso[numPerso].bombesPosees = listePerso[numPerso].bombesPosees - 1;
		System.out.println("Perso " + numPerso + ", bombes posées : " + listePerso[numPerso].bombesPosees);
	}
	
	
	
	// Methode d'affichgage de l'annimation d'explosion
	public static void animExplosion(int cordX, int cordY){					// ATTENTION cordonnees de la matrice, PAS EN PIXEL
		labyrinthe.carte[cordY][cordX] = 5;  								// Animation d'explosion
		finExplosion = System.currentTimeMillis() + 500;					// Durée de l'animation d'explosion : 500 ms
		labyrinthe.carteD[cordX][cordY] = finExplosion;
	}
	
	
	public static void explosionBombes(personnage listePerso []){
		for (int i=0;i<labyrinthe.hauteur;i++){
			for (int j=0;j<labyrinthe.largeur;j++){
				if (labyrinthe.carteB0[j][i] != null){ 						// pour joueur 0					
					if(System.currentTimeMillis() > labyrinthe.carteB0[j][i].timerExplosion){
						Bombe.explosion(labyrinthe.carteB0[j][i], listePerso, 0);	// On fait exploser la bombe
					}
				}
				else if (labyrinthe.carteB1[j][i] != null){		 			// pour joueur 1			
					if(System.currentTimeMillis() > labyrinthe.carteB1[j][i].timerExplosion){
						Bombe.explosion(labyrinthe.carteB1[j][i], listePerso, 1);	// On fait exploser la bombe
					}
				}
				if (labyrinthe.carteD[j][i] != 0){	
					if(System.currentTimeMillis() > labyrinthe.carteD[j][i]){
						labyrinthe.carte[i][j] = 3;					// l'animation d'explosion prend fin
						labyrinthe.carteD[j][i]=0;
					}
				}
			}
		}
	}

	
	
}
