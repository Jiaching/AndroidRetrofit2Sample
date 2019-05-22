package com.google.sign.in.retrofittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //從server撈資料回來處理

                PostApi postApi = AppClientManager.getClient().create(PostApi.class);
                postApi.index().enqueue(new Callback<List<Posts>>() {
                    @Override
                    public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                        StringBuffer sb = new StringBuffer();
                        List<Posts> list = response.body();
                        for (Posts p : list) {
                            sb.append(p.getBody());
                            sb.append("\n");
                            sb.append("---------------------\n");
                        }
                        Log.d("MainActivity", sb.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Posts>> call, Throwable t) {

                    }
                });
            }
        });
    }
}
