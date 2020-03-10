using System;

namespace Crypto
{
    class Program
    {

        static void Main( string[] args)
        {
            bool showMenu = true;
            while (showMenu)
            {
                showMenu = mainMenu();
            }
        }

        static bool mainMenu()
        {
            Console.WriteLine("------------------\n");
            Console.WriteLine("\n\n");
            Console.WriteLine("Choisissez un programme à lancer: \n");
            Console.WriteLine("------------------\n");
            Console.WriteLine("1) CesarEncrypte");
            Console.WriteLine("2) CesarDecrypte");
            Console.WriteLine("3) Quitter");
            Console.Write("\r\nSelectionnez une option: ");

            switch (Console.ReadLine())
            {
                case "1" : 
                    cesar();
                    return true; 
                case "2" :
                    cesarFreq();
                    return true;
                case "3" :
                    return false;
                default:
                    return true;
            }

        }

        public static void cesar ()
        {

            Console.WriteLine("\n");

            Console.WriteLine("Entrez votre phrase : ");
            string m = Console.ReadLine();

            Console.WriteLine("\n");

            Console.WriteLine("Entrez votre clé : ");
            int k = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("\n");

            string c = encryptage(m,k);
            Console.WriteLine("Code : "+c);

            Console.WriteLine("\n");
            Console.WriteLine("----------");

        }

        public static char cryptage(char ch, int k)
        {
            if (!char.IsLetter(ch))
            {
                return ch;
            }
               
            return (char)(97+(ch+k-97)%26); 
            
        }

        public static string encryptage(string entree, int k)
        {

            string sortie = string.Empty;

            foreach (char ch in entree)
            {
                sortie += cryptage(ch,k);
            }

            return sortie;
        }

        public static void cesarFreq ()
        {
            Console.WriteLine("\n Entrez le message a decoder : ");
            string c = Console.ReadLine();

            int cleRelative = freq(c);
            
            int cle = rela(cleRelative);

            string m = encryptage(c, cle); 

            Console.WriteLine("\n le message est : "+m);

        }

        public static int freq(string c)
        {
            int k = 0;
            int[] f = new int[26];
            char[] ch = c.ToCharArray();

            for (int i = 0; i < c.Length; i++)
            {
                f[ch[i]-97]++;
            }

            for (int i = 0; i < f.Length; i++)
            {
                if(f[i]>f[k])
                {
                    k = i;
                }
            }

            return k;
        }

        public static int rela(int k)
        {
            int k2 = 0;

            k2 = (k-5)+101;

            return k2;
        }



    }
}
