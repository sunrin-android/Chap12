package com.example.chap12;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button detailBtn, dialogBtn;
    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> datas;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailBtn = findViewById(R.id.main_btn_detail);
        dialogBtn = findViewById(R.id.main_btn_dialog);
        listView = findViewById(R.id.main_list);

        detailBtn.setOnClickListener(this);
        dialogBtn.setOnClickListener(this);

        datas = new ArrayList<>();
        datas.add("onCreate");
        adapter = new ArrayAdapter<String>(this, R.layout.item_main_list, datas);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        datas.add("onSaveInstanceState");
        adapter.notifyDataSetChanged();
        // Bundle 객체에 데이터 저장
        outState.putString("data1", "hello");
        outState.putInt("data2", 100);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        datas.add("onRestoreInstanceState");
        adapter.notifyDataSetChanged();
        // Bundle 객체에서 데이터 불러오기
        String data1 = savedInstanceState.getString("data1");
        int data2 = savedInstanceState.getInt("data2");
        Toast.makeText(this, data1 + ":" + data2, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100 && resultCode == RESULT_OK){
            count = data.getIntExtra("count", 0);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        datas.add("onStart");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        datas.add("onResume");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        datas.add("onPause");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        datas.add("onDestroy");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        datas.add("onRestart");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if(v == detailBtn){
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("count", count);
            startActivityForResult(intent, 100);
        }
        else if(v == dialogBtn){
            Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        }
    }
}
