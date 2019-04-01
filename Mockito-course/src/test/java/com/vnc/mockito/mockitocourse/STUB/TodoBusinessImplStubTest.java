package com.vnc.mockito.mockitocourse.STUB;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.vnc.mockito.mockitocourse.TodoBusinessImpl;
import com.vnc.mockito.mockitocourse.TodoService;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetreiveTodosRelatedToSpring_usingStub() 
	{
		TodoService todoServiceStub=new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceStub);
		
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

	/*
	 * If u want to return 0 in TodoServiceStub
	 * then u have to write condition for diff user like dummy and dummy1
	 *
	@Test
	public void testRetreiveTodosRelatedToSpring_usingStub2() 
	{
		TodoService todoServiceStub=new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy1");
		
		String[] name=new String[2];
		
		int i=0;
		for(String filteredTodosList:filteredTodos)
		{
			name[i]=filteredTodosList;
			i++;
		}
		
		String[] exp= {};
		
		assertEquals(0, filteredTodos.size());
		assertArrayEquals(exp, name);
		
	}
*/
	
	
}
