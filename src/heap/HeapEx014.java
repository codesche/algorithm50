package heap;

import java.util.*;

// 프로그래머스 - 이중우선순위큐
public class HeapEx014 {
    public int[] solution(String[] operations) {
        // 시간 O(n log n), 공간: O(n)
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            int num = Integer.parseInt(parts[1]);

            if (parts[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (!map.isEmpty()) {
                int key = num == 1 ? map.lastKey() : map.firstKey();
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{map.lastKey(), map.firstKey()};
    }
}
