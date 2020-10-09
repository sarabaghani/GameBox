package com.example.gamebox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class TicTacToeFrag extends Fragment {
    public static final String BUNDLE_GAME_RUNNING_STATE = "game running state";
    public static final String BUNDLE_TURN = "bundle turn";
    public static final String BUNDLE_B_11_TAG = "bundle b11 tag";
    private static final String BUNDLE_B_12_TAG = "bundle b12 tag";
    private static final String BUNDLE_B_13_TAG = "bundle b13 tag";
    private static final String BUNDLE_B_33_TAG = "bundle b33 tag";
    private static final String BUNDLE_B_23_TAG = "bundle b23 tag";
    private static final String BUNDLE_B_21_TAG = "bundle b21 tag";
    private static final String BUNDLE_B_22_TAG = "bundle b22 tag";
    private static final String BUNDLE_B_31_TAG = "bundle b31 tag";
    private static final String BUNDLE_B_32_TAG = "bundle b32 tag";
    private ImageButton b11, b12, b13, b21, b22, b23, b31, b32, b33;
    boolean turn = true;
    boolean gameRun = true;

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
        if (savedInstanceState != null) {
            turn = savedInstanceState.getBoolean(BUNDLE_TURN);
            gameRun = savedInstanceState.getBoolean(BUNDLE_GAME_RUNNING_STATE);
            getSavedImage(savedInstanceState,BUNDLE_B_11_TAG,b11);
            getSavedImage(savedInstanceState,BUNDLE_B_12_TAG,b12);
            getSavedImage(savedInstanceState,BUNDLE_B_13_TAG,b13);
            getSavedImage(savedInstanceState,BUNDLE_B_21_TAG,b21);
            getSavedImage(savedInstanceState,BUNDLE_B_22_TAG,b22);
            getSavedImage(savedInstanceState,BUNDLE_B_23_TAG,b23);
            getSavedImage(savedInstanceState,BUNDLE_B_31_TAG,b31);
            getSavedImage(savedInstanceState,BUNDLE_B_32_TAG,b32);
            getSavedImage(savedInstanceState,BUNDLE_B_33_TAG,b33);
        }
        if (!gameRun)
            disableBtns();
        return view;
    }

    private void getSavedImage(Bundle savedInstanceState,String s, ImageButton b) {
        if (savedInstanceState.getInt(s) != 0) {
            b.setTag(savedInstanceState.getInt(s));
            b.setImageResource((int) b.getTag());
        }
    }

    private void findViews(View view) {
        b11 = view.findViewById(R.id.ib_11);
        b12 = view.findViewById(R.id.ib_12);
        b13 = view.findViewById(R.id.ib_13);
        b21 = view.findViewById(R.id.ib_21);
        b22 = view.findViewById(R.id.ib_22);
        b23 = view.findViewById(R.id.ib_23);
        b31 = view.findViewById(R.id.ib_31);
        b32 = view.findViewById(R.id.ib_32);
        b33 = view.findViewById(R.id.ib_33);

    }

    private void setListeners() {
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b11);
                if (upperHorizon() || upLeftOblique() || leftCol())
                    isWinner(b11);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b12);
                if (upperHorizon() || middleCol())
                    isWinner(b12);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b13);
                if (upRightOblique() || upperHorizon() || rightCol())
                    isWinner(b13);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b21);
                if (leftCol() || middleHorizon())
                    isWinner(b21);
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b22);
                if (middleCol() || middleHorizon() || upRightOblique() || upLeftOblique())
                    isWinner(b22);
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b23);
                if (rightCol() || middleHorizon())
                    isWinner(b23);
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b31);
                if (leftCol() || upRightOblique() || lowerHorizon())
                    isWinner(b31);
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b32);
                if (lowerHorizon() || middleCol())
                    isWinner(b32);
            }
        });
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b33);
                if (upLeftOblique() || rightCol() || lowerHorizon())
                    isWinner(b33);
            }
        });

    }


    private void paint(ImageButton x) {
        if (turn) {
            x.setImageResource(R.drawable.cross);
            x.setTag(R.drawable.cross);
        } else {
            x.setImageResource(R.drawable.circle);
            x.setTag(R.drawable.circle);
        }
        turn = !turn;
        x.setEnabled(false);
    }

    private void isWinner(ImageButton x) {
        String s;
        if ((int) x.getTag() == R.drawable.cross)
            s = "X";
        else
            s = "O";
        disableBtns();

        Snackbar.make(getActivity().findViewById(R.id.game_container),
                s + " won the game !!", Snackbar.LENGTH_LONG)
                .show();
        gameRun = false;
    }

    private void disableBtns() {
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);
        b23.setEnabled(false);
        b31.setEnabled(false);
        b32.setEnabled(false);
        b33.setEnabled(false);
    }

    private boolean upperHorizon() {
        boolean flag = false;
        Integer res;
        if ((Integer) b11.getTag() == null)
            return false;
        else
            res = (Integer) b11.getTag();
        if ((Integer) b12.getTag() != null && ((Integer) b13.getTag()) != null &&
                res.equals((Integer) b12.getTag()) && res.equals((Integer) b13.getTag()))
            flag = true;
        return flag;
    }

    private boolean lowerHorizon() {
        boolean flag = false;
        Integer res;
        if ((Integer) b31.getTag() == null)
            return false;
        else
            res = (Integer) b31.getTag();
        if ((Integer) b32.getTag() != null && (Integer) b33.getTag() != null &&
                res.equals((Integer) b32.getTag()) && res.equals((Integer) b33.getTag()))
            flag = true;
        return flag;
    }

    private boolean middleHorizon() {
        boolean flag = false;
        Integer res;
        if ((Integer) b21.getTag() == null)
            return false;
        else
            res = (Integer) b21.getTag();
        if ((Integer) b22.getTag() != null && (Integer) b23.getTag() != null &&
                res.equals((Integer) b22.getTag()) && res.equals((Integer) b23.getTag()))
            flag = true;
        return flag;
    }

    private boolean rightCol() {
        boolean flag = false;
        Integer res;
        if ((Integer) b13.getTag() == null)
            return false;
        else
            res = (Integer) b13.getTag();
        if ((Integer) b23.getTag() != null && (Integer) b33.getTag() != null &&
                res.equals((Integer) b23.getTag()) && res.equals((Integer) b33.getTag()))
            flag = true;
        return flag;
    }

    private boolean leftCol() {
        boolean flag = false;
        Integer res;
        if ((Integer) b11.getTag() == null)
            return false;
        else
            res = (Integer) b11.getTag();
        if ((Integer) b21.getTag() != null && (Integer) b31.getTag() != null &&
                res.equals((Integer) b21.getTag()) && res.equals((Integer) b31.getTag()))
            flag = true;
        return flag;
    }

    private boolean middleCol() {
        boolean flag = false;
        Integer res;
        if ((Integer) b12.getTag() == null)
            return false;
        else
            res = (Integer) b12.getTag();
        if ((Integer) b22.getTag() != null && (Integer) b32.getTag() != null &&
                res.equals((Integer) b22.getTag()) && res.equals((Integer) b32.getTag()))
            flag = true;
        return flag;
    }

    private boolean upRightOblique() {
        boolean flag = false;
        Integer res;
        if ((Integer) b13.getTag() == null)
            return false;
        else
            res = (Integer) b13.getTag();
        if ((Integer) b22.getTag() != null && (Integer) b31.getTag() != null &&
                res.equals((Integer) b22.getTag()) && res.equals((Integer) b31.getTag()))
            flag = true;
        return flag;
    }

    private boolean upLeftOblique() {
        boolean flag = false;
        Integer res;
        if ((Integer) b11.getTag() == null)
            return false;
        else
            res = (Integer) b11.getTag();
        if ((Integer) b22.getTag() != null && (Integer) b33.getTag() != null &&
                res.equals((Integer) b22.getTag()) && res.equals((Integer) b33.getTag()))
            flag = true;
        return flag;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(BUNDLE_GAME_RUNNING_STATE, gameRun);
        outState.putBoolean(BUNDLE_TURN, turn);
        saveImageState(outState,b11,BUNDLE_B_11_TAG);
        saveImageState(outState,b12,BUNDLE_B_12_TAG);
        saveImageState(outState,b13,BUNDLE_B_13_TAG);
        saveImageState(outState,b21,BUNDLE_B_21_TAG);
        saveImageState(outState,b22,BUNDLE_B_22_TAG);
        saveImageState(outState,b23,BUNDLE_B_23_TAG);
        saveImageState(outState,b31,BUNDLE_B_31_TAG);
        saveImageState(outState,b32,BUNDLE_B_32_TAG);
        saveImageState(outState,b33,BUNDLE_B_33_TAG);

    }

    private void saveImageState(@NonNull Bundle outState, ImageButton b,String s) {
        if(b.getTag()!=null)
        outState.putInt(s, (int) b.getTag());
    }
}