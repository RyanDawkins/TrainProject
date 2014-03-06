import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrainTest
{

    public static void main(String[] args)
    {

	if(lessThan())
	    System.out.println("lessthan() ran correctly");
	else
	    System.out.println("lessThan() ran incorrectly");

	if(greaterThan())
	    System.out.println("greaterThan() ran correctly");
	else
	    System.out.println("greaterThan() ran incorrectly");

    }

    public static boolean lessThan()
    {
	
	Train t1, t2;
	Calendar c1, c2;
       
	// Checks with equal everything
	c1 = new GregorianCalendar(2000, 1, 1, 1, 1);
	c2 = new GregorianCalendar(2000, 1, 1, 1, 1);
	t1 = new Train(true, c1, 1, "Equal");
	t2 = new Train(true, c2, 1, "Equal");
	if(t1.lessThan(t2)) return false;
	if(t2.lessThan(t2)) return false;

	// Checks with lesser calendar
	c2 = new GregorianCalendar(1999, 1, 1, 1, 1);
	t2 = new Train(true, c2, 1, "Equal");
	if(t1.lessThan(t2)) return false;
	if(!t2.lessThan(t1)) return false;

	// Checks with less train number
	c2 = new GregorianCalendar(2000, 1, 1, 1, 1);
	t2 = new Train(true, c2, 0, "Equal");
	if(t1.lessThan(t2)) return false;
	if(!t2.lessThan(t1)) return false;

	// Should return true because t2 has not arrived yet so t1 is greater
	t2 = new Train(false, c2, 1, "Equal");
	if(t1.lessThan(t2)) return false;
	if(!t2.lessThan(t1)) return false;

	System.out.println(t1);
	System.out.println(t2);
       
	return true;
    }


    public static boolean greaterThan()
    {
	
	Train t1, t2;
	Calendar c1, c2;
       
	// Checks with equal everything
	c1 = new GregorianCalendar(2000, 1, 1, 1, 1);
	c2 = new GregorianCalendar(2000, 1, 1, 1, 1);
	t1 = new Train(true, c1, 1, "Equal");
	t2 = new Train(true, c2, 1, "Equal");
	if(t1.greaterThan(t2)) return false;
	if(t2.greaterThan(t2)) return false;

	// Checks with t2 lesser calendar
	c2 = new GregorianCalendar(1999, 1, 1, 1, 1);
	t2 = new Train(true, c2, 1, "Equal");
	if(!t1.greaterThan(t2)) return false;
	if(t2.greaterThan(t1)) return false;

	// Checks with t2 less train number
	c2 = new GregorianCalendar(2000, 1, 1, 1, 1);
	t2 = new Train(true, c2, 0, "Equal");
	if(!t1.greaterThan(t2)) return false;
	if(t2.greaterThan(t1)) return false;

	// t1 arrived t2 hasnt
	t2 = new Train(false, c2, 1, "Equal");
	if(!t1.greaterThan(t2)) return false;
	if(t2.greaterThan(t1)) return false;
       
	return true;
    }

}
