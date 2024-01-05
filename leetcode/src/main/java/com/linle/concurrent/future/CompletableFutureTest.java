package com.linle.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * @author chendeli
 * @Description:
 * @date 2023/6/15 14:57
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String s1 = Integer.toBinaryString(-12);
        System.out.println(s1);

        System.out.println(Integer.toBinaryString(12));

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "hello").
                thenCompose(new Function<String, CompletionStage<String>>() {
                    @Override
                    public CompletionStage<String> apply(String s) {
                        return CompletableFuture.supplyAsync(() -> s + " world");
                    }
                });
        String s = stringCompletableFuture.get();
        System.out.println(s);
    }
}
