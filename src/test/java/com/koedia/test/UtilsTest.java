package com.koedia.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void test1() {
        Integer[] input = new Integer[]{1, 7, 5, 9, 2, 12, 3};
        var i = Utils.test1(input, 2);
        assertEquals(4, i);

        Integer[] input2 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        var i2 = Utils.test1(input2, 2);
        assertEquals(7, i2);
    }

    @Test
    void test2() {
        int[] input = {110, 190, 270, 320, 50, 545, 705};
        var i = Utils.test2(input);
        assertEquals("(0,3)(4,6)", i);

        int[] input2 = {33, 23, 35, 39, 43, 29, 44, 55, 75, 77};
        var j = Utils.test2(input2);
        assertEquals("(1,4)(5,9)", j);

    }

    @Test
    void test3() {
        Object[] input = {new Object[]{1, 2, new Object[]{3}}, 4};
        var output = Utils.test3(input);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(output).forEach(o -> sb.append(o.toString()).append(" "));
        
        assertEquals("1 2 3 4 ", sb.toString());

    }
}
