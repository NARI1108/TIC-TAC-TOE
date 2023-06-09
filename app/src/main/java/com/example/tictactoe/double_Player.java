package com.example.tictactoe;


import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class double_Player extends BaseActivity {

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

        imageView_List.add(img_0); imageView_List.add(img_1); imageView_List.add(img_2);
        imageView_List.add(img_3); imageView_List.add(img_4); imageView_List.add(img_5);
        imageView_List.add(img_6); imageView_List.add(img_7); imageView_List.add(img_8);
        txt_result = findViewById(R.id.txt_result);

        btn_play_again = findViewById(R.id.btn_play_again);

        result_layout = findViewById(R.id.result_layout);


        playerNamesDialog();
        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame(false);
            }
        });

}
    private void playerNamesDialog() {
        Dialog playerNameDialog = new Dialog(this);
        playerNameDialog.setContentView(R.layout.player_name_dialog);

        playerNameDialog.setCancelable(false);

        EditText edt_player1 = playerNameDialog.findViewById(R.id.edt_player1);
        EditText edt_player2 = playerNameDialog.findViewById(R.id.edt_player2);
        Button btn_play = playerNameDialog.findViewById(R.id.btn_play);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player_name1 = edt_player1.getText().toString().trim();
                player_name2 = edt_player2.getText().toString().trim();

                if (player_name1.equals("")) player_name1 = "Player1";
                if (player_name2.equals("")) player_name2 = "Player2";

                txt_player1.setText(player_name1);
                txt_player2.setText(player_name2);
                setColorTextViews();
                playerNameDialog.dismiss();
            }
        });
        playerNameDialog.show();
    }
    public void imagesClick(View view) {

        int tag = Integer.parseInt((String) view.getTag());

            if (status[tag] != NULL || game_over) return;

            ImageView imageView = (ImageView) view;
            if (turn == PLAYER_1) {
                imageView.setImageResource(R.drawable.multiply);
                turn = PLAYER_2;
                status[tag] = PLAYER_1;
            } else {
                imageView.setImageResource(R.drawable.circle);

                turn = PLAYER_1;
                status[tag] = PLAYER_2;
            }
            setColorTextViews();
            getResult(false);
            click_snd.start();
    }
    @Override
    protected void onResume(){
       if(click_snd==null) click_snd = MediaPlayer.create(this,R.raw.click);
       if(winner_snd==null) winner_snd = MediaPlayer.create(this,R.raw.win_sound);
     super.onResume();
    }
    @Override
    protected void onPause(){
      if(click_snd!=null) click_snd.release();
      if(winner_snd!=null) winner_snd.release();
       super.onPause();
    }

}
