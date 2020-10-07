package com.example.gamebox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    private Button mButtonTictac;
    private Button mButtonFourInaRow;
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment = fragmentManager.findFragmentById(R.id.game_container);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mButtonTictac = findViewById(R.id.ttt_btn);
        mButtonFourInaRow = findViewById(R.id.fourinrow_btn);

        mButtonTictac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicTacToeFrag ticTacToeFrag = new TicTacToeFrag();
                if(fragment==null){
                    fragmentManager.beginTransaction()
                            .add(R.id.game_container, ticTacToeFrag)
                            .commit();
                }
            }
        });
        mButtonFourInaRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FourInaRowFrag fourInaRowFrag = new FourInaRowFrag();
                if(fragment==null){
                    fragmentManager.beginTransaction()
                            .add(R.id.game_container, fourInaRowFrag)
                            .commit();
                }
            }
        });
    }

}