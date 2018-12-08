package com.alvinlkk.concurrency.example.publish;

import com.alvinlkk.concurrency.annotations.ThreadNotSafe;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

//不安全的发布对象
@ThreadNotSafe
@Slf4j
public class UnsafePublish {

    private String[] arr = {"a", "b", "c"};

    //发布对象
    public String[] getArr() {
        return arr;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getArr()));

        unsafePublish.getArr()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getArr()));
    }
}
