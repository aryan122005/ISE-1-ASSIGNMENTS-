package com.example.ise1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton message, phone, whatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        message= findViewById(R.id.msgbtn);
        phone= findViewById(R.id.phonebtn);
        whatsapp= findViewById(R.id.whatbtn);


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("smsto:+91 9834770602"));
                i.putExtra("sms_body", "hello from message box !!");
                startActivity(i);

            }
        });


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ph= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+91 9834770602"));

                startActivity(ph);

            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wa= new Intent(Intent.ACTION_VIEW);
                wa.setData(Uri.parse("https://www.whatsapp.com"));
                startActivity(wa);
            }
        });


    }
}