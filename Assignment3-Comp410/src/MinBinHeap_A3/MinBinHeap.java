package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size;
	private int hole; // CP tracks current hole location
	private static final int arraySize = 10000; // Everything in the array will
												// initially
												// be null. This is ok! Just
												// build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for
													// simplicity
													// of child/parent
													// computations...
													// the book/animation page
													// both do this.
	}

	// Please do not remove or modify this method! Used to test your entire
	// Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {

		size++;
		hole = size;
		if (size == 1) {
			array[1] = entry;

		}

		else {

			while (array[hole / 2].getPriority() > entry.getPriority()) {
				array[hole] = array[hole / 2];
				hole = hole / 2;
			}

			array[hole] = entry;

		}

	}

	@Override
	public void delMin() {

		if (size == 0) {
		}

		else {
			hole = 1;
			
			EntryPair toHoldLast = array[size];
			size--;
			int next = 0;

			for (; hole * 2 < size; hole = next) {

				try {
					if (array[hole * 2].getPriority() > array[hole * 2 + 1].getPriority()) {

						array[hole] = array[hole * 2 + 1];
						next = hole * 2 + 1;
						continue;

					}
				}

				catch (Exception e) {
				}
				try {

					array[hole] = array[hole * 2];
					next = hole * 2;

				} catch (Exception e) {

				}
			}
			
			array[hole]=toHoldLast;

		}

	}

	@Override
	public EntryPair getMin() {

		if (size == 0) {
			return null;
		}

		return array[1];
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public void build(EntryPair[] entries) {

		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
		}
		size += entries.length;
		hole = size / 2 -1;
		EntryPair toHold;

		for (; hole >= 1; hole--) {
			try {
				if (array[hole].getPriority() > array[hole * 2 + 1].getPriority()) {
					toHold = array[hole];
					array[hole] = array[hole * 2 + 1];
					array[hole * 2 + 1] = toHold;

				}
			}

			catch (Exception e) {
			}
			try {
				if (array[hole].getPriority() > array[hole * 2].getPriority()) {
					toHold = array[hole];
					array[hole] = array[hole * 2];
					array[hole * 2] = toHold;

				}
			} catch (Exception e) {

			}
		}

	}

}
