package com.example.papbwhatsappsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) this.findViewById(R.id.btnDial))
                .setOnClickListener(this);
        ((Button) this.findViewById(R.id.btnWhatsApp))
                .setOnClickListener(this);
        ((Button) this.findViewById(R.id.btnSecondSend))
                .setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String phoneNumber = ((EditText) this.findViewById(R.id.editTextPhone))
                .getText().toString();
        String message = ((EditText) this.findViewById(R.id.editTextMessage))
                .getText().toString();

        actionHandler(view, phoneNumber, message);
    }

    protected void actionHandler(View view, String phoneNumber, String message) {

        switch (view.getId()) {
            case R.id.btnDial: {
                Uri uri = Uri.parse("tel:" + phoneNumber);
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }
            break;
            case R.id.btnWhatsApp: {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_TEXT, message);
                it.putExtra("jid", phoneNumber + "@s.whatsapp.net");
                it.setType("text/plain");
                it.setPackage("com.whatsapp");
                startActivity(it);
            }
            break;
            case R.id.btnSecondSend: {
                Intent it = new Intent(this, ActivityDua.class);
                it.putExtra("phoneNumber",phoneNumber);
                it.putExtra("message",message);
                startActivity(it);
            }
            break;
        }
    }

}