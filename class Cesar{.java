class Cesar{

    public static void main(String[] args)
    {
        String m = "coucou";
        String c = "";
        int k = 1;

        for(int i = 0; i < m.lenght(); i++)
        {
            Systeme.out.println((char)(m.charAt(i)+k));
        }

        
    }

}