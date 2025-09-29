package programmershash;

import java.util.*;

// 프로그래머스 - 베스트앨범
public class HashEx005 {

    public int[] solution(String[] genres, int[] plays) {
        // 시간 O(n log n), 공간: O(n)
        HashMap<String, Integer> genreSum = new HashMap<>();
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreSum.put(genres[i], genreSum.getOrDefault(genres[i], 0) + plays[i]);

            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<String> sortedGenres = new ArrayList<>(genreSum.keySet());
        sortedGenres.sort((a, b) -> genreSum.get(b) - genreSum.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

}
