package com.ianwarwick.example.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountingViewModel countingViewModel = ViewModelProviders.of(this).get(CountingViewModel.class);

        countingViewModel.incrementCounter();

        countingViewModel.logCount();
    }

    public static class CountingViewModel extends ViewModel {

        private int counter;

        public void incrementCounter() {
            counter++;
        }

        public void logCount() {
            Log.d(TAG, "counter is at " + counter);
        }

        @Override
        protected void onCleared() {
            Log.d(TAG, "CountingViewModel got cleared!");
            super.onCleared();
        }
    }
}
