package com.com.mvvm_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Button btnUpdate;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUpdate = findViewById(R.id.btnUpdate);
        tvTitle = findViewById(R.id.tvTitle);

        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

        vm.init();

        btnUpdate.setOnClickListener(v->{
            vm.updateNote();
        });

        vm.getNote().observe(this, changeNote ->{
            tvTitle.setText(vm.getNote().getValue().getTitle());
            Log.d(TAG, "onCreate: "+vm.getNote().getValue());
        });
    }
}