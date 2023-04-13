package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class double_Player extends AppCompatActivity {
    final static int NULL=0;
    final static int PLAYER_1=1;
    final static int PLAYER_2=2;
    int turn = 1;
    int [] status = {NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,};
    TextView txt_player1, txt_player2, txt_score1, txt_score2;
    ImageView img_0, img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8;
    String player_name1, player_name2;
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

        playerNameDialog.setCancelable(false);

        EditText edt_player1 =playerNameDialog.findViewById(R.id.edt_player1);
        EditText edt_player2 =playerNameDialog.findViewById(R.id.edt_player2);
        Button btn_play = playerNameDialog.findViewById(R.id.btn_play);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player_name1 = edt_player1.getText().toString().trim();
                player_name2 = edt_player2.getText().toString().trim();

                if(player_name1.equals("")) player_name1="Player1";
                if(player_name2.equals("")) player_name2="Player2";

                txt_player1.setText(player_name1);
                txt_player2.setText(player_name2);

                playerNameDialog.dismiss();
            }
        });
        playerNameDialog.show();
    }
    public void imagesClick(View view){

        int tag = Integer.parseInt((String)view.getTag());

        if(status[tag] != 0) return;

        ImageView imageView =(ImageView)view;
        if(turn == PLAYER_1){
            imageView.setImageResource(R.drawable.multiply);
            turn = PLAYER_2;
            status[tag]=PLAYER_1;
        }else {
            imageView.setImageResource(R.drawable.circle);

            turn = PLAYER_1;
            status[tag] = PLAYER_2;
        }
    }

}