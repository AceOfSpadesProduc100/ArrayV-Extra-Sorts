/**
 *
 */
package io.github.arrayv.sorts.exchange;

import io.github.arrayv.main.ArrayVisualizer;
import io.github.arrayv.sorts.templates.Sort;

/**
 * @author McDude_73
 * @author EilrahcF
 * @implNote This sorting algorithm is bad for arrays, but good for linked
 *           lists.
 *
 */
public final class GrateSort extends Sort {

	/**
	 * @param arrayVisualizer
	 */
	public GrateSort(ArrayVisualizer arrayVisualizer) {
		super(arrayVisualizer);
		setSortListName("Grate");
		setRunAllSortsName("Grate Sort");
		setRunSortName("Gratesort");
		setCategory("Exchange Sorts");
		setBucketSort(false);
		setRadixSort(false);
		setUnreasonablySlow(true);
		setUnreasonableLimit(512);
		setBogoSort(false);

	}

	@Override
	public void runSort(int[] array, int currentLength, int bucketCount) throws Exception {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < currentLength - 1; i++) {
				for (int j = currentLength - 1; j > i; j--) {
					this.Highlights.markArray(1, i);
					this.Highlights.markArray(2, j);
					this.Delays.sleep(0.25D);
					if (this.Reads.compareIndices(array, i, j, 0.5, true) > 0) {
						sorted = false;
						this.Writes.swap(array, i, j, 0.1D, true, false);
						break;
					}
				}
			}
		}

	}

}
