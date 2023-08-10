package spring.user;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalcTest {
    private Calc calc;

    @Before
    public void setUp() {
        calc = new Calc(4);
    }

    @Test
    public void testAdd() {
        int result = calc.add(6);
        assertEquals(10, result);

    }

    @Test
    public void testSum(){
        int result = calc.sum(1, 3);
        assertEquals(4, result);
    }
}
