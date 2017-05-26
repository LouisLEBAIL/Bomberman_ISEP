import edu.princeton.cs.introcs.StdDraw;

public class personnage {
	int posX;
	int posY;
	int vie = 3;
	int bombesMax = 3;
	int bombesPosees = 0;
	int rayonExplosion = 3;
	int typeBombe = 0;
	int timerExplosion = 5;
	int vitesse = 32;
	
	int numPerso;
	
	int leftKey;							// q = 81 	  	// <- = 37
	int upKey;								// z = 90		// /\ = 38
	int rightKey; 							// d = 68		// -> = 39
	int downKey;							// s = 83		// \/ = 40
	int bombKey;							// f = 70		//  0 = 96
	
	
	public personnage(int numPerso,int posX, int posY, int vitesse, int leftKey, int upKey, int rightKey, int downKey, int bombKey){
		this.numPerso = numPerso;
		this.posX = posX;
		this.posY = posY;
		this.vitesse = vitesse;
		this.leftKey = leftKey;
		this.upKey = upKey;
		this.rightKey = rightKey; 
		this.downKey = downKey;
		this.bombKey = bombKey;
	}
	
	public void deplacement() throws InterruptedException{
		if ((StdDraw.isKeyPressed(leftKey) & labyrinthe.carte[16-(posY/32)][((posX+12)/32)-1] == 3) 
			|| (StdDraw.isKeyPressed(leftKey) & labyrinthe.carte[16-(posY/32)][(posX/32)-1] == 3)) {  //left
			if ((posY-16)%32 == 0){
				posX = posX-(vitesse/8);}
				else if ((16-1) < (posY-16)%32 & (posY-16)%32 < 32){
					posY = posY+(vitesse/8);}
				else if (0 < (posY-16)%32 & (posY-16)%32 < 16){
					posY = posY-(vitesse/8);}
		}
		if ((StdDraw.isKeyPressed(upKey) & labyrinthe.carte[(16-1)-((posY-13)/32)][(posX/32)] == 3)
			||(StdDraw.isKeyPressed(upKey) & labyrinthe.carte[(16-1)-(posY/32)][(posX/32)] == 3)){  //up
			if ((posX-16)%32 == 0){
				posY = posY+(vitesse/8);}
				else if ((16-1) < (posX-16)%32 & (posX-16)%32 < 32){
					posX = posX+(vitesse/8);}
				else if (0 < (posX-16)%32 & (posX-16)%32 < 16){
					posX = posX-(vitesse/8);}
		}
		if ((StdDraw.isKeyPressed(rightKey) & labyrinthe.carte[16-(posY/32)][((posX-13)/32)+1] == 3)
				||(StdDraw.isKeyPressed(rightKey) & labyrinthe.carte[16-(posY/32)][(posX/32)+1] == 3)){//right
			if ((posY-16)%32 == 0){
				posX = posX+(vitesse/8);}
				else if ((16-1) < (posY-16)%32 & (posY-16)%32 < 32){
					posY = posY+(vitesse/8);}
				else if (0 < (posY-16)%32 & (posY-16)%32 < 16){
					posY = posY-(vitesse/8);}
		}
		if ((StdDraw.isKeyPressed(downKey) & labyrinthe.carte[(16+1)-((posY+11)/32)][(posX/32)] == 3)
				||(StdDraw.isKeyPressed(downKey) & labyrinthe.carte[(16+1)-(posY/32)][(posX/32)] == 3)){//down
			if ((posX-16)%32 == 0){
				posY = posY-(vitesse/8);}
				else if ((16-1) < (posX-16)%32 & (posX-16)%32 < 32){
					posX = posX+(vitesse/8);}
				else if (0 < (posX-16)%32 & (posX-16)%32 < 16){
					posX = posX-(vitesse/8);}
		}
		
		
		
		
		//////////////////////////  A REFAIRE OU PAS /////////////////////////////
		// a integrer au paragraphe ci-dessus ou pas
		
		// Pour qu'un personnage puisse etre sur une case qui explose
		if ((StdDraw.isKeyPressed(leftKey) & labyrinthe.carte[16-(posY/32)][((posX+12)/32)-1] == 5) 
				|| (StdDraw.isKeyPressed(leftKey) & labyrinthe.carte[16-(posY/32)][(posX/32)-1] == 5)) {  //left
				if ((posY-16)%32 == 0){
					posX = posX-(vitesse/8);}
					else if ((16-1) < (posY-16)%32 & (posY-16)%32 < 32){
						posY = posY+(vitesse/8);}
					else if (0 < (posY-16)%32 & (posY-16)%32 < 16){
						posY = posY-(vitesse/8);}
			}
			if ((StdDraw.isKeyPressed(upKey) & labyrinthe.carte[(16-1)-((posY-13)/32)][(posX/32)] == 5)
				||(StdDraw.isKeyPressed(upKey) & labyrinthe.carte[(16-1)-(posY/32)][(posX/32)] == 5)){  //up
				if ((posX-16)%32 == 0){
					posY = posY+(vitesse/8);}
					else if ((16-1) < (posX-16)%32 & (posX-16)%32 < 32){
						posX = posX+(vitesse/8);}
					else if (0 < (posX-16)%32 & (posX-16)%32 < 16){
						posX = posX-(vitesse/8);}
			}
			if ((StdDraw.isKeyPressed(rightKey) & labyrinthe.carte[16-(posY/32)][((posX-13)/32)+1] == 5)
					||(StdDraw.isKeyPressed(rightKey) & labyrinthe.carte[16-(posY/32)][(posX/32)+1] == 5)){//right
				if ((posY-16)%32 == 0){
					posX = posX+(vitesse/8);}
					else if ((16-1) < (posY-16)%32 & (posY-16)%32 < 32){
						posY = posY+(vitesse/8);}
					else if (0 < (posY-16)%32 & (posY-16)%32 < 16){
						posY = posY-(vitesse/8);}
			}
			if ((StdDraw.isKeyPressed(downKey) & labyrinthe.carte[(16+1)-((posY+11)/32)][(posX/32)] == 5)
					||(StdDraw.isKeyPressed(downKey) & labyrinthe.carte[(16+1)-(posY/32)][(posX/32)] == 5)){//down
				if ((posX-16)%32 == 0){
					posY = posY-(vitesse/8);}
					else if ((16-1) < (posX-16)%32 & (posX-16)%32 < 32){
						posX = posX+(vitesse/8);}
					else if (0 < (posX-16)%32 & (posX-16)%32 < 16){
						posX = posX-(vitesse/8);}
			}
		
		
		StdDraw.picture((posX+32),(posY+32),"char.png");
		/*System.out.println((posX/32)+" + "+((16)-posY/32)+
				" actuel:"+labyrinthe.carte[16-(posY/32)][(posX/32)]+
				" up:"+labyrinthe.carte[(16-1)-(posY/32)][(posX/32)]+
				" left:"+labyrinthe.carte[16-(posY/32)][(posX/32)-1]+
				" down:"+labyrinthe.carte[(16+1)-(posY/32)][(posX/32)]+
				" right:"+labyrinthe.carte[16-(posY/32)][(posX/32)+1]);*/
		Thread.sleep(5);
		}
		
		
	
