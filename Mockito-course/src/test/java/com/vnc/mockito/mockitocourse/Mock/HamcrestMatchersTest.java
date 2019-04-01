package com.vnc.mockito.mockitocourse.Mock;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class HamcrestMatchersTest {

	
	/*
	 * Using HAMCREST MATCHERS for LIST
	 */
	@Test
	public void test() {
		List<Integer> scores=Arrays.asList(21,44,99,101);
		
		
		assertThat(scores,hasSize(4));  //success
		
		assertThat(scores,hasItems(99,101)); //success
		
		//assertThat(scores,everyItem(greaterThan(90))); //Failure
		
		assertThat(scores,everyItem(lessThan(190))); //success
 	
	}

	
	/*
	 * Using HAMCREST MATCHERS for STRING
	 */
	@Test
	public void testString() {
		
		assertThat("",isEmptyString());
		
		assertThat(null,isEmptyOrNullString());
		
		
	}
	
	/*
	 * Using HAMCREST MATCHERS for ARRAYS
	 */
	@Test
	public void testArrays() {
		
		Integer[] marks= {1,2,3};
		
		assertThat(marks,arrayWithSize(3));
	
		// Test fails coz its not in order
		//assertThat(marks,arrayContaining(2,1,3)); 
		
		// Test Success coz its in order
		assertThat(marks,arrayContaining(1,2,3)); 
		
		// Run irrespective of order
		assertThat(marks,arrayContainingInAnyOrder(3,2,1));
				
		
		
	}
	
	/*
	 * Using HAMCREST MATCHERS for Map
	 */
	@Test
	public void testMap() {
		
		Map<String,String> info=new HashMap();
		
		info.put("1", "One");
		info.put("2", "Two");
		info.put("3", "Three");
		
				
		assertThat(info,hasKey("1"));
		
	}

}
