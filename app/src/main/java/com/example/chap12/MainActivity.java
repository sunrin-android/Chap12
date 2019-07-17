package com.example.chap12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button detailBtn, dialogBtn;
    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> datas;

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
            startActivity(intent);
        }
        else if(v == dialogBtn){
            Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        }
    }
}
