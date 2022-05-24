package io.github.arrayv.sorts.exchange;

import io.github.arrayv.main.ArrayVisualizer;
import io.github.arrayv.sorts.templates.Sort;

/**
 * @author: University of Michigan
 */
public final class IterativeQuickSort extends Sort {
    public IterativeQuickSort(ArrayVisualizer arrayVisualizer) {
        super(arrayVisualizer);

        this.setSortListName("Iterative Quick");
        this.setRunAllSortsName("Iterative Quick Sort");
        this.setRunSortName("Iterative Quick Sort");
        this.setCategory("Quick Sorts");
        this.setBucketSort(false);
        this.setRadixSort(false);
        this.setUnreasonablySlow(false);
        this.setUnreasonableLimit(0);
        this.setBogoSort(false);
    }

    private int partition(int[] a, int start, int stop) {
        int up = start, down = stop - 1, part = a[stop];
        if (stop <= start)
            return start;
        while (true) {
            while (Reads.compareValues(a[up], part) < 0) {
                up++;
            }
            while (Reads.compareValues(part, a[down]) < 0 && up < down) {
                down--;
            }
            if (up >= down)
                break;
            Writes.swap(a, up, down, 1, true, false);
            up++;
            down--;
        }
        Writes.swap(a, up, stop, 1, true, false);
        return up;
    }

    private void quicksort(int[] a, int start, int stop) {
        int i, s = 0;
        int[] stack = Writes.createExternalArray(64);

        Writes.write(stack, s++, start, 1, true, true);
        Writes.write(stack, s++, stop, 1, true, true);

        while (s > 0) {
            stop = stack[--s];
            start = stack[--s];
            if (start >= stop)
                continue;
            i = partition(a, start, stop);
            if (i - start > stop - 1) {
                Writes.write(stack, s++, start, 1, true, true);
                Writes.write(stack, s++, i - 1, 1, true, true);
                Writes.write(stack, s++, i + 1, 1, true, true);
                Writes.write(stack, s++, stop, 1, true, true);
            } else {
                Writes.write(stack, s++, i + 1, 1, true, true);
                Writes.write(stack, s++, stop, 1, true, true);
                Writes.write(stack, s++, start, 1, true, true);
                Writes.write(stack, s++, i - 1, 1, true, true);
            }
        }
        Writes.deleteExternalArray(stack);
    }

    @Override
    public void runSort(int[] array, int currentLength, int bucketCount) {
        quicksort(array, 0, currentLength);
    }
}