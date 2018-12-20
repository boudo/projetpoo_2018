package fr.uvsq.uvsq21603700.rogueLike;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class SavedGame {
	public World world;

	public SavedGame(World world) {
		this.world = world;

	}
	
	public void SaveGame(String name) throws FileNotFoundException, UnsupportedEncodingException{
	
		String path = System.getProperty("user.home") + File.separator + ".savedRlGames" + File.separator + name;
		System.out.println("saved to: " + path);
//		File f = new File(path);
//		if(!f.getParentFile().isDirectory())
//			f.getParentFile().mkdirs();
//		if(f.exists()) {
//			throw new FileNotFoundException();
//		}
//		try {
//		f.createNewFile();
//		FileWriter fw = new FileWriter(f);
//		//PrintWriter writer = new PrintWriter(path, "UTF-8");
//		//writer.print(this.world.getLargeur()+" "+this.world.getHauteur()+"\n");
//		for(int i=0; i<this.world.getHauteur(); i++) {
//			for(int j=0; j<this.world.getLargeur(); j++) {
//				//writer.print(world.elemenTerrain(i, j).getSymbole()+" ");
//				fw.write(world.elemenTerrain(i, j).getSymbole()+" ");
//				System.out.println(world.elemenTerrain(i, j).getSymbole());
//			}
//			//writer.print("\n");
//			fw.write("\n");
//			System.out.println("\n");
//		}
//		//writer.close();
//		fw.close();
//		}catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		try {
		File fichier = new File(path);
		fichier.createNewFile();
		FileWriter fw = new FileWriter(fichier);
		
		fw.write(world.getLargeur()); fw.write(" "); fw.write(world.getHauteur()+"\n");
		List<Creature> lCreature = null;
		lCreature = world.getListCreature();
		for(int t=0; t<lCreature.size(); t++)
		{
			if(lCreature.get(t).getSymbole() == '@')
			{
				fw.write("P "+lCreature.get(t).description()+"\n");
			}
			else if(lCreature.get(t).getSymbole() == 'b')
			{
				fw.write("C "+lCreature.get(t).description()+"\n");
			}
			else if(lCreature.get(t).getSymbole() == 'f')
			{
				fw.write("C "+lCreature.get(t).description()+"\n");
			}
		}
		for(int y=0; y<world.getHauteur(); y++)
		{
			for(int x=0; x<world.getLargeur(); x++)
			{
				fw.write(world.elemenTerrain(x, y).getSymbole());
			}
			fw.write("\n");
		}
		fw.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
//		public void update(int centerX, int centerY) {
//		this.centerX = centerX;
//		this.centerY = centerY;
//	}
	
	public SavedGame loadGame(String path) throws IOException {
		Terrain[][] tiles = null;
		File file = new File(path);
		System.out.println("je vais importé le fichier sauvgarde");

		BufferedReader br = new BufferedReader(new FileReader(file));
		int width = 0, height = 0, cX = 0, cY = 0;
		String line;
			if((line = br.readLine())!=null) {
				String[] s = line.split(" ");
				width = Integer.parseInt(s[0]);
				height = Integer.parseInt(s[1]);
				System.out.println("taille matrice="+width+height);
			}
			tiles = new Terrain[width][height];
			if((line = br.readLine())!=null) {
				String[] s = line.split(" ");
				cX = Integer.parseInt(s[0]);
				cY = Integer.parseInt(s[1]);
			}
			
			for(int i=0; i<height; i++) {
		 System.out.println("je remplie la ligne "+i);// TODO Auto-generated catch block
				if((line = br.readLine())!=null) {
					String[] s = line.split(" ");
					for(int j=0; j<width; j++) {
						System.out.println("je remplie le tableau avec la colone "+j);

						char glyph = s[j].charAt(0);
						switch(glyph) {
						case '.': tiles[i][j] = Terrain.SOL; break;
						case '#': tiles[i][j] = Terrain.MUR; break;
						default:  tiles[i][j] = Terrain.VIDE;
						}
					}
				}
			}
		   System.out.println("J'ai tout fini");
           br.close();
		   return new SavedGame(new World(tiles));
	}
		

}
