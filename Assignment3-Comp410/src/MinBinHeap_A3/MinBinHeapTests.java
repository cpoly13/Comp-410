package MinBinHeap_A3;

import static org.junit.Assert.*;
import org.junit.Test;

public class MinBinHeapTests {
    // Tests created by Christopher Lee
    @Test
    public void testSizeEmpty() {
        try {
            MinBinHeap heap = new MinBinHeap();
            assertEquals("size didn't return 0", 0, heap.size());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testSizeFilledInserts() {
        try {
            MinBinHeap heap = new MinBinHeap();
            heap.insert(new EntryPair("d", 10));
            heap.insert(new EntryPair("s", 4));
            heap.insert(new EntryPair("g", 7));
            heap.insert(new EntryPair("b", 5));
            heap.insert(new EntryPair("z", 1));
            heap.insert(new EntryPair("c", 0));
            heap.insert(new EntryPair("e", 11));
            heap.insert(new EntryPair("j", 3));
            assertEquals("size returned wrong size", 8, heap.size());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testSizeFilledBuild() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair[] collection = new EntryPair[8];
            collection[0] = new EntryPair("d", 10);
            collection[1] = new EntryPair("s", 4);
            collection[2] = new EntryPair("g", 7);
            collection[3] = new EntryPair("b", 5);
            collection[4] = new EntryPair("z", 1);
            collection[5] = new EntryPair("c", 0);
            collection[6] = new EntryPair("e", 11);
            collection[7] = new EntryPair("j", 3);
            heap.build(collection);
            assertEquals("size returned wrong size", 8, heap.size());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetMinEmpty() {
        try {
            MinBinHeap heap = new MinBinHeap();
            assertEquals("getMin didn't return null", null, heap.getMin());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetMinFilledInsert() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair minPair = new EntryPair("c", 0);
            heap.insert(new EntryPair("d", 10));
            heap.insert(new EntryPair("s", 4));
            heap.insert(new EntryPair("g", 7));
            heap.insert(new EntryPair("b", 5));
            heap.insert(new EntryPair("z", 1));
            heap.insert(minPair);
            heap.insert(new EntryPair("e", 11));
            heap.insert(new EntryPair("j", 3));
            assertEquals("getMin returned wrong pair", minPair, heap.getMin());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetMinFilledBuild() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair minPair = new EntryPair("c", 0);
            EntryPair[] collection = new EntryPair[8];
            collection[0] = new EntryPair("d", 10);
            collection[1] = new EntryPair("s", 4);
            collection[2] = new EntryPair("g", 7);
            collection[3] = new EntryPair("b", 5);
            collection[4] = new EntryPair("z", 1);
            collection[5] = minPair;
            collection[6] = new EntryPair("e", 11);
            collection[7] = new EntryPair("j", 3);
            heap.build(collection);
            assertEquals("getMin returned wrong pair", minPair, heap.getMin());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testInsertA() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair pair = new EntryPair("c", 5);
            heap.insert(pair);
            assertEquals("inserted wrong pair", pair, heap.getHeap()[1]);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testInsertB() {
        try {
            MinBinHeap heap = new MinBinHeap();
            heap.insert(new EntryPair("d", 15));
            heap.insert(new EntryPair("s", 30));
            heap.insert(new EntryPair("g", 4));
            heap.insert(new EntryPair("b", 38));
            heap.insert(new EntryPair("z", 12));
            heap.insert(new EntryPair("c", 18));
            heap.insert(new EntryPair("e", 6));
            heap.insert(new EntryPair("j", 0));
            heap.insert(new EntryPair("a", 24));
            heap.insert(new EntryPair("o", 14));

            int[] collection = { 0, 4, 6, 12, 14, 18, 15, 38, 24, 30 };
            int[] heapPriorities = new int[10];
            EntryPair[] heapArray = heap.getHeap();
            for (int i = 0; i < heapPriorities.length; i++) {
                heapPriorities[i] = heapArray[i + 1].getPriority();
            }
            assertArrayEquals("insert created different heap than expected", collection, heapPriorities);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testDelMinA() {
        try {
            MinBinHeap heap = new MinBinHeap();
            heap.delMin();
            assertTrue("delMin of empty heap gives min when it shouldn't", heap.getMin() == null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testDelMinB() {
        try {
            MinBinHeap heap = new MinBinHeap();
            heap.insert(new EntryPair("d", 15));
            heap.insert(new EntryPair("s", 30));
            heap.insert(new EntryPair("g", 4));
            heap.insert(new EntryPair("b", 38));
            heap.insert(new EntryPair("z", 12));
            heap.insert(new EntryPair("c", 18));
            heap.insert(new EntryPair("e", 6));
            heap.insert(new EntryPair("j", 0));
            heap.insert(new EntryPair("a", 24));
            heap.insert(new EntryPair("o", 14));
            heap.delMin();

            int[] collection = { 4, 12, 6, 24, 14, 18, 15, 38, 30 };
            int[] heapPriorities = new int[9];
            EntryPair[] heapArray = heap.getHeap();
            for (int i = 0; i < heapPriorities.length; i++) {
                heapPriorities[i] = heapArray[i + 1].getPriority();
            }
            assertArrayEquals("delMin created different heap than expected", collection, heapPriorities);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testDelMinC() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair[] collectionToBuild = new EntryPair[10];
            collectionToBuild[0] = new EntryPair("d", 15);
            collectionToBuild[1] = new EntryPair("s", 30);
            collectionToBuild[2] = new EntryPair("g", 4);
            collectionToBuild[3] = new EntryPair("b", 38);
            collectionToBuild[4] = new EntryPair("z", 12);
            collectionToBuild[5] = new EntryPair("c", 18);
            collectionToBuild[6] = new EntryPair("e", 6);
            collectionToBuild[7] = new EntryPair("j", 0);
            collectionToBuild[8] = new EntryPair("a", 24);
            collectionToBuild[9] = new EntryPair("o", 14);
            heap.build(collectionToBuild);
            heap.delMin();

            int[] collection = { 4, 12, 6, 24, 14, 18, 15, 38, 30 };
            int[] heapPriorities = new int[9];
            EntryPair[] heapArray = heap.getHeap();
            for (int i = 0; i < heapPriorities.length; i++) {
                heapPriorities[i] = heapArray[i + 1].getPriority();
            }
            assertArrayEquals("delMin created different heap than expected", collection, heapPriorities);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testBuildA() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair[] collectionToBuild = new EntryPair[0];
            heap.build(collectionToBuild);
            assertTrue("build with empty collection doesn't keep an empty heap", heap.getMin() == null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testBuildB() {
        try {
            MinBinHeap heap = new MinBinHeap();
            EntryPair[] collectionToBuild = new EntryPair[10];
            collectionToBuild[0] = new EntryPair("d", 15);
            collectionToBuild[1] = new EntryPair("s", 30);
            collectionToBuild[2] = new EntryPair("g", 4);
            collectionToBuild[3] = new EntryPair("b", 38);
            collectionToBuild[4] = new EntryPair("z", 12);
            collectionToBuild[5] = new EntryPair("c", 18);
            collectionToBuild[6] = new EntryPair("e", 6);
            collectionToBuild[7] = new EntryPair("j", 0);
            collectionToBuild[8] = new EntryPair("a", 24);
            collectionToBuild[9] = new EntryPair("o", 14);
            heap.build(collectionToBuild);

            int[] collection = { 0, 12, 4, 24, 14, 18, 6, 38, 30, 15 };
            int[] heapPriorities = new int[10];
            EntryPair[] heapArray = heap.getHeap();
            for (int i = 0; i < heapPriorities.length; i++) {
                heapPriorities[i] = heapArray[i + 1].getPriority();
            }
            assertArrayEquals("insert created different heap than expected", collection, heapPriorities);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Tests created by Zach Burk
    @Test
    public void insertEasy() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 0));
        heap.insert(new EntryPair("bcd", 1));

        assertEquals("abc", heap.getHeap()[1].getValue());
        assertEquals("bcd", heap.getHeap()[2].getValue());
        assertEquals(2, heap.size());

        assertTrue("Heap created is not a min-heap", isMinHeap(heap.getHeap(), 1, heap.size()));
    }

    @Test
    public void insertMedium() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 0));
        heap.insert(new EntryPair("bcd", 3));
        heap.insert(new EntryPair("cde", 2));
        heap.insert(new EntryPair("def", 1));

        assertEquals("abc", heap.getHeap()[1].getValue());
        assertEquals("def", heap.getHeap()[2].getValue());
        assertEquals("cde", heap.getHeap()[3].getValue());
        assertEquals("bcd", heap.getHeap()[4].getValue());
        assertEquals(4, heap.size());

        assertTrue("Heap created is not a min-heap", isMinHeap(heap.getHeap(), 1, heap.size()));
    }

    @Test
    public void insertHard() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 1));
        heap.insert(new EntryPair("bcd", 2));
        heap.insert(new EntryPair("cde", 3));
        heap.insert(new EntryPair("def", 0));

        assertEquals("def", heap.getHeap()[1].getValue());
        assertEquals("abc", heap.getHeap()[2].getValue());
        assertEquals("cde", heap.getHeap()[3].getValue());
        assertEquals("bcd", heap.getHeap()[4].getValue());
        assertEquals(4, heap.size());

        assertTrue("Heap created is not a min-heap", isMinHeap(heap.getHeap(), 1, heap.size()));
    }

    @Test
    public void insertLectureSlide() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 3));
        heap.insert(new EntryPair("bcd", 7));
        heap.insert(new EntryPair("cde", 4));
        heap.insert(new EntryPair("def", 16));
        heap.insert(new EntryPair("efg", 12));
        heap.insert(new EntryPair("fgh", 11));
        heap.insert(new EntryPair("ghi", 9));
        heap.insert(new EntryPair("hij", 31));
        heap.insert(new EntryPair("ijk", 18));
        heap.insert(new EntryPair("jkl", 21));

        assertEquals("abc", heap.getHeap()[1].getValue());
        assertEquals("bcd", heap.getHeap()[2].getValue());
        assertEquals("cde", heap.getHeap()[3].getValue());
        assertEquals("def", heap.getHeap()[4].getValue());
        assertEquals("efg", heap.getHeap()[5].getValue());
        assertEquals("fgh", heap.getHeap()[6].getValue());
        assertEquals("ghi", heap.getHeap()[7].getValue());
        assertEquals("hij", heap.getHeap()[8].getValue());
        assertEquals("ijk", heap.getHeap()[9].getValue());
        assertEquals("jkl", heap.getHeap()[10].getValue());
        assertEquals(10, heap.size());

        assertTrue("Heap created is not a min-heap", isMinHeap(heap.getHeap(), 1, heap.size()));
    }

    @Test
    public void insertLectureSlideSwap() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 3));
        heap.insert(new EntryPair("bcd", 7));
        heap.insert(new EntryPair("cde", 4));
        heap.insert(new EntryPair("def", 16));
        heap.insert(new EntryPair("efg", 12));
        heap.insert(new EntryPair("fgh", 11));
        heap.insert(new EntryPair("ghi", 9));
        heap.insert(new EntryPair("hij", 31));
        heap.insert(new EntryPair("ijk", 18));
        heap.insert(new EntryPair("jkl", 21));

        heap.insert(new EntryPair("klm", 10));

        assertEquals("abc", heap.getHeap()[1].getValue());
        assertEquals("bcd", heap.getHeap()[2].getValue());
        assertEquals("cde", heap.getHeap()[3].getValue());
        assertEquals("def", heap.getHeap()[4].getValue());
        assertEquals("klm", heap.getHeap()[5].getValue());
        assertEquals("fgh", heap.getHeap()[6].getValue());
        assertEquals("ghi", heap.getHeap()[7].getValue());
        assertEquals("hij", heap.getHeap()[8].getValue());
        assertEquals("ijk", heap.getHeap()[9].getValue());
        assertEquals("jkl", heap.getHeap()[10].getValue());
        assertEquals("efg", heap.getHeap()[11].getValue());
        assertEquals(11, heap.size());

        assertTrue("Heap created is not a min-heap", isMinHeap(heap.getHeap(), 1, heap.size()));
    }

    @Test
    public void insertLectureSlideSwapUp() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 3));
        heap.insert(new EntryPair("bcd", 7));
        heap.insert(new EntryPair("cde", 4));
        heap.insert(new EntryPair("def", 16));
        heap.insert(new EntryPair("efg", 12));
        heap.insert(new EntryPair("fgh", 11));
        heap.insert(new EntryPair("ghi", 9));
        heap.insert(new EntryPair("hij", 31));
        heap.insert(new EntryPair("ijk", 18));
        heap.insert(new EntryPair("jkl", 21));

        heap.insert(new EntryPair("klm", 2));

        assertEquals("klm", heap.getHeap()[1].getValue());
        assertEquals("abc", heap.getHeap()[2].getValue());
        assertEquals("cde", heap.getHeap()[3].getValue());
        assertEquals("def", heap.getHeap()[4].getValue());
        assertEquals("bcd", heap.getHeap()[5].getValue());
        assertEquals("fgh", heap.getHeap()[6].getValue());
        assertEquals("ghi", heap.getHeap()[7].getValue());
        assertEquals("hij", heap.getHeap()[8].getValue());
        assertEquals("ijk", heap.getHeap()[9].getValue());
        assertEquals("jkl", heap.getHeap()[10].getValue());
        assertEquals("efg", heap.getHeap()[11].getValue());
        assertEquals(11, heap.size());

        assertTrue("Heap created is not a min-heap", isMinHeap(heap.getHeap(), 1, heap.size()));
    }

    @Test
    public void findMin() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 0));
        heap.insert(new EntryPair("bcd", 1));

        assertEquals("abc", heap.getMin().getValue());
    }

    @Test
    public void easyRemoveMin() {
        Heap_Interface heap = new MinBinHeap();
        heap.insert(new EntryPair("abc", 0));
        heap.insert(new EntryPair("bcd", 3));
        heap.insert(new EntryPair("cde", 2));
        heap.insert(new EntryPair("def", 1));
        heap.delMin();

        assertEquals("def", heap.getHeap()[1].getValue());
        assertEquals("bcd", heap.getHeap()[2].getValue());
        assertEquals("cde", heap.getHeap()[3].getValue());
        assertEquals(3, heap.size());
    }

    @Test
    public void buildLecture() {
        Heap_Interface heap = new MinBinHeap();

        EntryPair[] array = { new EntryPair("abc", 6), new EntryPair("bcd", 12), new EntryPair("cde", 9),
                new EntryPair("def", 4), new EntryPair("efg", 5), new EntryPair("fgh", 3), };

        heap.build(array);

        assertEquals("fgh", heap.getHeap()[1].getValue());
        assertEquals("def", heap.getHeap()[2].getValue());
        assertEquals("abc", heap.getHeap()[3].getValue());
        assertEquals("bcd", heap.getHeap()[4].getValue());
        assertEquals("efg", heap.getHeap()[5].getValue());
        assertEquals("cde", heap.getHeap()[6].getValue());

        assertEquals(6, heap.size());
    }

    // Adapted from
    // http://stackoverflow.com/questions/4157159/algorithm-for-checking-if-an-array-with-n-elements-is-a-minimum-heap
    public static boolean isMinHeap(EntryPair arr[], int rootIndex, int heapSize) {
        boolean isMinH = true;
        int lChild = 2 * rootIndex + 1;
        int rChild = 2 * rootIndex + 2;

        // Nothing to compare here, as lChild itself is larger then arr length.
        if (lChild >= heapSize) {
            return true;
        }

        if (arr[rootIndex].getPriority() > arr[lChild].getPriority()) {
            return false;
        } else {
            isMinH = isMinH && isMinHeap(arr, lChild, heapSize);
        }

        // rChild comparison not needed, return the current state of this root.
        if (rChild >= arr.length) {
            return isMinH;
        }

        if (arr[rootIndex].getPriority() > arr[rChild].getPriority()) {
            return false;
        } else {
            isMinH = isMinH && isMinHeap(arr, rChild, heapSize);
        }

        return isMinH;
    }
}