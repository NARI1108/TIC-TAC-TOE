package com.example.tictactoe;


import android.os.Bundle;

public class Easy_Single_Player extends BaseActivity {

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

    }
}