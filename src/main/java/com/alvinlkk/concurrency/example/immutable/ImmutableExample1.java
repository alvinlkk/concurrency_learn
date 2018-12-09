package com.alvinlkk.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;

public class ImmutableExample1 {

    private final static ImmutableList list = ImmutableList.of("a","b", "cc");

    public static void main(String[] args) {
        //无法添加
        list.add("c");
    }

}
