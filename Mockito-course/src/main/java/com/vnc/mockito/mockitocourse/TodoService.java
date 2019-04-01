package com.vnc.mockito.mockitocourse;

import java.util.List;

// --- Creating Studs ---
//create service TodoServiceStud
//Test TodoBusinessServiceImpl Using TodoServiceStub

public interface TodoService {
	
	public List<String> retrieveTodos(String user);
	
	
	public void deleteTodo(String todo);

}
