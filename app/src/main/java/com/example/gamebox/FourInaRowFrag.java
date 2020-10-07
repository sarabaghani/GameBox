package com.example.gamebox;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FourInaRowFrag extends Fragment {

    private Button b11,b12,b13,b14,b15,b21,b22,b23,b24,b25,b31,b32,b33,b34,b35,
                    b41,b42,b43,b44,b45,b51,b52,b53,b54,b55;
    private boolean turn = true;

    public FourInaRowFrag() {
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
        View view = inflater.inflate(R.layout.fragment_four_ina_row, container, false);
        findViews(view);
        setListeners();
        return view;
    }



    private void findViews(View view) {
        b11 = view.findViewById(R.id.btn_11);
        b12 = view.findViewById(R.id.btn_12);
        b13 = view.findViewById(R.id.btn_13);
        b14 = view.findViewById(R.id.btn_14);
        b15 = view.findViewById(R.id.btn_15);
        b21 = view.findViewById(R.id.btn_21);
        b22 = view.findViewById(R.id.btn_22);
        b23 = view.findViewById(R.id.btn_23);
        b24 = view.findViewById(R.id.btn_24);
        b25 = view.findViewById(R.id.btn_25);
        b31 = view.findViewById(R.id.btn_31);
        b32 = view.findViewById(R.id.btn_32);
        b33 = view.findViewById(R.id.btn_33);
        b34 = view.findViewById(R.id.btn_34);
        b35 = view.findViewById(R.id.btn_35);
        b41 = view.findViewById(R.id.btn_41);
        b42 = view.findViewById(R.id.btn_42);
        b43 = view.findViewById(R.id.btn_43);
        b44 = view.findViewById(R.id.btn_44);
        b45 = view.findViewById(R.id.btn_45);
        b51 = view.findViewById(R.id.btn_51);
        b52 = view.findViewById(R.id.btn_52);
        b53 = view.findViewById(R.id.btn_53);
        b54 = view.findViewById(R.id.btn_54);
        b55 = view.findViewById(R.id.btn_55);
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
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b14);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b15);
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
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b24);
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b25);
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
        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b34);
            }
        });
        b35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b35);
            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b41);
            }
        });
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b42);
            }
        });
        b43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b43);
            }
        });
        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b44);
            }
        });
        b45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b45);
            }
        });
        b51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b51);
            }
        });
        b52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b52);
            }
        });
        b53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b53);
            }
        });

        b54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b54);
            }
        });

        b55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b55);
            }
        });
    }
public void paint(Button b){
    if(turn)
        b.setBackgroundColor(Color.rgb(255,0,0));
    else
        b.setBackgroundColor(Color.rgb(0,0,255));
    turn=!turn;
    b.setEnabled(false);
}

}