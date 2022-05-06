package com.a1tech.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    Button btn;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        txt = findViewById(R.id.txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestTenSec(52, 41.563817, 60.628542);
            }
        });
    }

    public void requestTenSec(int driverId, double currLat, double currLon) {
        NoticeData service = RetrofitInstance.getRetrofitInstance().create(NoticeData.class);
        Call<GetDataModel> locationRequest = service.request(driverId, currLat, currLon);
        Log.e("Url= ", locationRequest.request().url().toString());
        locationRequest.enqueue(new Callback<GetDataModel>() {
                                    @SuppressLint("SetTextI18n")
                                    @Override
                                    public void onResponse(Call<GetDataModel> call, Response<GetDataModel> response) {
                                        txt.setText("userId = " + response.body().getUserId() + "\n" +
                                                "zakazId = " + response.body().getZakazId() + "\n" +
                                                "adress = " + response.body().getZakazFrom());
                                    }

                                    @Override
                                    public void onFailure(Call<GetDataModel> call, Throwable t) {
                                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                        Log.e(TAG, t.getMessage().toString());
                                    }
                                }
        );
    }
}