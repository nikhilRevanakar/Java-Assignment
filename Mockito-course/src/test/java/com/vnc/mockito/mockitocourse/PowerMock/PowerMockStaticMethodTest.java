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

import com.vnc.mockito.mockitocourse.TodoBusinessImpl;
import com.vnc.mockito.mockitocourse.TodoService;

//*********Step 1*********
@RunWith(PowerMockRunner.class)  
//*********Step 2*********
@PrepareForTest(UtilityClass.class)
public class PowerMockStaticMethodTest {
	
	// ---------- Steps ------------
	// Specific runner class if u want to use Mockito and Power Mock
	//Initialize the class which has static method	UtilityClass.class
	//mock
	
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;


	
	@Test
	public void testPowerMock_static_meethod() 
	{
		List<Integer> todos = Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(todos);

		
		//*********Step 3*********
		PowerMockito.mockStatic(UtilityClass.class);
		
		
		/*
		 * UtilityClass.staticMethod(sum) is static method which need to be mocked
		 * 
		 */
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		
		int result = systemUnderTest.methodCallingAStaticMethod();
		
		
		assertThat(result,is(150));

		// TO verify in Power mock
		// Step 1-> PowerMockito.verifyStatic()
		//Step 2-> Call that particular method
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
		
		
	}

	
	
	
}
