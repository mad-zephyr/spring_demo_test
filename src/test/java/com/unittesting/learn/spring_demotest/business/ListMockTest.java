package com.unittesting.learn.spring_demotest.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("Hello").thenReturn("Goodbye");

        assertEquals("Hello", mock.get(0));
        assertEquals("Goodbye", mock.get(0));
        assertNull(mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("Hello").thenReturn("Goodbye");

        assertEquals("Hello", mock.get(0));
        assertEquals("Goodbye", mock.get(0));
        assertEquals("Goodbye", mock.get(1));
    }

    @Test
    public void verifyBasic() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {

        mock.add("SomeString");
        ArgumentCaptor<String> Captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(Captor.capture());

        assertEquals("SomeString", Captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {

        mock.add("SomeString1");
        mock.add("SomeString2");
        ArgumentCaptor<String> Captor = ArgumentCaptor.forClass(String.class);

        verify(mock, times(2)).add(Captor.capture());

        List<String> allValues = Captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking() {

        ArrayList<String> arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());

        arrayListMock.add("Test1");
        arrayListMock.add("Test2");

        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());
    }

    @Test
    public void spying() {

        ArrayList<String> arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Test");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());

        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");

        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
    }

}
