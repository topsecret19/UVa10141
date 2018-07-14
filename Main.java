import java.util.*;
public class Main {

	public static void main(String[] args){
		double requirements, rmet, compliance; 
		double highestCompliance=0.0;
		float lowestPrice=0;
		float price,x,y;
		int  proposals; 
		int counter=0;
		String skip, candidate;
		String winner="";
		Hashtable<String,Float> ht1 = new Hashtable<String,Float>();
		Hashtable<Double,String> ht2= new Hashtable<Double,String>();
		Scanner sc = new Scanner(System.in);
		requirements = sc.nextInt();
		while(requirements>0) {
			proposals = sc.nextInt();
			for(int i=0; i<requirements; i++) {
				skip=sc.next();	
				skip+=sc.nextLine();
			}
			for(int j=0; j<proposals; j++) {
				candidate = sc.next();
				candidate += sc.nextLine();
				price=sc.nextFloat();
				rmet=sc.nextInt();
				compliance = rmet/requirements;
				ht1.put(candidate, price);
				if(j==0) {
					ht2.put(compliance, candidate);
					lowestPrice = price;
					highestCompliance= compliance;
					winner=candidate;
				}else {
					if(highestCompliance<compliance) {
						highestCompliance= compliance;
						winner = candidate;
						ht2.put(compliance, candidate);
					}
					if(highestCompliance==compliance) {
						x= ht1.get(winner);
						y=ht1.get(candidate);
						if(x>y) {
							ht2.put(compliance, candidate);
							winner = candidate;
						}
					}
				}
				for(int k=0; k<rmet; k++) {
					skip=sc.next();
					skip+=sc.nextLine();
					}
			}
			counter++;
			System.out.println("RFP #"+counter);
			System.out.println(winner);
			System.out.println();
			highestCompliance = 0.0;
			lowestPrice=0;
			winner="";
			requirements = sc.nextInt();
		}
	}
}
