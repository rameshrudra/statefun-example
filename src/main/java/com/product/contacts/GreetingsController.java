package com.product.contacts;

import java.util.concurrent.CompletableFuture;

import org.apache.flink.statefun.sdk.java.StatefulFunctions;
import org.apache.flink.statefun.sdk.java.handler.RequestReplyHandler;
import org.apache.flink.statefun.sdk.java.slice.Slice;
import org.apache.flink.statefun.sdk.java.slice.Slices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/greet")
public class GreetingsController {

	private RequestReplyHandler handler;

    @PostMapping("/{functionName}")
    public CompletableFuture<byte[]> handle(@RequestBody byte[] body) {
        return handler
                .handle(Slices.wrap(body))
                .thenApply(Slice::toByteArray);
    }
}
