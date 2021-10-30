class Remorca{
    
    private int cantitate;
    private String inmatriculare;
    private static int ultim=10;
    
    public Remorca(int c, String s1)
    {
        cantitate=c;
        inmatriculare=s1;
        ultim=cantitate;
    }
    
    public Remorca(String s2)
    {
        inmatriculare=s2;
        cantitate=1+ultim;
        ultim++;
    }
    public String toString()
    {
        return "->R("+inmatriculare+", "+cantitate+")";
    }
    public int nrcutii()
    {
        return cantitate;
    }
    public String inmatriculare()
    {
        return inmatriculare;
    }
    
}
class Tir{
    private Remorca[] r = new Remorca[5];
    private int k=0;
    public boolean adaugaRemorca(int c1, String s1)
    {
        if(k<5)
        {
            Remorca r1= new Remorca(c1,s1);
            r[k]=r1;
            k++;
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean adaugaRemorca( Remorca re)
    {
        if(k<5)
        {
            r[k]=re;
            k++;
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public Remorca stergeRemorca(String s2)
    {
        int check=k;
        Remorca rem=null;
        for(int i=0;i<k;i++)
            {
                rem = r[i];
                if(r[i].inmatriculare()==s2)
                {
                    for(int j=i+1;j<k;j++)
                        {
                            r[j-1]=r[j];
                        }
                    k--;
                    break;
                }
            }
        if(check!=k)
            return rem;
        else 
            return null;
    }
    
    public boolean equals(Object o)
    {
        if(!(o instanceof Tir))
            return false;
        Tir t= (Tir)o;
            int s1=0;
            int s2=0;
            for(int i=0;i<k;i++)
                s1 += r[i].nrcutii();
            for(int j=0;j<t.k;j++)
                s2+=t.r[j].nrcutii();
            if(s1==s2)
                return true;
            return false;
    }
    public String toString()
    {
        String s3="T";
        for(int i=0;i<k;i++)
            s3+=r[i].toString();
        return s3;
    }
}
public class CreareTir{
    public static void main(String[] args)
    {
        Remorca remo = new Remorca(5,"abc");
        Remorca remo1 = new Remorca(6,"def");
        Tir tt=new Tir();
        tt.adaugaRemorca(remo);
        tt.adaugaRemorca(remo1);
        Tir tt1= new Tir();
        tt1.adaugaRemorca(4,"ghi");
        tt1.adaugaRemorca(3,"jkl");
        tt1.adaugaRemorca(2,"mno");
        System.out.println(tt1.toString());
    }
}