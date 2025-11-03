package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet  {
  private List<Integer> set = new ArrayList<Integer>();

  /** Clears the internal representation of the set. */
  public void clear() {
	  set.clear();
  }

  /** @return the number of elements in the set. */
  public int length() {
	  return set.size();
  }

  /**
   * @param another object
   * @return true if the 2 sets are equal, false otherwise;
   * Two sets are equal if they contain all of the same values in ANY order.
   * This overrides the equals method from the Object class.
   * An IntegerSet and a non-IntegerSet are never equal
   */
  @Override
  public boolean equals(Object o) {
	  if(!(o instanceof IntegerSet)) {
		  return false;
	  }
	  IntegerSet other = (IntegerSet)o;
	  return set.containsAll(other.set) && other.set.containsAll(set);
  }

  /** @param value to check
   *  @return true if the set contains the value, otherwise false. 
  */
  public boolean contains(int value) {
	  return set.contains(value);
  }

  /** @return the largest item in the set (throws IllegalStateException if empty). */
  public int largest()  {
	  if(set.size() == 0) {
		  throw new IllegalStateException("Set is empty, cannot find largest value");
	  }
	  int largest = Integer.MIN_VALUE;
	  for(int i = 0 ; i < length(); i++) {
		  if(set.get(i) > largest) {
			  largest = set.get(i);
		  }
	  }
	  return largest;
  }

  /** @return the smallest item in the set (throws IllegalStateException if empty). */
  public int smallest()  {
	  if(set.size() == 0) {
		  throw new IllegalStateException("Set is empty, cannot find smallest value");
	  }
	  int smallest = Integer.MAX_VALUE;
	  for(int i = 0 ; i < length(); i++) {
		  if(set.get(i) < smallest) {
			  smallest = set.get(i);
		  }
	  }
	  return smallest;
  }

  /**@param item to add 
   * Adds an item to the set or does nothing if already present. 
  */
  public void add(int item) {
	  if(!contains(item)) {
		  set.add(item);
	  }
  }

  /**@param item to remove
   * Removes an item from the set or does nothing if not there. 
  */
  public void remove(int item) {
	  if(contains(item)) {
		  set.remove(Integer.valueOf(item));
	  }
  }

  /** @param other IntegerSet to union with 
   * Modifies this IntegerSet to contain all unique elements in this or other. 
  */
  public void union(IntegerSet other) {
	  for(int i : other.set) {
		  add(i);
	  }
  }

  /**@param other IntegerSet to intersect with
   *  Modifies this to contain only elements in both sets.
   */
  public void intersect(IntegerSet other) {
	  set.retainAll(other.set);
  }

  /** @param other IntegerSet of values to remove 
   * Modifies this to remove elements found in other. 
   */
  public void diff(IntegerSet other) {
	  for(int i : other.set) {
		  if(contains(i)) {
			  remove(i);
		  }
	  }
  }

  /* @param other IntegerSet of values to remove from
   * modifies this to become (other \ this).
   */
  public void complement(IntegerSet other) {
	  intersect(other);
	  for(int i : other.set) {
		  if(!contains(i)) {
			  add(i);
		  }
		  else {
			  remove(i);
		  }
	  }
  }

  /** @return true if the set is empty, false otherwise. */
  public boolean isEmpty() {
	  return (length() == 0);
  }
  
  /** @return String representation; overrides Object.toString(). */
  @Override
  public String toString() {
	  if(isEmpty()) {
		  return "[]";
	  }
	  String ret = "[";
	  for(int i : set) {
		  ret += i + ", ";
	  }
	  ret = ret.substring(0, ret.length() - 2) + "]";
	  return ret;
  }
}

