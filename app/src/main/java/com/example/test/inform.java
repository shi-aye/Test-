package com.example.test;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class inform extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inform);
    }
}
