package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

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
            case R.id.btn_double_player:startActivity(new Intent(MainActivity.this,double_Player.class));
                break;
            case R.id.btn_guide_game:startActivity(new Intent(MainActivity.this,guide_Game.class));
                break;
            case R.id.btn_contact_us:startActivity(new Intent(MainActivity.this,contact_us.class));
                break;
            case R.id.btn_exit:finish();
        }
    }
}