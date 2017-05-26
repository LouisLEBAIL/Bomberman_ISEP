import edu.princeton.cs.introcs.StdDraw;

public class Decor {

	
	public static void scenePrincipale(){
		StdDraw.setCanvasSize(1200, 700);
		StdDraw.setXscale(0,1200);
		StdDraw.setYscale(0,700);
		StdDraw.picture(600,350,"Scene_Principale.png");
		labyrinthe.dessinermap();
	}
	
	
	
	public static Boolean finJeu(personnage listePerso []){
		
		for (int i = 0; i < listePerso.length; i++){
			if (listePerso[i].vie <= 0){
				System.out.println("Le joueur "+i+" a perdu.");
				return false;
			}
		}
		return true;
	}
}
