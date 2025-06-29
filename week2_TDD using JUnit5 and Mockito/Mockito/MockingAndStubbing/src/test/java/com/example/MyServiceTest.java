package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalAPI m = Mockito.mock(ExternalAPI.class);
        when(m.getData()).thenReturn("Mock Data");

        MyService s = new MyService(m);
        String r = s.fetchData();

        assertEquals("Mock Data", r);
    }
}
