package com.example.chap12;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    int count;
    TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // MainActivity에서 받은 intent
        Intent intent = getIntent();
        count = intent.getIntExtra("count", 0);

        Button btn=(Button)findViewById(R.id.detail_btn);
        countView=(TextView)findViewById(R.id.detail_count);
        countView.setText(String.valueOf(count));
        btn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent2 = new Intent();
        intent2.putExtra("count", count);
        setResult(RESULT_OK, intent2);
        super.onBackPressed();
    }

    // 액티비티의 상태 저장
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Bundle 객체에 데이터 저장
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Bundle 객체에서 데이터 불러오기
        count = savedInstanceState.getInt("count");
        countView.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View v) {
        count++;
        countView.setText(String.valueOf(count));
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
