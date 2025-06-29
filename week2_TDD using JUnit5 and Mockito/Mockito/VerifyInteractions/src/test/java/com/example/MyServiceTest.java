package com.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
public class MyServiceTest {
	 @Test
	    public void testVerifyInteraction() {
	        ExternalApi m = Mockito.mock(ExternalApi.class);
	        MyService s = new MyService(m);
	        s.fetchData();
	        verify(m).getData(); // Verifies method was called
	    }
}
