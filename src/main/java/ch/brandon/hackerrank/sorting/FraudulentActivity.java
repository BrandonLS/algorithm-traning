package ch.brandon.hackerrank.sorting;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int period) {
        int notifications = 0;

        int[] data = new int[201];
        for (int i = 0; i < period; i++) {
            data[expenditure[i]]++;
        }

        for (int i = period; i < expenditure.length; i++) {
            double median = getMedian(data, period);
            int currentValue = expenditure[i];
            if (currentValue >= 2 * median) {
                notifications++;
            }

            data[expenditure[i]]++;
            data[expenditure[i - period]]--;
        }
        return notifications;
    }


    static double getMedian(int[] data, int period) {
        int count = 0;

        if (period % 2 == 1) {
            double median = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > period / 2) {
                    median = j;
                    break;
                }
            }
            return median;
        } else {
            int firstPos = -1;
            int secondPos = -1;

            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (firstPos == -1 && count >= period / 2) {
                    firstPos = j;
                }
                if (count >= period / 2 + 1) {
                    secondPos = j;
                    break;
                }
            }
            return (firstPos + secondPos) / 2.0;
        }
    }
}
