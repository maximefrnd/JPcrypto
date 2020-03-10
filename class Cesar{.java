/*class Cesar{

    public static void main(String[] args)
    {
        String m = args[0];
        String c = "";
        //int k = Integer.parseInt(args[1]);
        char k = (char)(args[1].charAt(0)-96); // utilisation de lettre en cle

        for(int i = 0; i < m.length(); i++)
        {
          c = c + (char)(97+(m.charAt(i)+k-97)%26);
        }

        System.out.println(c);
    }*/

}
class CesarAnalyse{

    public static void main(String[] args)
    {
        String c = args[0];
        String m = "coucou";
        int [] f = new int[26];
        char k = 0;

        for(int i = 0; i < c.length(); i++)
        {
            f[c.charAt(i)-97]++;
        }

        int max=0
        for (int i = 0; i < f.length; i++ )
        {
            if (f[i]>f[max]) {
                max=i;
            }
        }

    }

}