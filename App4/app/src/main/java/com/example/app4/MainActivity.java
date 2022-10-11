package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    String url = "https://rheaadhikari.pythonanywhere.com/add?a=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        Button btn = findViewById(R.id.btn);
        TextView tv = findViewById(R.id.tv);
        queue = Volley.newRequestQueue(getApplicationContext());
        btn.setOnClickListener(view -> {
            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url + et1.getText().toString() + "&b=" +et2.getText().toString(),
                    response ->{
                        Log.d("agadge", response);
                        tv.setText(response);
                    },
                    error ->{
                        tv.setText("error");
                    }
            );
            queue.add(request);
        });
    }
}