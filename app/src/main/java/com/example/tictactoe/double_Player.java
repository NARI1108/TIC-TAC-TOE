package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class double_Player extends AppCompatActivity {
    final static int NULL = 0;
    final static int PLAYER_1 = 1;
    final static int PLAYER_2 = 2;
    final static int NO_WINNER = 3;
    int turn = PLAYER_1 , number = -1;
    int[] status = {NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL};
    int winner = number;
    int[][] winner_position = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    ArrayList<ImageView> imageView_List = new ArrayList<>();
    TextView txt_player1, txt_player2, txt_score1, txt_score2, txt_result;
    ImageView img_0, img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8;
    String player_name1, player_name2;
    Button btn_play_again;
    RelativeLayout result_layout;
    Boolean game_over = false;
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
            getResult();
    }
    private int checkWinner() {
        for (int[] win_pos : winner_position) {
            if (status[win_pos[0]] == status[win_pos[1]] && status[win_pos[1]] == status[win_pos[2]] && status[win_pos[0]] != NULL) {
                return status[win_pos[0]];
            }
        }
        return NO_WINNER;
    }

    private void getResult() {
        winner = checkWinner();
        if(winner != NO_WINNER || isFullAllCells()){
            game_over = true;
            String res_str = " ";
            switch (winner) {
                case 1:
                    res_str = player_name1 + " won.";
                    break;
                case 2:
                    res_str = player_name2 + " won.";
                    break;
                case 3:
                    res_str = "you are equal.";
                    break;
            }
            txt_result.setText(res_str);
            result_layout.setVisibility(View.VISIBLE);
        }}
    private boolean isFullAllCells() {
        for (int j : status) {
            if (j == NULL) return false;
        }
        return true;
    }
    public void resetGame(View view){
        if(winner == NO_WINNER) turn = PLAYER_1; else turn = winner;
         for(int i=0 ; i<imageView_List.size() ; i++ ){ imageView_List.get(i).setImageResource(0);}
        result_layout.setVisibility(View.GONE);
    }
}
