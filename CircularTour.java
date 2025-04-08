public class CircularTour {
    public static int tour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, end = 0;
        int currPetrol = 0, totalPetrol = 0;

        for (int i = 0; i < n; i++) {
            currPetrol += petrol[i] - distance[i];
            totalPetrol += petrol[i] - distance[i];

            if (currPetrol < 0) {
                start = i + 1;
                currPetrol = 0;
            }
        }

        return (totalPetrol < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(tour(petrol, distance));
    }
}
