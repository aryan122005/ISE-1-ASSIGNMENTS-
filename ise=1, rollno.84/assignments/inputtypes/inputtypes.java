package com.example.inputtypes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class inputtypes extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etAddress;
    ProgressBar progressBar;
    TextView tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputtypes);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tvProgress);


        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateProgress();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        etName.addTextChangedListener(watcher);
        etEmail.addTextChangedListener(watcher);
        etPhone.addTextChangedListener(watcher);
        etAddress.addTextChangedListener(watcher);
    }

    private void updateProgress() {
        int totalFields = 4;
        int filled = 0;

        if (!etName.getText().toString().trim().isEmpty()) filled++;
        if (!etEmail.getText().toString().trim().isEmpty()) filled++;
        if (!etPhone.getText().toString().trim().isEmpty()) filled++;
        if (!etAddress.getText().toString().trim().isEmpty()) filled++;

        int progress = (filled * 100) / totalFields;

        progressBar.setProgress(progress);
        tvProgress.setText(progress + "% Completed");
    }
}