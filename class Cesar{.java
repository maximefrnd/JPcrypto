class Cesar{

    public static void main(String[] args)
    {
        String m = "coucou";
        String c = "";
        int k = 1;

        for(int i = 0; i < m.length(); i++)
        {
          c = c + (char)(97+(m.charAt(i)+k-97)%26);
        }

        System.out.println(c);
    }

}