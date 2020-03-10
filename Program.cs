﻿using System;

namespace Crypto
{
    class Program
    {
        
        public static char cryptage(char ch, int cle)
        {
           if (!char.IsLetter(ch))
            {
                return ch;
            }

            char d = char.IsUpper(ch) ? 'A' : 'a';
            return (char)((((ch+cle)-d)%26)+d);
        }

        public static string encryptage( string entree, int cle)
        {
            string sortie = string.Empty;

            foreach (char ch in entree)
            sortie += cryptage(ch,cle);

            return sortie;
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Entrez votre phrase");
            string PhraseUser = Console.ReadLine();

            Console.WriteLine("\n");

            Console.WriteLine("Entrez votre cle");
            int cle = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("\n");

            Console.WriteLine("Encryptage");
            System.Threading.Thread.Sleep(500);
            Console.WriteLine(".");
            System.Threading.Thread.Sleep(500);
            Console.WriteLine(".");
            System.Threading.Thread.Sleep(500);
            Console.WriteLine(".");
            System.Threading.Thread.Sleep(1000);

            Console.WriteLine("\n");

            Console.WriteLine("Donnees encryptees : ");
            string textEncrypte = encryptage(PhraseUser,cle);
            Console.WriteLine(textEncrypte);

            Console.WriteLine("\n");


        }
    }
}
