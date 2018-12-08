package com.alvinlkk.concurrency.example.publish;

import com.alvinlkk.concurrency.annotations.NotRecommend;
import com.alvinlkk.concurrency.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

//逸出
@Slf4j
@ThreadNotSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
