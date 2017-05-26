import edu.princeton.cs.introcs.StdDraw;

public class labyrinthe{
	public final static int taille = 32;
	static int hauteur = 17;
	static int largeur = 21;
	static int[][] carte = {{1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
			{ 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 1 },
			{ 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 3 , 1 , 3 , 1 },
			{ 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 1 },
			{ 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 },
			{ 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 },
			{ 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 },
			{ 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 },
			{ 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 },
			{ 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 },
			{ 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 },
			{ 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 },
			{ 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 },
			{ 1 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 },
			{ 1 , 3 , 1 , 3 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 , 2 , 1 },
			{ 1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 },
			{ 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 }};
	
	static Bombe carteB0[][] = new Bombe[21][17]; // matrice de bombes du joueur 0
	static Bombe carteB1[][] = new Bombe[21][17]; // matrice de bombes du joueur 1
	
	static int carteC[][] = new int[21][17]; // matrice de bonus
	
	static long carteD[][] = new long[21][17]; // matrice d'explosions
	
	
	public static void dessinermap(){
		
		for (int i=0;i<labyrinthe.hauteur;i++){
			for (int j=0;j<labyrinthe.largeur;j++){
				if (labyrinthe.carte[i][j] == 1){
					StdDraw.picture(taille*(j+0.5)+32,taille*(labyrinthe.hauteur - i - 0.5)+32,"unbreakable2.png");
				}
				if (labyrinthe.carte[i][j] == 2){
					StdDraw.picture(taille*(j+0.5)+32,taille*(labyrinthe.hauteur - i - 0.5)+32,"breakable2.png");
				}
				if (labyrinthe.carte[i][j] == 3){
					StdDraw.picture(taille*(j+0.5)+32,taille*(labyrinthe.hauteur - i - 0.5)+32,"free2.png");
				}
				if (labyrinthe.carte[i][j] == 4){
					StdDraw.picture(taille*(j+0.5)+32,taille*(labyrinthe.hauteur - i - 0.5)+32,"bombe.png");
				}
				if (labyrinthe.carte[i][j] == 5){
					StdDraw.picture(taille*(j+0.5)+32,taille*(labyrinthe.hauteur - i - 0.5)+32,"explosion.png");
				}
			}	
		}
	}
}


//1 = incassable
//2 = breakable
//3 = free
//4 = bombe
//5 = explosion