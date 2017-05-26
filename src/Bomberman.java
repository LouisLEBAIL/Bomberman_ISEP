import edu.princeton.cs.introcs.StdDraw;

public class Bomberman {

	public static void main(String[] args) throws InterruptedException {

		Decor.scenePrincipale();
		personnage listePerso [] =  {new personnage(0,624,496,32,37,38,39,40,96), new personnage(1,48,48,32,81,90,68,83,70)};
		
		Boolean bool = true;
		while (bool){
			bool = Decor.finJeu(listePerso);
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