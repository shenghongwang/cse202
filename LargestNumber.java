import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        List<Integer> list = new ArrayList<Integer>();
        for(String s: a) list.add(Integer.parseInt(s));
        Collections.sort(list, new Comparator<Integer>() {
        	public int compare(Integer i1, Integer i2) {
        		String s1 = String.valueOf(i1);
        		String s2 = String.valueOf(i2);
        		if(Integer.parseInt(s1+s2) > Integer.parseInt(s2+s1)) return -1;
        		else if(Integer.parseInt(s1+s2) == Integer.parseInt(s2+s1)) return 0;
        		else return 1;
        	}
        });
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < list.size(); i++) res.append(Integer.toString(list.get(i)));
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
        scanner.close();
    }
}

