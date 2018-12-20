package fr.uvsq.uvsq21603700.rogueLike;

/**
 * Classe qui va construire le terrain avec le sol et mur
 * 
 *
 */
public class WorldBuilder{
	
	private Terrain[][] _terrain;
    private int _largeur;
    private int _hauteur;
    /**
     * Le constructeur
     * @param largeur
     * @param hauteur
     */
	public WorldBuilder(int largeur, int hauteur) {
		_largeur = largeur;
		_hauteur = hauteur;
		_terrain = new Terrain[largeur][hauteur];
	}
	/**
	 * 
	 * @return l'univers de jeu 
	 */
	public World construire() {
		//randomTerrain();
		return new World(_terrain);
	}
	/**
	 * 
	 * @return l'univers de jeu avec des elements du terrain positionnes aleatoirement
	 */
	private WorldBuilder randomTerrain() {
		for (int x = 0; x < _largeur; x++) {
			for (int y = 0; y < _hauteur; y++) {
				_terrain[x][y] = Math.random() < 0.5 ? Terrain.SOL : Terrain.MUR;
			}
		}
		return this;
	}
	/**
	 * construire le mur et le sol
	 * @param times
	 * 
	 */
	private WorldBuilder lissage(int times) {
        Terrain[][] terrain = new Terrain[_largeur][_hauteur];
        for (int time = 0; time < times; time++) {

         for (int x = 0; x < _largeur; x++) {
             for (int y = 0; y < _hauteur; y++) {
              int sol = 0;
              int mur = 0;

              for (int ox = -1; ox < 4; ox++) {
                  for (int oy = -1; oy < 4; oy++) {
                   if (x + ox < 0 || x + ox >= _largeur || y + oy < 0
                        || y + oy >= _hauteur)
                       continue;

                   if (_terrain[x + ox][y + oy] == Terrain.SOL)
                       sol++;
                   else
                       mur++;
                  }
              }
              terrain[x][y] = sol >= mur ? Terrain.SOL : Terrain.MUR;
             }
         }
         _terrain = terrain;
        }
        return this;
    }

	public WorldBuilder construireTerrain() {
		return randomTerrain()
				.lissage(8);
	}
//	//Bruit de Perlin
//	
//	//Fonction pour interpoler linéairement entre a0 et a1
//	// Le poids w doit être compris dans l'intervalle [0.0, 1.0]
//	public double lerp(double a0, double a1, double w)
//	{
//	     return (1.0 - w)*a0 + w*a1;
//	}
//	
//
//	// Calcule le produit scalaire des vecteurs distance et gradient.
//	public dotGridGradient(int ix, int iy, double x, double y)
//	{
//		 
//	     // Vecteurs de gradient précalculés (ou autrement) à chaque nœud de la grille
//	     //extern float Gradient[IYMAX][IXMAX][2];
//	 
//	     // Calculer le vecteur de distance
//	     double dx = x - (double)ix;
//	     double dy = y - (double)iy;
//	 
//	     // Compute the dot-product
//	     return (dx*Gradient[iy][ix][0] + dy*Gradient[iy][ix][1]);
//	}
//	 // Compute Perlin noise at coordinates x, y
//	 function perlin(float x, float y) {
//	 
//	     // Determine grid cell coordinates
//	     int x0 = floor(x);
//	     int x1 = x0 + 1;
//	     int y0 = floor(y);
//	     int y1 = y0 + 1;
//	 
//	     // Determine interpolation weights
//	     // Could also use higher order polynomial/s-curve here
//	     float sx = x - (float)x0;
//	     float sy = y - (float)y0;
//	 
//	     // Interpolate between grid point gradients
//	     float n0, n1, ix0, ix1, value;
//	     n0 = dotGridGradient(x0, y0, x, y);
//	     n1 = dotGridGradient(x1, y0, x, y);
//	     ix0 = lerp(n0, n1, sx);
//	     n0 = dotGridGradient(x0, y1, x, y);
//	     n1 = dotGridGradient(x1, y1, x, y);
//	     ix1 = lerp(n0, n1, sx);
//	     value = lerp(ix0, ix1, sy);
//	 
//	     return value;
//	 }
		
	
}
