package technicalassignment;

import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
        Integer[] leaderboards = {200, 100, 100, 50, 10};
        Integer[] player = {20, 80, 80, 10, 10, 300};
        List<Integer> result = generateRank(new HashSet(Arrays.asList(leaderboards)), Arrays.asList(player));
        System.out.println(result);
    }

    public static List<Integer> generateRank(Set<Integer> lb, List<Integer> p) {
        List<Integer> ranks = new ArrayList<Integer>();
        lb.addAll(p);

        List<Integer> merge = new ArrayList<Integer>(lb);
        Collections.sort(merge, Collections.reverseOrder());

        for (int i = 0; i < p.size(); i++) {
            int idx = merge.indexOf(p.get(i));
            ranks.add(idx+1);
        }

        return ranks;
    }
}
