import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrimeNumberRange {

		
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Input: ");
	        String input = scanner.nextLine();
	        scanner.close();
			Pattern p = Pattern.compile("\\[(.*?)\\]");
			String data = null; String high = ""; String low = "";
			int lo = 0; int hi = 0;
			//formats input to be readable
			Matcher m = p.matcher(input);
			System.out.println();
			System.out.print("Output: ");
			//iterates through each set of range of numbers
	        while (m.find()) {
	           data = m.group(1);
	           String[] numbers = data.split("\\s*,\\s*");
	           low = numbers[0]; lo = Integer.parseInt(low);
	           if (lo == 0 | lo == 1 ){
	        	   lo = 2;
	           }
	           high = numbers[1]; hi = Integer.parseInt(high);
	           //prime function
	           Prime(lo, hi);
	           //format output
	           System.out.print(", ");
	        }
		}
		//prints out prime numbers from a range of numbers
		public static void Prime(int low, int high) {
			List<Integer> primeNums = new ArrayList<>();
			for (int i = low; i < (high + 1); i++) {
	            boolean isPrime = true;

	            for (int j = 2; j < i; j++) {
	                if (i % j == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	            if (isPrime) {
	                primeNums.add(i);
	            }
	        }
	        String p = primeNums.toString().replace("[", "").replace("]", "");
	        System.out.print(p);
			}
}
