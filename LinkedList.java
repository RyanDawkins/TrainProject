public class LinkedList
{

    private ListNode head;
    private int count;
    private ListNode current;
    private 

    public LinkedList()
    {
	this.head = null;
	this.count = 0;
	this.current = this.head;
    }

    public LinkedList add(Train t)
    {
	
    }

    public Train delete(int trainNumber)
    {
	ListNode toDelete = delete(trainNumber, this.head);
	// TO DO
    }

    public Train delete(int trainNumber, ListNode l)
    {
	if(l.getTrain().getTrainNumber() == trainNumber)
	    {
		return l;
	    }
	else if(l.hasNext())
	    {
		return delete(trainNumber, l.next());
	    }
	else
	    {
		return null;
	    }
    }

    public Train first()
    {
	this.current = this.head;
	return this.head;
    }

    public Train next()
    {
	if(this.current != null && this.current.hasNext())
	    {
		this.current = this.current.next();
		return this.current;
	    }
	return null;
    }
}