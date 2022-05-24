package sorts.exchange;

import main.ArrayVisualizer;
import sorts.templates.Sort;

/*

CODED FOR ARRAYV BY PCBOYGAMES

------------------------------
- SORTING ALGORITHM MADHOUSE -
------------------------------

*/
final public class AdaptiveSquareClamberSort extends Sort {
    public AdaptiveSquareClamberSort(ArrayVisualizer arrayVisualizer) {
        super(arrayVisualizer);
        this.setSortListName("Adaptive Square Clamber");
        this.setRunAllSortsName("Adaptive Square Clamber Sort");
        this.setRunSortName("Adaptive Square Clambersort");
        this.setCategory("Exchange Sorts");
        this.setComparisonBased(true);
        this.setBucketSort(false);
        this.setRadixSort(false);
        this.setUnreasonablySlow(false);
        this.setUnreasonableLimit(0);
        this.setBogoSort(false);
    }

    protected int squareSearch(int[] array, int a, int b, int value) {
        while (a < b) {
            int m = (int)Math.sqrt(b * a);
            Highlights.markArray(1, a);
            Highlights.markArray(3, m);
            Highlights.markArray(2, b);
            Delays.sleep(1);
            if (Reads.compareValues(value, array[m]) < 0) b = m;
            else a = m + 1;
        }
        Highlights.clearMark(3);
        return a;
    }

    @Override
    public void runSort(int[] array, int currentLength, int bucketCount) {
        int left = 0;
        int right = 1;
        while (right < currentLength) {
            Highlights.markArray(1, right - 1);
            Highlights.markArray(2, right);
            Delays.sleep(1);
            if (Reads.compareValues(array[right - 1], array[right]) > 0) {
                left = squareSearch(array, 0, right - 1, array[right]);
                while (left < right) {
                    Writes.swap(array, left, right, 0.2, true, false);
                    left++;
                }
            }
            right++;
        }
    }
}