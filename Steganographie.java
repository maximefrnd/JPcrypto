import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Steganographie {
	public static void main(String []args) throws IOException{
		
		//////////////////////////////////////////////////
		// REVIEW

		char c = 'a'; // 'a' # 97 # 0110 0001

		System.out.println("la lettre '"+ c + "' a pour code asci '" 
				+ (int) c + "' en décimale (base 10) '" 
				+ Integer.toBinaryString(c) + "' en binaire (base 2),\n"
				+ "son bit de poids fort vaut '" + (c & 0b10000000) + "' en décimale et '" + Integer.toBinaryString(c & 0b10000000) + "' en binaire,\n"
				+ "son bit de poids faible vaut '"+(c & 0b00000001) + "' en décimale et '" + Integer.toBinaryString(c & 0b00000001) + "' en binaire et\n"
				+ "son bit de poids faible décallé à gauche vaut '" + ((c & 0b00000001) << 7) + "' en décimale et '" + Integer.toBinaryString((c & 0b00000001) << 7) + "' en binaire.");

		// Pour chaque bit de c
		System.out.println("Voici une boucle qui permet d'acceder individuellement à la valeur de chaque bit de la lettre '"+ c + "':"); 
		for (int i = 0; i < 8; ++i)
		{
			int b = (c >> i) & 1; // Explications:
			// "c >> i" cette opréation bianire décalle les 8 bits vers la droite afin de placer le bit dont on veut savoir l'état à la position du bit de poids faible 
			// (remarque: la valeur des bits les plus à droite disparait)
			// (ex:  on veut savoir l'état du 3ème bit de poids fort et on pose c = 'a' # 97 # 0110 0001 alors on effectura l'opération c >> 5 afin d'obtenir 0000 0011)
			// "(c >> i) & 1" c'est une opération binaire (un ET logique) entre le nombre binaire résultat de l'opération précédente "c >> i" et la valeur 1
			// (ex: 0000 0011 & 0000 00001 = 1 est bien, dans notre exemple, la valeur du troisième bit)
			System.out.println(c+"["+i+"]="+b);
		}
		 
		//////////////////////////////////////////////////
		// READING

		BufferedReader br = new BufferedReader(new FileReader("in.pgm"));

		String magic = br.readLine();    	// first line contains P2 or P5
		if ( ! "P2".equals(magic) ) {  		// no ASCII format ?
			System.err.println("Format incompatible");
			return;
		}

		String line = br.readLine();		// second line contains height and width
		while (line.startsWith("#")) {
			line = br.readLine();
		}
		Scanner sc = new Scanner(line);
		int width = sc.nextInt();
		int height = sc.nextInt();

		line = br.readLine();				 	// third line contains maxVal
		sc = new Scanner(line);
		int maxVal = sc.nextInt();

		int[][] im = new int[height][width];	// following lines contain pixel values
		int count=0;
		c=0;
		String clair="";
		
		while ((line = br.readLine()) != null){
			sc = new Scanner(line);
			while (sc.hasNext()){
				im[count / width][count % width] = sc.nextInt(); // reading pixel value
				
				// DECODING

				
				count++;
		
			}
		}

		System.out.println("width="+width+" height="+height + " maxVal="+maxVal);
		System.out.println("pixel required (width * height)="+width*height+" pixel read (count)="+count);
		System.out.println("Message décodé="+clair);

		//////////////////////////////////////////////////
		// WRITING

		PrintStream ps = new PrintStream(new FileOutputStream("out.pgm"));

		ps.println(magic); // first line contains P2 or P5
		ps.println(width+" "+height); // second line contains height and width
		ps.println(maxVal); // third line contains maxVal

		clair = "mon texte en clair qui sera encode dans l'image";
		
		int nb=0;
		String ss;
		while(nb<count){

			// CODING ;)
			
			
			ps.print(im[nb / width][nb % width] + " ");
			
			if((nb % width)==0 && nb !=0)
				ps.println();
			
			nb++;
		}
		ps.close();
		

	}
}