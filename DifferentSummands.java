import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int sum = 0, i = 0;
        while(true) {
        	int num = Math.min(i + 1, n - sum); 
        	if(!set.contains(num)) {
        		set.add(num);
        		res.add(num);
        		sum += num;
        		i++;
        	}
        	else {
        		num = res.remove(res.size() - 1);
        		set.remove(num);
        		sum = sum - num;
        		i++;
        	}
        	if(sum == n) return res;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
        scanner.close();
    }
}

