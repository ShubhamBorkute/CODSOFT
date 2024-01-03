package p2;

public class WithdrowOperation {
	double bal;
	double totalbal=0;
	
	
	
	public void bal(double bal) {
		this.bal=bal;
	}
public double withdrow(int amt1)
{
	
	
	//int note2000=0;
	
	
	
	int note500=0;
	int note200=0;
	
	if(amt1<=bal)
	{
	   if(amt1%200==0||amt1%500==0||amt1%2000==0) 
	    {
		   totalbal=bal-amt1;
		System.out.println("====Transaction successful====");
		System.out.println("The balence in your account is "+totalbal);
        }
	     else
	    {
	    System.out.println("Amount Must be 200 500 2000");
	    }
	}
	else
	{
	System.out.println("====Insufficient Balence====");
	}//end else
	/*if(amt1<500)
	{
		if(amt1%200==0)
		{
	note200=(amt1/200);
	amt1-=note200*200;
	System.out.println("You get Rs  200 notes "+note200);
		}
	}//end 500*/
	
	
	
	
	if(amt1>=500 && amt1<2000)
	{
		if(amt1%200==0  && amt1!=1000)//||amt1%500==0)// || amt1%2000==0)
		{
			
	//note500=(amt1/500);
	//amt1=note500*500;
	note200=(amt1/200);
	amt1-=note200*200;
	System.out.println("You get Rs  200 notes "+note200);
	note500=(amt1/500);
	amt1=note500*500;
System.out.println("You get RS 500 notes "+note500);
		}else {
		
		if(amt1%500==0 && amt1==2000)
		{
			note500=(amt1/500);
			amt1=note500*500;
      System.out.println("You get RS 500 notes "+note500);
      
		}
		}//end of else
	}
	return totalbal;
}
}	
