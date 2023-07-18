package io.github.arrayv.sorts.exchange;

import io.github.arrayv.main.ArrayVisualizer;
import io.github.arrayv.sorts.templates.Sort;

/*

CODED FOR ARRAYV BY PCBOYGAMES

------------------------------
- SORTING ALGORITHM MADHOUSE -
------------------------------

*/
final public class AdaptiveClamberSort extends Sort {
    public AdaptiveClamberSort(ArrayVisualizer arrayVisualizer) {
        super(arrayVisualizer);
        this.setSortListName("Adaptive Clamber");
        this.setRunAllSortsName("Adaptive Clamber Sort");
        this.setRunSortName("Adaptive Clambersort");
        this.setCategory("Exchange Sorts");
        this.setBucketSort(false);
        this.setRadixSort(false);
        this.setUnreasonablySlow(false);
        this.setUnreasonableLimit(0);
        this.setBogoSort(false);
    }

    @Override
    public void runSort(int[] array, int currentLength, int bucketCount) {
        int left = 0;
        int right = 1;
        while (right < currentLength) {
            if (Reads.compareIndices(array, right - 1, right, 0.5, true) > 0) {
                left = 0;
                while (left < right) {
                    if (Reads.compareIndices(array, left, right, 0.5, true) > 0) {
                        while (left < right) {
                            Writes.swap(array, left, right, 0.2, true, false);
                            left++;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
    }
}