package DSA.String;
import java.util.*;
public class strikingelem {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter data");
        String data=sc.next();
        char res=strike(data);
        System.out.println(res);
    }
    static char strike(String data)
    {
        HashMap<Character , Integer> map=new HashMap<>();
        int n=data.length();
        char res='\0';
        for(int i=0;i<n;i++)
        {
            char ch=data.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)==2)
            {
              res=ch;
            }
           
        }
        return res;
    }
}
