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
public class PowerMockPrivateMethodTest {
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;


	@Test
	public void testPowerMock_Private_method() throws Exception
	{
		List<Integer> todos = Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(todos);
		
		/*
		 * To call private method
		 * Whitebox.invokeMethod(class_name, "method_name");
		 */
		long result=Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		
		assertEquals(6,result);

	}

	
	
}
