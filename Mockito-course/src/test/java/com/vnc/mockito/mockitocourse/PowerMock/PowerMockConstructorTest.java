package com.vnc.mockito.mockitocourse.PowerMock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.vnc.mockito.mockitocourse.TodoBusinessImpl;
import com.vnc.mockito.mockitocourse.TodoService;

@RunWith(PowerMockRunner.class) 
@PrepareForTest(SystemUnderTest.class)
public class PowerMockConstructorTest {
	
	//----Step-------
	// 1)PrepareForTesst -> 1) For static method give the class name which contains the static method (UtilityClass.class)
	//  				 2) For Construcot overridng give the class which over rides the constructor
	//						i.e its not ArrayList.class but its SystemUnderTest.Class
	// 2) Override the consturctor
	
	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Mock
	ArrayList mockList;

	@Test
	public void testPowerMock_Constructor() throws Exception
	{
		List<Integer> todos = Arrays.asList(1,2,3);
		
		when(mockList.size()).thenReturn(5);
		
		
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		
		assertEquals(5,size);

	}

	
	
}
