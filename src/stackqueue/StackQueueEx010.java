package stackqueue;

import java.util.*;

// 프로그래머스 - 다리를 지나는 트럭
public class StackQueueEx010 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 시간: O(n * bridge_length), 공간: O(bridge_length)
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);            // 초기값은 0으로 설정
        }

        while (idx < truck_weights.length) {
            time++;         // 시간이 흐름
            currentWeight -= bridge.poll();

            // weight 보다 작으면 bridge queue 에 추가
            if (currentWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        return time + bridge_length;
    }

}
