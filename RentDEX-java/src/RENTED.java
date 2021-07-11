import java.util.Scanner;

public class RENTED {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String n=s.nextLine().trim();
		String ph=s.nextLine().trim();
		String em=s.nextLine().trim();
		String st=s.nextLine().trim();
		String ct=s.nextLine().trim();
		double ar=s.nextDouble();
		double pr=s.nextDouble();
		System.out.println("insert into rent values('"+n+"','"+st+"','"+ct+"','"+ph+"','"+em+"',"+pr+","+ar+");");
	}

}
