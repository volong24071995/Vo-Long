import java.util.*;

public class Test {
    public	static	void	main(String[]	args)	{
//        Set<String> myset	=new HashSet<String>();
//        myset.add("London");
//        myset.add("Paris");
//        myset.add("New York");
//        myset.add("San Francisco");
//        myset.add("Beijing");
//        myset.add("New York");
//        System.out.println(myset);
//        List<String> listString = new ArrayList<>(myset);
//        Collections.sort(listString);
//        for	(String	s:listString)	{
//            System.out.print(s.toUpperCase()	+	"	");
//        }
        LinkedList<String> list=new LinkedList();
        list.add("car");
        list.add("hondar");
        list.add("sedan");
        list.add("city");
//        for	(String	s:list)	{
//            System.out.print(s.toUpperCase()	+	"	");
//        }
        List<String> newlist=new ArrayList<>(list);
        for	(String	s:newlist)	{
            System.out.print(s.toUpperCase()	+	"	");
        }


    }
}

