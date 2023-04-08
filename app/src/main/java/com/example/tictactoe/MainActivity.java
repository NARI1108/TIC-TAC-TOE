package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnsClick(View view){
        int id = view.getId();
        switch(id){
            case R.id.btn_single_player:startActivity(new Intent(MainActivity.this,single_Player.class));
                break;
            case R.id.btn_exit:finish();
        }
    }
}