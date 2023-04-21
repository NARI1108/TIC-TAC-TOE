package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class BaseActivity extends AppCompatActivity {
    MediaPlayer click_snd, winner_snd;
    final static int NULL = 0;
    final static int PLAYER_1 = 1;
    final static int PLAYER_2 = 2;
    final static int NO_WINNER = 3;
    int turn = PLAYER_1 , number = -1, score_1=0 ,score_2=0 ;
    int[] status = {NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL};
    int winner = number;
    int[][] winner_position = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int [] final_winner_position;
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
        setContentView(R.layout.activity_base);
    }
    public int getRandomNumber(int max){
        Random random = new Random();
        return random.nextInt(max);
    }
}