package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class double_Player extends AppCompatActivity {
    TextView txt_player1, txt_player2, txt_score1, txt_score2;
    ImageView img_0, img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_player);
        txt_player1 = findViewById(R.id.txt_player1);
        txt_player2 = findViewById(R.id.txt_player2);
        txt_score1 = findViewById(R.id.txt_score1);
        txt_score2 = findViewById(R.id.txt_score2);

        img_0 = findViewById(R.id.img_0);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4 = findViewById(R.id.img_4);
        img_5 = findViewById(R.id.img_5);
        img_6 = findViewById(R.id.img_6);
        img_7 = findViewById(R.id.img_7);
        img_8 = findViewById(R.id.img_8);
    playerNamesDialog();
    }
    private void playerNamesDialog(){
      Dialog  playerNameDialog = new Dialog(this);
      playerNameDialog.setContentView(R.layout.player_name_dialog);

        EditText edt_player1 =playerNameDialog.findViewById(R.id.edt_player1);
        EditText edt_player2 =playerNameDialog.findViewById(R.id.edt_player2);
        Button btn_play = playerNameDialog.findViewById(R.id.btn_play);

    }
}