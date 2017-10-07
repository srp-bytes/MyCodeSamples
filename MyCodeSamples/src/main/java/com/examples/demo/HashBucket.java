package com.examples.demo;


import java.util.LinkedList;
import java.util.List;

/**
 * cerner_2^5_2017
 * <p>
 * HashBucket works on the principle of hashing and bucket sort, this data
 * structure has constant time lookups, insertions. Memory efficient, as it
 * takes size as input and creates only the number of elements. This data
 * structure will avoid unnecessary sorting, if all user needs is grouping
 * objects, from there on sorting and searching the bucket will only take
 * constant time.
 * </p>
 * Use case:
 * <p>
 * {@link HashBucket} data structure is useful in grouping objects of
 * similar kind together into same bucket. Useful in finding number of Patients
 * having similar kind of issues(like by issue name), find number of patients on
 * each floor in an hospital grouped together, group all children of first hand sponsored
 * by a criteria for performing some kind of analytics,put all anagrams to a single
 * bucket, put all duplicates values to a single bucket.
 * </p>
 */
public class HashBucket<T> {
	private LinkedList<T>[] hashBucket;

	/**
	 * cerner_2^5_2017 One arg constructor which creates size number of buckets
	 * to be used.
	 * 
	 * @param size
	 *            - size of the number of elements to be inserted.
	 */
	public HashBucket(int size) {
		hashBucket = new LinkedList[size];
	}

	/**
	 * cerner_2^5_2017 Inserts value into the bucket by looking up the value's
	 * hash code, api consumer is responsible for the hash code being consistent between
	 * equal objects, so that they will be grouped into a single bucket.
	 * 
	 * @param value
	 *            - value to be inserted to the bucket
	 * @throws NullPointerException
	 *             when value is null
	 */
	public void put(T value) {
		if (value == null)
			throw new NullPointerException();
		int hashCode = value.hashCode();
		int size = hashBucket.length;
		if (hashBucket[hashCode % size] == null) {
			hashBucket[hashCode % size]= new LinkedList<T>();
		}
		hashBucket[hashCode % size].add(value);
	}
	
	/**
	 * Returns the bucket by hashcode
	 * 
	 * @param hashCode
	 * @return List<T> Returns the copy of bucket for the given hash code, else
	 *         null if there are no entries into the bucket
	 */
	public List<T> getBucket(int hashCode) {
		return new LinkedList<T>(hashBucket[hashCode % hashBucket.length]);
	}

}
