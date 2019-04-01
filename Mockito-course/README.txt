-> assertion
-> studs
-> Mocks
-> BDD
-> Argument Captor
	this is used when some data saved in db but not return anything , and we need to check whether correct data is saved in db, then we will use
	captor. To assert that value .
-> Verify
	when to use verify ?
		- When method doesnt return anything
-> Capture argument passed to mock
-> Hamcrest Matchers

	import static org.hamcrest.Matchers.*;
	import static org.hamcrest.CoreMatchers.*;
	
	assertThat(scores, hasSize(4));
    assertThat(scores, hasItems(100, 101));
    assertThat(scores, everyItem(greaterThan(90)));
    assertThat(scores, everyItem(lessThan(200)));

    // String
    assertThat("", isEmptyString());
    assertThat(null, isEmptyOrNullString());
    
-> Annotation using mockito
-> Spy

-> Power mock
	Add dependency on PowerMock.
	Using PowerMock and Mockito to mock a Static Method.
	PowerMockitoMockingStaticMethodTest
	
	Invoking private methods
    Using PowerMock and Mockito to mock a constructor
    
	