	public void action(personnage listePerso []){
		
		int cordX = posX/32;
		int cordY = 16-posY/32;
		
		if (listePerso[numPerso].bombesPosees<bombesMax){ // On check si le joueur n'as pas pose trop de bombes
			if (StdDraw.isKeyPressed(bombKey)){ // Si le joueur veux poser une bombe (ici il appuie sur le "0" du pave numerique)
				if (numPerso == 0){ // si c'est le joueur 0
					if ((labyrinthe.carte[cordY][cordX] == 3 || labyrinthe.carte[cordY][cordX] == 5) && labyrinthe.carteB0[cordX][cordY] == null){ // Si il n'y a pas de bombe sur cette case (surtout pour pas poser toutes les bombes en un click)
						
						listePerso[numPerso].bombesPosees++;
						System.out.println("Perso " + numPerso + ", bombes posées : " + bombesPosees);
						
						
						labyrinthe.carte[cordY][cordX] = 4; // On dessine la bombe sur le terrain
						
						labyrinthe.carteB0[cordX][cordY] = new Bombe(posX,posY,rayonExplosion,typeBombe,System.currentTimeMillis() + timerExplosion * 1000); // On instancie la bombe
						
					}
				}
				else{ // donc c'est le joueur 1
					if ((labyrinthe.carte[cordY][cordX] == 3 || labyrinthe.carte[cordY][cordX] == 5) && labyrinthe.carteB1[cordX][cordY] == null){// Si il n'y a pas de bombe sur cette case (surtout pour pas poser toutes les bombes en un click)
						
						listePerso[numPerso].bombesPosees++;
						System.out.println("Perso " + numPerso + ", bombes posées : " + bombesPosees);
						
						
						labyrinthe.carte[cordY][cordX] = 4; // On dessine la bombe sur le terrain
						
						labyrinthe.carteB1[cordX][cordY] = new Bombe(posX,posY,rayonExplosion,typeBombe,System.currentTimeMillis() + timerExplosion * 1000); // On instancie la bombe
						
					}
				}
			}
		}
	}
}