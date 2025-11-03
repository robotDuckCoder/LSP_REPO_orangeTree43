package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * {@link IntegerSet}
 */

public class IntegerSetTest {

	/** {@link IntegerSet#clear()} */
	@Test
	public void testClear() {
		// Create a new Integer Set
		IntegerSet test = new IntegerSet();
		// add 3 items
		test.add(0);
		test.add(1);
		test.add(2);
		// assert that clear properly clears the IntegerSet() by comparing it to an empty IntegerSet
		test.clear();
		assertEquals(test, new IntegerSet());
	}
	
	/** {@link IntegerSet#length()} with length 100 */
	@Test
	public void testNormalLength() {
		IntegerSet test = new IntegerSet();
		for(int i = 0; i < 100; i++) {
			test.add(i);
		}
		assertEquals(test.length(), 100);
	}
	
	/** {@link IntegerSet#length()} with length 0*/
	@Test
	public void testEmptyLength() {
		IntegerSet test = new IntegerSet();
		assertEquals(test.length(), 0);
	}
	
	/** {@link IntegerSet#equals(Object)} */
	@Test
	public void testEquals() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		for(int i = 0; i < 100; i++) {
			test.add(i);
		}
		for(int i = 99; i >= 0; i--) {
			test2.add(i);
		}
		assertEquals(test.equals(test2), true);
	}
	
	/** {@link IntegerSet#equals(Object)} with empty sets*/
	@Test
	public void testEmptyEquals() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		assertEquals(test.equals(test2), true);
	}
	
	/** {@link IntegerSet#equals(Object)} with non-equal sets*/
	@Test
	public void testNotEquals() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		for(int i = 0; i < 100; i++) {
			test.add(i);
		}
		for(int i = 100; i > 200; i++) {
			test2.add(i);
		}
		assertEquals(test.equals(test2), false);
	}
	
	/** {@link IntegerSet#equals(Object)} with a non-set comparison*/
	@Test
	public void testDifferentEquals() {
		IntegerSet test = new IntegerSet();
		test.add(0);
		test.add(1);
		test.add(2);
		int[] test2 = {0, 1, 2};
		
		// should always be false for non-IntegerSet objects
		assertEquals(test.equals(test2), false);
	}
	
	/** {@link IntegerSet#contains(int)} */
	@Test
	public void testContains() {
		IntegerSet test = new IntegerSet();
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(test.contains(1), true);
	}
	
	/** {@link IntegerSet#contains(int)} with non-contained value */
	@Test
	public void testNotContains() {
		IntegerSet test = new IntegerSet();
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(test.contains(0), false);
	}
	
	/** {@link IntegerSet#largest()} */
	@Test
	public void testLargest() {
		IntegerSet test = new IntegerSet();
		for(int i = 0; i < 50; i++) {
			test.add(i);
		}
		test.add(Integer.MAX_VALUE);
		for(int i = 50; i < 100; i++) {
			test.add(i);
		}
		assertEquals(test.largest(), Integer.MAX_VALUE);
	}
	
	/** {@link IntegerSet#largest()} with empty set, should throw IllegalStateException*/
	@Test
	public void testEmptyLargest() {
		IntegerSet test = new IntegerSet();
		
		assertThrows(IllegalStateException.class, () -> {
			test.largest();
		});
	}
	
	/** {@link IntegerSet#smallest()} */
	@Test
	public void testSmallest() {
		IntegerSet test = new IntegerSet();
		for(int i = -40; i < 40; i++) {
			test.add(i);
		}
		assertEquals(test.smallest(), -40);
	}
	
	/** {@link IntegerSet#smallest()} with empty set, should throw IllegalStateException*/
	@Test
	public void testEmptySmallest() {
		IntegerSet test = new IntegerSet();
		
		assertThrows(IllegalStateException.class, () -> {
			test.smallest();
		});
	}
	
	/** {@link IntegerSet#add(int)} */
	@Test
	public void testAdd() {
		//test if adding works
		IntegerSet test = new IntegerSet();
		test.add(Integer.MAX_VALUE);
		assertEquals(test.contains(Integer.MAX_VALUE), true);
		
		// test if duplicate values are never added
		test.add(0);
		test.add(0);
		assertEquals(test.length(), 2);
	}
	
	/** {@link IntegerSet#remove(int)} */
	@Test
	public void testRemove() {
		IntegerSet test = new IntegerSet();
		for(int i = 0; i < 5; i++) {
			test.add(i);
		}
		test.remove(2);
		assertEquals(test.contains(0), true);
		assertEquals(test.contains(1), true);
		assertEquals(test.contains(2), false);
		assertEquals(test.contains(3), true);
		assertEquals(test.contains(4), true);
	}
	
	/** {@link IntegerSet#remove(int)} on an empty set*/
	@Test
	public void testEmptyRemove() {
		IntegerSet test = new IntegerSet();
		for(int i = 0; i < 10; i++) {
			test.remove(i);
		}
		assertEquals(test.length(), 0);
	}
	
	/** {@link IntegerSet#union(IntegerSet)} */
	@Test 
	public void testUnion() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}	
		for(int i = 7; i < 17; i++) {
			test2.add(i);
		}
		IntegerSet test3 = new IntegerSet();
		for(int i = 0; i < 17; i++) {
			test3.add(i);
		}
		test.union(test2);
		assertTrue(test.equals(test3));
	}
	
	/** {@link IntegerSet#intersect(IntegerSet)} */
	@Test 
	public void testIntersect() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}	
		for(int i = 7; i < 17; i++) {
			test2.add(i);
		}
		IntegerSet test3 = new IntegerSet();
		for(int i = 7; i < 10; i++) {
			test3.add(i);
		}
		test.intersect(test2);
		assertTrue(test.equals(test3));
	}
	
	/** {@link IntegerSet#diff(IntegerSet)} */
	@Test 
	public void testDiff() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}	
		for(int i = 7; i < 17; i++) {
			test2.add(i);
		}
		IntegerSet test3 = new IntegerSet();
		for(int i = 0; i < 7; i++) {
			test3.add(i);
		}
		test.diff(test2);
		assertTrue(test.equals(test3));
	}
	
	/** {@link IntegerSet#complement(IntegerSet)} */
	@Test 
	public void testComplement() {
		IntegerSet test = new IntegerSet();
		IntegerSet test2 = new IntegerSet();
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}	
		for(int i = 7; i < 17; i++) {
			test2.add(i);
		}
		IntegerSet test3 = new IntegerSet();
		for(int i = 10; i < 17; i++) {
			test3.add(i);
		}
		test.complement(test2);
		assertTrue(test.equals(test3));
	}
	
	/** {@link IntegerSet#isEmpty()} */
	@Test
	public void testIsEmpty() {
		IntegerSet test = new IntegerSet();
		assertTrue(test.isEmpty());
		test.add(10);
		test.remove(10);
		assertTrue(test.isEmpty());
		test.add(10);
		assertFalse(test.isEmpty());
	}
	
	/** {@link IntegerSet#toString()} */
	@Test
	public void testToString() {
		IntegerSet test = new IntegerSet();
		String correct = "[]";
		assertEquals(test.toString(), correct);
		
		test.add(1);
		test.add(2);
		test.add(3);
		correct = "[1, 2, 3]";
		assertEquals(test.toString(), correct);
	}
}
