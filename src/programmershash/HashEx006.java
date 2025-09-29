package programmershash;

import java.util.*;

// 프로그래머스 - 오픈채팅방
public class HashEx006 {

    public String[] solution(String[] record) {
        // 시간: O(n), 공간: O(n)
        HashMap<String, String> userMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String action = parts[0];
            String userId = parts[1];

            if (!action.equals("Leave")) {
                userMap.put(userId, parts[2]);
            }

            if (!action.equals("Change")) {
                logs.add(new String[]{action, userId});
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            String action = logs.get(i)[0];
            String userId = logs.get(i)[1];
            String nickname = userMap.get(userId);

            if (action.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }

}
