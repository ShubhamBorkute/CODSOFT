package p1;
	import java.sql.*;
	import java.util.*;
	import p2.*;

public class AtmInterface {

	static int str1;
	static double bal;
	static int amt,amt1;
	public static void main(String[]args)
	{ 
		
		Connection conn = null;
		PreparedStatement pstmt1 = null,pstmt2=null,pstmt3=null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String sql = "Select * from bankop.ps_bank where AccNo=? AND Pin=?";
		String sql2="Update bankop.ps_bank set balence=? where AccNo=?";
		String sql3="Update bankop.ps_bank set balence=balence+? where AccNo=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=dbhandlershubham&password=Shubham");
			//System.out.println("Connection Establish");
			int count=1;	
			do {
				
			System.out.println("Welcome To *** BANK");
			System.out.println("Login Module");
			System.out.println("**********Welcome To PS_Bank**********");
			System.out.println("Enter AccNo ");
			int AccNo = sc.nextInt();
			System.out.println("Enter Pin");
			int Pin = sc.nextInt();
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setInt(1, AccNo);
			pstmt1.setInt(2, Pin);			
			rs = pstmt1.executeQuery();
			if(rs.next()) {
				AccNo = rs.getInt(1);
				String name = rs.getString(2);
				bal = rs.getDouble(3);
				Pin = rs.getInt(4);
				
				System.out.println("User Details");

				System.out.println("Welcome " + name );
				System.out.println("Your Balence is " + bal); 
				System.out.println("AccNo = " + AccNo);
				
			}else {
					System.out.println("Invalid Credential");
					
						System.out.println("\n***Your Account block for 24 hour***");
						System.out.println("Thank you for banking with us");
						return ;
						
					
				}
				
			
				
				System.out.println("What Would You Like to do");
				System.out.println("1.Withdrow \n2.Deposite \n3.Transfer \n4.Cancel");
				System.out.println("Enter Your Choice");
				int ch=sc.nextInt();
				switch(ch)
				{
				case 1 : System.out.println("====You Select Withdrow====");
				         System.out.println("Enter You Amount in multiple of 100");
				          amt=sc.nextInt();
				         if(amt>0 && amt%100==0)
				         {
				        	 WithdrowOperation wd=new WithdrowOperation();
				        	 wd.bal(bal);
				        	 double xx=wd.withdrow(amt);
				        	 int dd=(int )xx;
				        	 pstmt2 = conn.prepareStatement(sql2);
								pstmt2.setInt(1, dd);
								pstmt2.setInt(2, AccNo);
								pstmt2.executeUpdate();
								//System.out.println("Your Balence is " + bal); 
				         }
				         else
				         {
				        	 System.out.println("****Invalid Amount****");
				        	 System.out.println("Amount should be multiple of 100");
				         }
				         break;
				case 2 :  System.out.println("=====You Select Deposite====");
			              System.out.println("Enter You Amount in multiple of 100");
			               amt1=sc.nextInt();
			              if(amt1>0 && amt1%100==0)  
			              {
			            	DepositeOperation dp=new DepositeOperation();
			            	dp.bal(bal);
			            	double xx=dp.deposite(amt1);
			            	 int dd=(int )xx;
			            	//dp.notecount(amt1);
			            	 pstmt2 = conn.prepareStatement(sql2);
								pstmt2.setInt(1, dd);
								pstmt2.setInt(2, AccNo);
								pstmt2.executeUpdate();
								//System.out.println("Your Balence is " + bal); 
			              }
			              else
			              {
			            	  System.out.println("****Invalid Amount****");
			 	        	 System.out.println("Amount should be multiple of 100");  
			              }
			              break;
				case 3 :  System.out.println("Transfer Module");
				System.out.println("Enter Benificiarry AccNo ");
				int AccNo2=sc.nextInt();
				System.out.println("Enter Amount");
				 amt=sc.nextInt();
				pstmt3 = conn.prepareStatement(sql3);
				pstmt3.setInt(1, amt);
				pstmt3.setInt(2, AccNo2);
				pstmt3.executeUpdate();
				System.out.println("Your Balence is " + bal); 
	              
	              break;
				case 4 : 
					System.out.println("====Operation Cancel====");
					return;
				
			    default : System.out.println("***Invalid Choice***");          
				}//end of switch
				
				
				
				System.out.println("\n****do you want continue****");
				System.out.println("1.Yes\n2.No");
			    str1=sc.nextInt();
			    count++;
			    
			    }while(str1==1);
				
				System.out.println("Thank You");
				
				
				
				
				
				System.out.println();
				System.out.println("*******************Thank You For Banking with Us************************");

			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		
	}//end of main		

	}








	
	

