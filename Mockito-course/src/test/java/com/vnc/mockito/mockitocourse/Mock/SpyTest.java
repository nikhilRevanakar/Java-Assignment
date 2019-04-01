package com.vnc.mockito.mockitocourse.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

public class SpyTest {
	
/*
 * Without spy
 * 
 * Its not affecting size even though we have added 1 element bcoz its mock ArrayList(Dummy)
 */
	@Test
	public void without_spy() {
		List arrayListMock=mock(ArrayList.class);
		
		assertEquals(0, arrayListMock.size());
		
		when(arrayListMock.size()).thenReturn(2);
		arrayListMock.add("Dummy");
		assertEquals(2, arrayListMock.size());
	}
	

/*
 * With spy
 * 
 * Its affecting size bcoz its spy ArrayList(real)
 */
	@Test
	public void with_Spy() {
		List arrayListSpy=spy(ArrayList.class);
		
		assertEquals(0, arrayListSpy.size());
		
	
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		
		/*
		test failure
		arrayListSpy.remove("Dummy");
		assertEquals(1, arrayListSpy.size());
		*/
		
		// test Successed
		arrayListSpy.remove("Dummy");
		assertEquals(0, arrayListSpy.size());
		
		
		/*
		 * You can override some method which u want to stub
		 */
		when(arrayListSpy.size()).thenReturn(5);
		assertEquals(5, arrayListSpy.size());
	}

}
