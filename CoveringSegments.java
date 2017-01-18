import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
    	List<Segment> list = new LinkedList<>();
    	for(Segment s: segments) list.add(s);
        Collections.sort(list, new Comparator<Segment>() {
        	public int compare(Segment s1, Segment s2) {
        		return Integer.compare(s1.end, s2.end);
        	}
        });
        int[] res = new int[segments.length];
        int index = 0;
        int point = list.get(0).end;
        for(int i = 1; i < list.size(); i++) {
        	if(point >= list.get(i).start && point <= list.get(i).end) continue;
        	else {
        		res[index++] = point;
        		point = list.get(i).end;
        	}
        }
        res[index++] = point;
        int[] output = new int[index];
        for(int i = 0; i < index; i++) output[i] = res[i];
        return output;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
 
