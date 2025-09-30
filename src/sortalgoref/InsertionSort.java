package sortalgoref;

// 삽입정렬
// 시간 복잡도 - O(N^2), 거의 정렬된 경우 O(N)
// 공간 복잡도 - O(1)
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
