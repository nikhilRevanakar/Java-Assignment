package com.vnc.mockito.mockitocourse.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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

import com.vnc.mockito.mockitocourse.TodoBusinessImpl;
import com.vnc.mockito.mockitocourse.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoTestAnnotation {
	
	/*
	 * Instead of @RunWith(MockitoJUnitRunner.class)
	 * We can implement another runner if we use @RunWith so
	 *  we can use @Rule so that we can SpringRunner and any other kinds of runner
	 *  
	 *  
	 *  @Rule
	 *  publi MockitoRule rule=MockitoJUnit.rule();
	 */
	

	
	// Instead of writing this 
	//TodoService todoServiceMock=mock(TodoService.class);
	@Mock
	private TodoService todoServiceMock; 
	
	//Instead of writing this
	//TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	//Instead of this
	//	ArgumentCaptor<String> stringArgumentCaptor=ArgumentCaptor.forClass(String.class);
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	
	@Test
	public void testRetreiveTodosRelatedToSpring_usingMock() 
	{
		List<String> todos = Arrays.asList("Learn Spring boot","Learn singing","Learn dance","Learn Spring");
		
		
		//stub(todoServiceMock.retrieveTodos("Dummy")).return("values");
		// first create stub and then return value
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		String[] name=new String[2];
		
		int i=0;
		for(String filteredTodosList:filteredTodos)
		{
			name[i]=filteredTodosList;
			i++;
		}
		
		String[] exp={"Learn Spring boot","Learn Spring"};
		
		assertEquals(2, filteredTodos.size());
		assertArrayEquals(exp, name);
		
	}

	
	
	@Test
	public void testRetreiveTodosRelatedToSpring_usingMock_emptyList() 
	{
		List<String> todos = Arrays.asList();
		
		
		//stub(todoServiceMock.retrieveTodos("Dummy")).return("values");
		// first create stub and then return value
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		String[] name=new String[2];
		
		int i=0;
		for(String filteredTodosList:filteredTodos)
		{
			name[i]=filteredTodosList;
			i++;
		}
		
		String[] exp={"Learn Spring boot","Learn Spring"};
		
		assertEquals(0, filteredTodos.size());
		//assertArrayEquals(exp, name);
		
	}
	
	
	/*
	 *  Using BDD
	 */
	@Test
	public void testRetreiveTodosRelatedToSpring_usingBDD() 
	{
		// ===== GIven ==== - setup
		
			
			List<String> todos = Arrays.asList("Learn Spring boot","Learn singing","Learn dance","Learn Spring");
			

			// change this syntax to givne(<>).willReturn
			//when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
			given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
			
		
		
		// ==== When ===== -> when specific method is called
		
			List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
			
			
		// ==== then ======
		
			String[] name=new String[2];
			
			int i=0;
			for(String filteredTodosList:filteredTodos)
			{
				name[i]=filteredTodosList;
				i++;
			}
			
			String[] exp={"Learn Spring boot","Learn Spring"};
			
			// This one is for without BDD like when ur using When(<>).thenReturn()
			//assertEquals(2, filteredTodos.size());
			//assertArrayEquals(exp, name);
		
			//This one is for BDD style
			assertThat(filteredTodos.size(),is(2));
	}

	
	
	/*
	 *  Using BDD
	 *   
	 *   Verify mock
	 */
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD() 
	{
		// ===== GIven ==== - setup
		
			List<String> todos = Arrays.asList("Learn Spring boot","Learn singing","Learn dance","Learn Spring");
			

			// change this syntax to givne(<>).willReturn
			//when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
			given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
			
		
		// ==== When ===== -> when specific method is called
		
			todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
			
			
		// Not in BDD Style
			verify(todoServiceMock).deleteTodo("Learn singing"); // success
			//verify(todoServiceMock).deleteTodo("Learn Spring boot"); //failure
			
			// it should call never - coz it contains Spring
			verify(todoServiceMock,never()).deleteTodo("Learn Spring boot"); // success
			verify(todoServiceMock,never()).deleteTodo("Learn Spring"); // success
			
			// to specify number of times called
			verify(todoServiceMock,times(1)).deleteTodo("Learn singing"); // success
			//verify(todoServiceMock,times(2)).deleteTodo("Learn singing"); // Failure coz only once its called
			
			
			// To run atleastOnce
			verify(todoServiceMock,atLeastOnce()).deleteTodo("Learn singing"); // success
			
			// To run atLesat specified number of times
			verify(todoServiceMock,atLeast(1)).deleteTodo("Learn singing"); // success
			
			
			
		// ==== then ======
		// In BDD Style
			//verify(todoServiceMock).deleteTodo("Learn Spring boot"); //failure
			//verify(todoServiceMock).deleteTodo("Learn singing"); // success
			then(todoServiceMock).should().deleteTodo("Learn singing");
			
			// it should call never - coz it contains Spring
			//verify(todoServiceMock,never()).deleteTodo("Learn Spring boot"); // success
			//verify(todoServiceMock,never()).deleteTodo("Learn Spring"); // success
			then(todoServiceMock).should(never()).deleteTodo("Learn Spring boot"); // success
			then(todoServiceMock).should(never()).deleteTodo("Learn Spring"); // success
			
			
			
			// to specify number of times called
			//verify(todoServiceMock,times(1)).deleteTodo("Learn singing"); // success
			//verify(todoServiceMock,times(2)).deleteTodo("Learn singing"); // Failure coz only once its called
			then(todoServiceMock).should(times(1)).deleteTodo("Learn singing"); // success
			
			// To run atleastOnce
			//verify(todoServiceMock,atLeastOnce()).deleteTodo("Learn singing"); // success
			then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn singing"); // success
			
			// To run atLesat specified number of times
			//verify(todoServiceMock,atLeast(1)).deleteTodo("Learn singing"); // success
			then(todoServiceMock).should(atLeast(1)).deleteTodo("Learn singing"); // success
			
	}
	
	/*
	 *  Using BDD
	 *   
	 *   Verify mock
	 *   
	 *   capture arguremnt only once for LEARN DANCE
	 */
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD_Capture_Argurment() 
	{
		
		// Define Argument Captor on specific method call
		// Check the Argument
		
		
		
		
		// ===== GIven ==== - setup
		
			List<String> todos = Arrays.asList("Learn Spring boot","Learn dance","Learn Spring");
			
			given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
			
		
		// ==== When ===== -> when specific method is called
		
			todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
				
			
		// ==== then ======
		// In BDD Style
			then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
			
			
			assertThat(stringArgumentCaptor.getValue(),is("Learn dance"));
						
	}
	
	
	/*
	 *  Using BDD
	 *   
	 *   Verify mock
	 *   
	 *   capture arguremnt  Twice for LEARN DANCE,LEARN SINGING
	 */
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD_Capture_Argurment_twice() 
	{
		
		// Define Argument Captor on specific method call
		// Check the Argument
		
		
		// ===== GIven ==== - setup
		
			
			List<String> todos = Arrays.asList("Learn Spring boot","Learn dance","Learn singing","Learn Spring");
			
			given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
			
		
		// ==== When ===== -> when specific method is called
		
			todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
				
			
		// ==== then ======
		// In BDD Style
		// Notify 2 times inoder to exceute
			then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
			
			
			assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
			
			assertThat(stringArgumentCaptor.getAllValues().get(0),is("Learn dance"));
			assertThat(stringArgumentCaptor.getAllValues().get(1),is("Learn singing"));
	}

}
