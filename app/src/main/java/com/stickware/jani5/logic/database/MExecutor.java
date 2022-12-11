package com.stickware.jani5.logic.database;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MExecutor {

    @FunctionalInterface
    public interface AsyncInsert{

        void loadAsync();
    }

    @FunctionalInterface
    public interface PostAsync{

        void loadPost();
    }

    public static void loadTask(AsyncInsert insert, PostAsync post){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {

            insert.loadAsync();
            handler.post(post::loadPost);
        });
    }
}
