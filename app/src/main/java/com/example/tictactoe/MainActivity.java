package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnsClick(View view){
        int id = view.getId();
        switch(id){
            case R.id.btn_single_player:levelDialog();
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
    private void levelDialog(){
       Dialog LevelDialog = new Dialog(this);
       LevelDialog.setContentView(R.layout.level_dialog);
        LevelDialog.setCancelable(false);
        RadioButton rdo_medium = LevelDialog.findViewById(R.id.rdo_medium);
        RadioButton rdo_easy = LevelDialog.findViewById(R.id.rdo_easy);
        RadioButton rdo_hard = LevelDialog.findViewById(R.id.rdo_hard);
        Button btn_play = LevelDialog.findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdo_easy.isChecked())startActivity(new Intent(MainActivity.this,Easy_Single_Player.class));
                else if(rdo_medium.isChecked())startActivity(new Intent(MainActivity.this,Medium_Single_Player.class));
                else if (rdo_hard.isChecked())startActivity(new Intent(MainActivity.this,Hard_Single_Player.class));
                LevelDialog.dismiss();
            }
        });
         LevelDialog.show();
    }
}