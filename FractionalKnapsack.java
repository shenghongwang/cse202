import java.util.*;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        List<item> list = new ArrayList<item>();
        double value = 0;
        for(int i = 0; i < values.length; i++) list.add(new item(values[i], weights[i]));
        Collections.sort(list, new Comparator<item>() {
        	public int compare(item i1, item i2) {
        		if(i1.valuePerWeight > i2.valuePerWeight) return -1;
        		else if(i1.valuePerWeight == i2.valuePerWeight) return 0;
        		else return 1;
        	}
        });
        for(int i = 0; i < list.size(); i++) {
        	value += (double)Math.min(capacity, list.get(i).weight) * list.get(i).valuePerWeight;
        	capacity -= Math.min(capacity, list.get(i).weight);
        	if(capacity == 0) break;
        }
        return value;
    }
    static class item {
    	int value;
    	int weight;
    	double valuePerWeight;
    	
    	item(int v, int w) {
    		this.value = v;
    		this.weight = w;
    		valuePerWeight = (double)value /(double)weight;
    	}
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
} 
