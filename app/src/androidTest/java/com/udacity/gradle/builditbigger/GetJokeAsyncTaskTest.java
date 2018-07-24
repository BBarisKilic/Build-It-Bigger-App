package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(AndroidJUnit4.class)
public class GetJokeAsyncTaskTest {

    @Test
    public void asyncTaskTest() throws Exception {
        final MainActivityFragment mainActivityFragment = new MainActivityFragment();
        mainActivityFragment.setTesting();
        EndpointGetJokeAsyncTask getJokeAsyncTask = new EndpointGetJokeAsyncTask(new EndpointGetJokeAsyncTask.OnEventListener<String>() {
            @Override
            public void onSuccess(String joke) {
                mainActivityFragment.setJoke(joke);
            }
        });
        getJokeAsyncTask.execute();
        Thread.sleep(3000);
        assertThat(mainActivityFragment.getJoke(), not(isEmptyString()));
    }
}
