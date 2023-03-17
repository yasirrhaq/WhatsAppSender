package com.example.papbwhatsappsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityDua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent it = this.getIntent();
        String phoneNumber = it.getStringExtra("phoneNumber");
        String message = it.getStringExtra("message");

        ((TextView) this.findViewById(R.id.textViewPhone)).setText("phone number:\n"+phoneNumber);
        ((TextView) this.findViewById(R.id.textViewMessage)).setText("message:\n"+message);
    }
}