package com.vnc.mockito.mockitocourse.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.sql.SQLDataException;
import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class ListTest {

	// List size mock
	@Test
	public void listSizeMock() 
	{
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	// Multiple List size mock
	@Test
	public void multipleListSizeReturnMock() 
	{
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
	}

	/*
	 *  List Get mock
	 */
	@Test
	public void listGetMock() 
	{
		List listMock=mock(List.class);
		
		when(listMock.get(0)).thenReturn("Nikhil");
		
		assertEquals("Nikhil", listMock.get(0)); // success
		assertEquals("Nagesh", listMock.get(1)); // failure -> coz its not stubbed return null
		
		/*
		 * Argument matcher
		 * 
		 *   Irrespective of any index it should retun nikhil
		 *   
		 */
		when(listMock.get(anyInt())).thenReturn("Nikhil");
		
		
		assertEquals("Nikhil", listMock.get(0)); // success
		assertEquals("Nikhil", listMock.get(1)); // failure -> coz its not stubbed return null
		
		
		/*
		 * Argument matcher
		 * 
		 *   Irrespective of any index it should retun nikhil
		 *   
		 */
		when(listMock.get(anyInt())).thenReturn(anyString());
		
		
		assertEquals("", listMock.get(0)); // success
		assertEquals("", listMock.get(1)); // failure -> coz its not stubbed return null
	}
	
		/*
		 *  List throw exception mock
		 */
		@Test(expected=RuntimeException.class)
		public void listThrowExceptionMock() 
		{
			List listMock=mock(List.class);
			
			when(listMock.get(anyInt())).thenThrow(new RuntimeException("JUNIT"));
	
			listMock.get(0);
		}
		
		/*
		 *  List sublist throw exception mock
		 */
		@Test(expected=RuntimeException.class)
		public void listSubListThrowExceptionMock() 
		{
			List listMock=mock(List.class);
			
			when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("SubList"));
		
			listMock.get(0);
		}
		
		
		/*
		 * 	BDD STYLE
		 *  List sublist throw exception mock
		 */
		@Test
		public void listBDDMock_usingBDD() 
		{
			//  ---GIVEN----
			List<String> listMock=mock(List.class);
			
			given(listMock.get(anyInt())).willReturn("Nikhil");
		
			//---when--------
			//listMock.get(0)
			String name = listMock.get(0);
			
			assertThat(name,is("Nikhil"));
		}
	
}
