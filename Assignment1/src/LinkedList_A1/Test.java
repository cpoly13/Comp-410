package LinkedList_A1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListImplTest {

    @Test
    public void clearEasy() {
	    LIST_Interface l = new LinkedListImpl();
	    try {
	      l.clear();
	     assertTrue("List not empty after clear", l.isEmpty());
	    } catch (Exception e) {
	       fail("Exception thrown: " + e.getMessage());
	    }
    }

    @Test
    public void clearMedium() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            l.clear();
            assertTrue("List not empty after clear", l.isEmpty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void clearHard() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            l.remove(0);
            l.clear();
            assertTrue("List not empty after clear", l.isEmpty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void sizeEasy() {
        LIST_Interface l = new LinkedListImpl();
        try {
            assertEquals("New List has unexpected size", 0, l.size());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void sizeMedium() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            assertEquals("List after inserts has unexpected size", 2, l.size());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void sizeHard() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            l.remove(0);
            assertEquals("List after inserts/remove has unexpected size", 1, l.size());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void isEmptyEasy() {
        LIST_Interface l = new LinkedListImpl();
        try {
            assertTrue("New List not empty", l.isEmpty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void isEmptyMedium() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertFalse("List after insert empty", l.isEmpty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void isEmptyHard() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.remove(0);
            assertTrue("List after insert/remove not empty", l.isEmpty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void insertEasy() {
        LIST_Interface l = new LinkedListImpl();
        try {
            assertTrue("Insert at valid index returned false", l.insert(new Node(5.6), 0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void insertMedium() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertTrue("Insert at valid index returned false", l.insert(new Node(6.5), 1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void insertHard() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertTrue("Insert at valid index returned false", l.insert(new Node(6.5), 0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void insertChallenge() {
        LIST_Interface l = new LinkedListImpl();
        try {
            assertFalse("Insert at invalid index returned true", l.insert(new Node(6.5), -1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void insertChallengePlus() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertFalse("Insert at invalid index returned true", l.insert(new Node(6.5), 2));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void insertMaybe() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(null, 0);
            fail("Exception not thrown when inserting null node");
        } catch (Exception e) {
        }
    }
    
    @Test
    public void removeEasy() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertTrue("Remove at valid index returned false", l.remove(0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void removeMedium() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            assertTrue("Remove at valid index returned false", l.remove(0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void removeHard() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 0);
            assertTrue("Remove at valid index returned false", l.remove(1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void removeChallenge() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(6.5), 0);
            assertFalse("Remove at invalid index returned true", l.remove(-1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void removeChallengePlus() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertFalse("Remove at invalid index returned true", l.remove(2));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getEasy() {
        LIST_Interface l = new LinkedListImpl();
        try {
            Node n;
            l.insert(n = new Node(5.6), 0);
            assertEquals("Get returns wrong node", n, l.get(0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getMedium() {
        LIST_Interface l = new LinkedListImpl();
        try {
            Node n;
            l.insert(n = new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            assertEquals("Get returns wrong node", n, l.get(0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getMediumPlus() {
        LIST_Interface l = new LinkedListImpl();
        try {
            Node n;
            l.insert(new Node(5.6), 0);
            l.insert(n = new Node(6.5), 1);
            assertEquals("Get returns wrong node", n, l.get(1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getHard() {
        LIST_Interface l = new LinkedListImpl();
        try {
            Node n;
            l.insert(n = new Node(5.6), 0);
            l.insert(new Node(6.5), 0);
            assertEquals("Get returns wrong node", n, l.get(1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getChallenge() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            assertEquals("Get returns wrong node", null, l.get(-1));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getChallengePlus() {
        LIST_Interface l = new LinkedListImpl();
        try {
            l.insert(new Node(5.6), 0);
            l.insert(new Node(6.5), 1);
            assertEquals("Get returns wrong node", null, l.get(2));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void getChallengeExtreme() {
        LIST_Interface l = new LinkedListImpl();
        try {
            Node n;
            l.insert(new Node(5.6), 0);
            l.insert(n = new Node(6.5), 1);
            l.remove(0);
            assertEquals("Get returns wrong node", n, l.get(0));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
