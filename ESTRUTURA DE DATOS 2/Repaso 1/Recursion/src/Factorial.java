
public class Factorial {
	
	
	
	
	public static int Fac(int n) {
		
		if(n==1)
		return 1;
		
		return n*Fac(n-1);
	
}
	
	public static void main(String[]args) {
		System.out.print(Fac(5));
	}
}
