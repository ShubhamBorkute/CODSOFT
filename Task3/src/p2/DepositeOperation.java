package p2;

public class DepositeOperation {
	double bal;
	double totalbal=0;
	public void bal(double bal) {
		this.bal=bal;
	}
	
public double deposite(int amt)
{

	totalbal=bal+amt;
	System.out.println("====Transaction Successful====");
	System.out.println("The balence in your account is "+totalbal);
	
return totalbal ;
}




/*public void notecount(int note)
{
	if(note==200)
	{
	System.out.println("You get Rs"+note);
	}else
	if(note<500)
	{
	int note200=(note/200);
	note-=note200*200;
	System.out.println("You get Rs  200 notes "+note200);
	}
	if(note>=500 && note<2000)
	{
	int note500=(note/500);
	note=note500*500;
	System.out.println("You get RS 500 notes "+note500);
	}
	if(note==2000)
	{
		int note2000=note/2000;
		note=note2000*2000;
		System.out.println("You get RS 2000 notes "+note2000);
	}*/
//}
}