import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.lang.StringBuilder;

public class Train
{

    final private static String SPACING = "  ";
    private boolean hasArrived;
    private Calendar date;
    private int trainNumber;
    private String name;

    public Train(boolean hasArrived, Calendar date, int trainNumber, String name)
    {
	this.hasArrived = hasArrived;
	this.date = date;
	this.trainNumber = trainNumber;
	this.name = name;
    }

    public boolean hasArrived(){ return this.hasArrived; }
    public Calendar getDate(){ return this.date; }
    public int getTrainNumber(){ return this.trainNumber; }
    public String getName(){ return this.name; }

    public boolean lessThan(Train t)
    {
	if(this.hasArrived() && !t.hasArrived()){ return true; }
	else if(!this.hasArrived() && t.hasArrived()){ return false; }

	if(this.getDate().compareTo(t.getDate()) < 0){ return true; }
	else if(this.getDate().compareTo(t.getDate()) > 0){ return false; }

	if(this.getTrainNumber() < t.getTrainNumber()){ return true; }

	return false;

    }

    public boolean greaterThan(Train t)
    {
	if(this.hasArrived() && !t.hasArrived()){ return false; }
	else if(!this.hasArrived() && t.hasArrived()){ return true; }

	if(this.getDate().compareTo(t.getDate()) < 0){ return false; }
	else if(this.getDate().compareTo(t.getDate()) > 0){ return true; }

	if(this.getTrainNumber() > t.getTrainNumber()){ return true; }

	return false;
    }

    public boolean equals(Train t)
    {
	if( (this.hasArrived() && t.hasArrived()) 
	    && (this.getDate().compareTo(t.getDate()) == 0) 
	    && (this.getTrainNumber() == t.getTrainNumber())
	    )
	    {
		return true;
	    }
	return false;
    }

    public String toString()
    {
	return toString(false);
    }

    public String toString(boolean includeStatus)
    {
	StringBuilder string = new StringBuilder();
	if(includeStatus)
	    {
		if(this.hasArrived())
		    {
			string.append("A");
		    }
		else
		    {
			string.append("D");
		    }
		string.append(SPACING);
	    }

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	string.append(dateFormat.format(this.getDate().getTime()));
	string.append(SPACING);
	string.append(timeFormat.format(this.getDate().getTime()));
	string.append(SPACING);
	string.append(String.format("%6s", ""+this.getTrainNumber()));
	string.append(SPACING);
	string.append(this.getName());
	return string.toString();
    }
}