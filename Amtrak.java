import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Amtrak
{

    public static void main(String[] args)
    {
	if(args.length != 1)
	    {
		System.out.println("Incorrect arguments");
		return;
	    }
	String fileName = args[0];
	File f = new File(fileName);
	if(!f.exists() || f.isDirectory())
	    {
		System.out.println("Bad file");
		return;
	    }

	BufferedReader reader = null;
	try{ reader = new BufferedReader(new FileReader(fileName)); }
	catch(Exception e){ System.out.println("File not found");return;}
	LinkedList list = new LinkedList();
	String line = null;
	try{
	    while((line = reader.readLine()) != null)
		{
		    String[] tokens = line.split("\\s+");
		    if(tokens[0].toLowerCase().equals("cancel"))
		       {
			   Train t = list.delete(Integer.parseInt(tokens[1]));
			   System.out.print("*** Train "+tokens[1]+" ");
			   if(t != null)
			       {
				   System.out.println(" canceled");
			       }
			   else
			       {
				   System.out.println(" not found; cannot be canceled");
			       }
		       }
		    else if(tokens.length > 6)
			{
			    list.add(parse(tokens));
			}
		}
	} catch(Exception e)
	    {
		System.out.println("File couldn't be read");
		e.printStackTrace();
		return;
	    }
	
	Train t = list.first();
	boolean departures = false;
	boolean arrival = false;
	System.out.println();
	while((t = list.next()) != null)
	    {
		if(t.hasArrived() && !arrival)
		    {
			arrival = true;
			System.out.println("ARRIVAL\n");
			printHeader();
		    }
		else if(!t.hasArrived() && !departures)
		    {
			departures = true;
			System.out.println("\nDEPARTURES\n");
			printHeader();
		    }
		System.out.println(t.toString());
	    }

    }

    public static Train parse(String[] tokens)
    {
	boolean hasArrived = false;
	if(tokens[0].toLowerCase().equals("departure"))
	    {
		hasArrived = false;
	    }
	else if(tokens[0].toLowerCase().equals("arrival"))
	    {
		hasArrived = true;
	    }
	else
	    {
		System.out.println("Bad input");
		for(int i = 0; i < tokens.length; i++){ System.out.print(tokens[i]); }
		System.exit(0);
	    }
	SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy HH:mm");
	Calendar cal = new GregorianCalendar();
	try{
	cal.setTime(format.parse(tokens[1]+" "+tokens[2]+" "+tokens[3]+" "+tokens[4]));
	}catch(Exception e){}
	int trainNumber = Integer.parseInt(tokens[5]);
	String name = "";
	for(int i = 6; i < tokens.length; i++){ name += tokens[i] + " "; }
	return new Train(hasArrived, cal, trainNumber, name);
    }

    public static void printHeader()
    {
	System.out.print("   DATE   "+"  ");
	System.out.print("TIME "+"  ");
	System.out.print("TRAIN#"+"  ");
	System.out.print("TRAIN NAME\n");
	System.out.print("----------"+"  ");
	System.out.print("-----"+"  ");
	System.out.print("------"+"  ");
	System.out.println("------------------------------------");
    }

}