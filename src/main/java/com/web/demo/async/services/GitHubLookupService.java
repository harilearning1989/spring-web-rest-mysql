package com.web.demo.async.services;

import com.web.demo.async.dto.User;

import java.util.concurrent.CompletableFuture;

public interface GitHubLookupService {

    public CompletableFuture<User> findUser(String user) throws InterruptedException;
}
