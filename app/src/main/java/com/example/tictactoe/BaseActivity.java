package com.example.tictactoe;

import static android.icu.text.Transliterator.REVERSE;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BaseActivity extends AppCompatActivity {
    MediaPlayer click_snd, winner_snd;
    AnimatorSet animatorSet;
    final static int NULL = 0;
    final static int PLAYER_1 = 1;
    final static int PLAYER_2 = 2;
    final static int NO_WINNER = 3;
    int turn = PLAYER_1 , number = -1, score_1=0 ,score_2=0 ;
    int[] status = {NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL};
    int winner = number;
    int [][] robot_action_2_position={{0,1},{1,0},{1,2},{2,1},{3,4},{4,3},{4,5},{5,4},{6,7},{7,6},{7,8},{8,7},{0,3},{3,0},{3,6},{6,3}
            ,{1,4},{4,1},{4,7},{7,4},{2,5},{5,2},{5,8},{8,5},{0,4},{4,0},{4,8},{2,4},{4,2},{4,6},{6,4}};
    int [][] robot_action_3_position  = {{0,1,2},{1,2,0},{0,2,1},{3,4,5},{4,5,3},{3,5,4},{6,7,8},{7,8,6},{6,8,7},{0,3,6},{3,6,0},{0,6,3}
            ,{1,4,7},{4,7,1},{1,7,4},{2,5,8},{5,8,2},{2,8,5},{0,4,8},{4,8,0},{0,8,4},{2,4,6},{4,6,2},{2,6,4}};
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
    }
    public int getRandomNumber(int max){
        Random random = new Random();
        return random.nextInt(max);
    }
    public void robotClick(int tag){
        if(status[tag] != NULL || game_over) return;
        imageView_List.get(tag).setImageResource(R.drawable.multiply);

        turn = PLAYER_2;
        status[tag] = PLAYER_1;

        getResult();
        click_snd.start();
    }
    public void robotAction_1() {
        int random = getRandomNumber(status.length);
        if (!game_over) {
            if (status[random] == NULL) robotClick(random);
            else robotAction_1();
        }
    }
    public void robotAction_2(){

        if (!game_over){
            for (int [] action_2 : robot_action_2_position)
            {
                if (status[action_2[0]]==PLAYER_1 && status[action_2[1]]==NULL){
                    robotClick(action_2[1]);return;}
            }
            robotAction_1();
        }
    }
    public void robotAction_3(){

        if (!game_over){
            
            for (int [] action_3: robot_action_3_position)
            {
                if (status[action_3[0]]==PLAYER_2 && status[action_3[1]]==PLAYER_2 && status[action_3[2]]==NULL){
                    robotClick(action_3[2]);return;}
            }
            robotAction_2();
        }
    }
    public void robotAction_4(){
        if(!game_over){
            for(int [] action_4 : robot_action_3_position){
                if(status[action_4[0]] == PLAYER_1 && status[action_4[1]] == PLAYER_1 && status[action_4[2]] == NULL){
                    robotClick(action_4[2]);return;
                }
            }
            robotAction_3();
        }}
        public int checkWinner() {
        for (int[] win_pos : winner_position) {
            if (status[win_pos[0]] == status[win_pos[1]] && status[win_pos[1]] == status[win_pos[2]] && status[win_pos[0]] != NULL) {
                final_winner_position = win_pos;
                return status[win_pos[0]];
            }
        }
        return NO_WINNER;
    }
    public void getResult() {
        winner = checkWinner();
        if(winner != NO_WINNER || isFullAllCells()){
            game_over = true;

            String res_str = " ";
            switch (winner) {
                case 1:
                    res_str = player_name1 + " won.";score_1++;animationCells();
                    break;
                case 2:
                    res_str = player_name2 + " won.";score_2++;animationCells();
                    break;
                case 3:
                    res_str = "you are equal.";
                    break;
            }

            txt_score1.setText(String.valueOf(score_1));
            txt_score2.setText(String.valueOf(score_2));

            txt_result.setText(res_str);
            result_layout.setVisibility(View.VISIBLE);

            setColorCells();

            winner_snd.start();
        }}
    public boolean isFullAllCells() {
        for (int j : status) {
            if (j == NULL) return false;
        }
        return true;
    }
    public void resetGame(View view){
        if(winner == NO_WINNER) turn = PLAYER_1; else turn = winner;
        game_over=false;
        winner=number;
        Arrays.fill(status,NULL);
        for(int i=0 ; i<imageView_List.size() ; i++ )
            imageView_List.get(i).setImageResource(0);

        result_layout.setVisibility(View.GONE);
        if(turn==PLAYER_1)robotClick(getRandomNumber(status.length));
    }
    public void setColorCells(){
        for(int i=0 ; i<imageView_List.size() ; i++){
            if(status[i] == 1){
                imageView_List.get(i).setImageResource(R.drawable.multiply_grey);
            }else if(status[i] == 2){
                imageView_List.get(i).setImageResource(R.drawable.circle_grey);
            }if(winner == PLAYER_1) {
                imageView_List.get(final_winner_position[0]).setImageResource(R.drawable.multiply);
                imageView_List.get(final_winner_position[1]).setImageResource(R.drawable.multiply);
                imageView_List.get(final_winner_position[2]).setImageResource(R.drawable.multiply);
            }else if(winner == PLAYER_2){
                imageView_List.get(final_winner_position[0]).setImageResource(R.drawable.circle);
                imageView_List.get(final_winner_position[1]).setImageResource(R.drawable.circle);
                imageView_List.get(final_winner_position[2]).setImageResource(R.drawable.circle);
            }
        }
    }
    public void animationCells(){

        ArrayList<Animator> animator_list = new ArrayList<>();

        for (int pos : final_winner_position) {
            ObjectAnimator myAnimator = ObjectAnimator.ofFloat(imageView_List .get(pos),"scaleX",0.5f);
            myAnimator.setRepeatCount(7);
            myAnimator.setRepeatMode(ValueAnimator.REVERSE);
            animator_list.add(myAnimator);

            myAnimator = ObjectAnimator.ofFloat(imageView_List .get(pos),"scaleY",0.5f);
            myAnimator.setRepeatCount(7);
            myAnimator.setRepeatMode(ValueAnimator.REVERSE);
            animator_list.add(myAnimator);
        }

        animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator_list);
        animatorSet.setDuration(200);
        animatorSet.start();

    }}