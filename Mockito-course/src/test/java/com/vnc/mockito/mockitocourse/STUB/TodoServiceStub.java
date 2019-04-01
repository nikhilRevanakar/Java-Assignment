package com.vnc.mockito.mockitocourse.STUB;

import java.util.Arrays;
import java.util.List;

import com.vnc.mockito.mockitocourse.TodoService;

public class TodoServiceStub implements TodoService{
	
	public List<String> retrieveTodos(String user)
	{
		return Arrays.asList("Learn Spring boot","Learn singing","Learn dance","Learn Spring");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
