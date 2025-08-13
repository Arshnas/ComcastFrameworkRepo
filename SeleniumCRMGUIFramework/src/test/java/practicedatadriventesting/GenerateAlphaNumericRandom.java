package practicedatadriventesting;

public class GenerateAlphaNumericRandom {

	public static void main(String[] args) {
		int n=20;
		//Choose a character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//Create SringBuffer size of AplhaNumericString
		StringBuilder sb = new StringBuilder(n);
		
		for(int i=0;i<n;i++) {
		//Generate a random number between 0 to AlphaNumericString variablelength
			int index = (int)(AlphaNumericString.length()*Math.random());
		//add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
}
}