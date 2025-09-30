package sortalgoref;

// 선택 정렬
// 시간 복잡도 - O(N^2)
// 공간 복잡도 - O(1)
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; i++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
