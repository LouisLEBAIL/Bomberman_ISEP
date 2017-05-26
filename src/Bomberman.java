import edu.princeton.cs.introcs.StdDraw;

public class Bomberman {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int taille = 32;
		StdDraw.setCanvasSize(taille*(21+8), taille*17);
		StdDraw.setXscale(0,taille*(21+8));
		StdDraw.setYscale(0,taille*17);
		//StdDraw.clear(StdDraw.GRAY);
		personnage listePerso [] =  {new personnage(0,624,496,32,37,38,39,40,96), new personnage(1,48,48,32,81,90,68,83,70)};
		labyrinthe.dessinermap();
		
		Boolean bool = true;
		while (bool){
			bool = labyrinthe.finJeu(listePerso);
			StdDraw.enableDoubleBuffering();
			labyrinthe.dessinermap();
			listePerso[0].deplacement();
			listePerso[0].action(listePerso);
			Bombe.explosionBombes(listePerso);
			
			listePerso[1].deplacement();
			listePerso[1].action(listePerso);
			Bombe.explosionBombes(listePerso);
			
			Bonus.checkBonus(listePerso);

			StdDraw.show();
		//	StdDraw.clear(StdDraw.GRAY);
			
		}

	}

}