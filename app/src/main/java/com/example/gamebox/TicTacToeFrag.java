package com.example.gamebox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class TicTacToeFrag extends Fragment {
    private ImageButton b11,b12,b13,b21,b22,b23,b31,b32,b33;
    boolean turn = true;

    public TicTacToeFrag() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    private void findViews(View view) {
        b11 =view.findViewById(R.id.ib_11 );
        b12 =view.findViewById(R.id.ib_12 );
        b13 =view.findViewById(R.id.ib_13 );
        b21 =view.findViewById(R.id.ib_21 );
        b22 =view.findViewById(R.id.ib_22 );
        b23 =view.findViewById(R.id.ib_23 );
        b31 =view.findViewById(R.id.ib_31 );
        b32 =view.findViewById(R.id.ib_32 );
        b33 =view.findViewById(R.id.ib_33 );

    }

    private void setListeners() {
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b11);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b12);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b13);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b21);
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b22);
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b23);
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b31);
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b32);
            }
        });
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b33);
            }
        });

    }
    public void paint(ImageButton x){
        if(turn)
            x.setImageResource(R.drawable.cross);
        else
            x.setImageResource(R.drawable.circle);
        turn=!turn;
        x.setEnabled(false);
    }
}