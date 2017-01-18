import java.util.Scanner;

public class Change {
	private static int sum = 0;
    private static int getChange(int m) {
        
    	if(m == 1) return 1;
    	else if(m >= 10) {
        	sum = 1 + getChange(m - 10);
        }
        else if(m >= 5) {
        	sum = 1 + getChange(m - 5);
        }
        else if(m >= 1) {
        	sum = 1 + getChange(m - 1);
        }
    	return sum;
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

