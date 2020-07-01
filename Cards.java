public class Cards {

	  String[] SUITS = {"S","H","D","C"};
	  String[] RANKS = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10","J", "Q", "K"};

	  int index=0;
	  String firstElement;
	  String suitVal;
	  String rankVal;
	  String Output="";

	  public boolean checkSequence(String input)
	  {
		  String[] arr=input.split(",");
		  
		  //Get First Element, Suits Value & Rank Value
		  suitVal=arr[0].substring(0,1);
		  
		  if(arr[0].length()==4)
			  rankVal=arr[0].substring(2,4);
		  else
			  rankVal=arr[0].substring(2,3);

		  
		  //Get First Element Index Position in Array			  
			  for(int i=0;i<RANKS.length;i++) {
			 	if(rankVal.equalsIgnoreCase(RANKS[i])) {
					index=i;
			 	}
			  }

		 //Get Output String to check with Input String
			  try {
				  for(int i=1;i<arr.length;i++)
				  {
					  String FirstElemet=arr[0];
					  if(i==1)
					  {
						  Output=FirstElemet+","+suitVal+"#"+RANKS[index+1];
					  }
					  else
					  {
						  Output=Output+","+suitVal+"#"+RANKS[index+1];
					  }
					  index++;
				  }
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
					  return false;
				  }
					  
			  if(input.equalsIgnoreCase(Output))
			  {
				  return true;
			  }			  
	return false;
 }

 public static void main(String[] args)
 {
	  String Test = "";
	  System.out.println("Enter Input String : ");
	  Scanner scn=new Scanner(System.in);
	  Test=scn.nextLine();
	 
	  Cards cards=new Cards();
	  
	  if(cards.checkSequence(Test))
	  {
		  System.out.println("True");
	  }
	  else
	  {
		  System.out.println("False");
			  
	  }
}
}
