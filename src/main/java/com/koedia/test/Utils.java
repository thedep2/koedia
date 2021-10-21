package com.koedia.test;

import java.util.Arrays;
import java.util.stream.Stream;

public final class Utils {

    private Utils() {}

    //
    // TEST 1
    //

    public static int test1(Integer[] input, int diffToSearch) {
        int result = 0;

        final Integer[] sortedArray = Arrays.stream(input)
                                            .sorted()
                                            .toArray(Integer[]::new);

        for (int i = 0; i < sortedArray.length - 1; i++) {
            final Integer left = sortedArray[i];

            for (int j = i + 1; j < sortedArray.length; j++) {
                final Integer right = sortedArray[j];

                int diff = right - left;

                if (diff == diffToSearch) {
                    System.out.printf("(%s, %s)/n", left, right);
                    result++;
                }

                if (diff >= diffToSearch)
                    break;
            }
        }

        return result;
    }

    //
    // TEST 2
    //

    public static String test2(int[] input) {
        StringBuilder sb = new StringBuilder();

        if (input.length == 0) return "No Profit";

        int dayToBuy = 0;
        int lastGradient = 2;
        var noProfit = true;

        for (int i = 1; i < input.length; i++) {
            final int diff = input[i] - input[i - 1];
            int gradient = calculateGradient(diff);

            if (isFirstDay(lastGradient)) {
                lastGradient = gradient;
                if (isPriceDown(gradient))
                    dayToBuy = i;
            }

            if (isGradientBreak(lastGradient, gradient)) {
                if (isPriceDown(gradient)) {
                    sb.append(String.format("(%s,%s)", dayToBuy, i - 1));
                    noProfit = false;
                } else if (isPriceUp(gradient))
                    dayToBuy = i - 1;
            }

            if (isLastDay(input, i) && isPriceUp(gradient)) {
                sb.append(String.format("(%s,%s)", dayToBuy, i));
                noProfit = false;
            }

            lastGradient = gradient;
        }

        if (noProfit)
            return "No Profit";

        return sb.toString();
    }

    private static boolean isFirstDay(int lastGradient) {
        return lastGradient == 2;
    }

    private static boolean isGradientBreak(int lastGradient, int gradient) {
        return gradient != lastGradient;
    }

    private static boolean isLastDay(int[] input, int i) {
        return i == input.length - 1;
    }

    private static boolean isPriceUp(int gradient) {
        return gradient == 1;
    }

    private static boolean isPriceDown(int gradient) {
        return gradient == -1;
    }

    private static int calculateGradient(int diff) {
        int gradient = 0;

        if (diff < 0) gradient = -1;
        if (diff > 0) gradient = 1;
        return gradient;
    }

    //
    // TEST 3
    //

    public static Object[] test3(Object[] input) {
        return flatten(input).toArray();

    }

    private static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array)
                     .flatMap(o -> o instanceof Object[] ? flatten((Object[]) o) : Stream.of(o));
    }

}
