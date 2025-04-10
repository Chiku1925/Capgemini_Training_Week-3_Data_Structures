public class SelectionSortExamScores {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {78, 92, 65, 89, 73};
        selectionSort(examScores);
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
