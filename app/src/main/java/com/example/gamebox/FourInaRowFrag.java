package com.example.gamebox;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


public class FourInaRowFrag extends Fragment {

    private static final String BUNDLE_COLORED_CELLS = "colored cells";
    public static final String BUNDLE_TURN = "turn";
    public static final String BUNDLE_GAME_RUNNING_STATE = "game running state";
    private Button b11, b12, b13, b14, b15, b21, b22, b23, b24, b25, b31, b32, b33, b34, b35,
            b41, b42, b43, b44, b45, b51, b52, b53, b54, b55;
    private boolean turn = true;
    private boolean gameRun = true;
    int[][] arr = new int[11][11];


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
        disableButtons();
        b51.setEnabled(true);
        b52.setEnabled(true);
        b53.setEnabled(true);
        b54.setEnabled(true);
        b55.setEnabled(true);
        if (savedInstanceState != null) {
            turn = savedInstanceState.getBoolean(BUNDLE_TURN);
            gameRun = savedInstanceState.getBoolean(BUNDLE_GAME_RUNNING_STATE);
            arr = (int[][]) savedInstanceState.getSerializable(BUNDLE_COLORED_CELLS);
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    if (arr[i][j] == 1) {
                        relateBtn(i, j).setBackgroundColor(Color.rgb(0, 0, 255));
                        relateBtn(i, j).setEnabled(false);
                        if (i != 3 && arr[i - 1][j] == 0)
                            relateBtn(i - 1, j).setEnabled(true);
                    } else if (arr[i][j] == -1) {
                        relateBtn(i, j).setBackgroundColor(Color.rgb(255, 0, 0));
                        relateBtn(i, j).setEnabled(false);
                        if (i != 3 && arr[i - 1][j] == 0)
                            relateBtn(i - 1, j).setEnabled(true);
                    }
                }
            }
        }
        if (!gameRun)
            disableButtons();
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
                paint(b11, 1 + 2, 1 + 2);
                if (isWinner(1 + 2, 1 + 2))
                    gameFinished(1 + 2, 1 + 2);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b12, 1 + 2, 2 + 2);
                if (isWinner(1 + 2, 2 + 2))
                    gameFinished(1 + 2, 2 + 2);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b13, 1 + 2, 3 + 2);
                if (isWinner(1 + 2, 3 + 2))
                    gameFinished(1 + 2, 3 + 2);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b14, 1 + 2, 4 + 2);
                if (isWinner(1 + 2, 4 + 2))
                    gameFinished(1 + 2, 4 + 2);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b15, 1 + 2, 5 + 2);
                if (isWinner(1 + 2, 5 + 2))
                    gameFinished(1 + 2, 5 + 2);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b21, 2 + 2, 1 + 2);
                b11.setEnabled(true);
                if (isWinner(2 + 2, 1 + 2)) {
                    gameFinished(2 + 2, 1 + 2);
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b22, 2 + 2, 2 + 2);
                b12.setEnabled(true);
                if (isWinner(2 + 2, 2 + 2)) {
                    gameFinished(2 + 2, 2 + 2);
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b23, 2 + 2, 3 + 2);
                b13.setEnabled(true);
                if (isWinner(2 + 2, 3 + 2)) {
                    gameFinished(2 + 2, 3 + 2);
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b24, 2 + 2, 4 + 2);
                b14.setEnabled(true);
                if (isWinner(2 + 2, 4 + 2)) {
                    gameFinished(2 + 2, 4 + 2);
                }
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b25, 2 + 2, 5 + 2);
                b15.setEnabled(true);
                if (isWinner(2 + 2, 5 + 2)) {
                    gameFinished(2 + 2, 5 + 2);
                }
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b31, 3 + 2, 1 + 2);
                b21.setEnabled(true);
                if (isWinner(3 + 2, 1 + 2)) {
                    gameFinished(3 + 2, 1 + 2);
                }
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b32, 3 + 2, 2 + 2);
                b22.setEnabled(true);
                if (isWinner(3 + 2, 2 + 2)) {
                    gameFinished(3 + 2, 2 + 2);
                }
            }
        });
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b33, 3 + 2, 3 + 2);
                b23.setEnabled(true);
                if (isWinner(3 + 2, 3 + 2)) {
                    gameFinished(3 + 2, 3 + 2);
                }
            }
        });
        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b34, 3 + 2, 4 + 2);
                b24.setEnabled(true);
                if (isWinner(3 + 2, 4 + 2)) {
                    gameFinished(3 + 2, 4 + 2);
                }
            }
        });
        b35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b35, 3 + 2, 5 + 2);
                b25.setEnabled(true);
                if (isWinner(3 + 2, 5 + 2)) {
                    gameFinished(3 + 2, 5 + 2);
                }
            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b41, 4 + 2, 1 + 2);
                b31.setEnabled(true);
                if (isWinner(4 + 2, 1 + 2)) {
                    gameFinished(4 + 2, 1 + 2);
                }
            }
        });
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b42, 4 + 2, 2 + 2);
                b32.setEnabled(true);
                if (isWinner(4 + 2, 2 + 2)) {
                    gameFinished(4 + 2, 2 + 2);
                }
            }
        });
        b43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b43, 4 + 2, 3 + 2);
                b33.setEnabled(true);
                if (isWinner(4 + 2, 3 + 2)) {
                    gameFinished(4 + 2, 3 + 2);
                }
            }
        });
        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b44, 4 + 2, 4 + 2);
                b34.setEnabled(true);
                if (isWinner(4 + 2, 4 + 2)) {
                    gameFinished(4 + 2, 4 + 2);
                }
            }
        });
        b45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b45, 4 + 2, 5 + 2);
                b35.setEnabled(true);
                if (isWinner(4 + 2, 5 + 2)) {
                    gameFinished(4 + 2, 5 + 2);
                }
            }
        });
        b51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b51, 5 + 2, 1 + 2);
                b41.setEnabled(true);
                if (isWinner(5 + 2, 1 + 2)) {
                    gameFinished(5 + 2, 1 + 2);
                }
            }
        });
        b52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b52, 5 + 2, 2 + 2);
                b42.setEnabled(true);
                if (isWinner(5 + 2, 2 + 2)) {
                    gameFinished(5 + 2, 2 + 2);
                }
            }
        });
        b53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b53, 5 + 2, 3 + 2);
                b43.setEnabled(true);
                if (isWinner(5 + 2, 3 + 2)) {
                    gameFinished(5 + 2, 3 + 2);
                }
            }
        });
        b54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b54, 5 + 2, 4 + 2);
                b44.setEnabled(true);
                if (isWinner(5 + 2, 4 + 2)) {
                    gameFinished(5 + 2, 4 + 2);
                }
            }
        });
        b55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint(b55, 5 + 2, 5 + 2);
                b45.setEnabled(true);
                if (isWinner(5 + 2, 5 + 2)) {
                    gameFinished(5 + 2, 5 + 2);
                }
            }
        });
    }

    private void paint(Button bt, int a, int b) {
        if (turn) {
            bt.setBackgroundColor(Color.rgb(255, 0, 0));
            arr[a][b] = -1;
        } else {
            bt.setBackgroundColor(Color.rgb(0, 0, 255));
            arr[a][b] = 1;
        }
        turn = !turn;
        bt.setEnabled(false);
    }

    private boolean isWinner(int a, int b) {
        int i = arr[a][b];
        if ((i == arr[a][b + 1] && i == arr[a][b - 1]) && (i == arr[a][b - 2] || i == arr[a][b + 2]))
            return true;
        else if ((i == arr[a + 1][b] && i == arr[a - 1][b]) && (i == arr[a - 2][b] || i == arr[a + 2][b]))
            return true;
        else if ((i == arr[a + 1][b - 1] && i == arr[a - 1][b + 1]) && (i == arr[a + 2][b - 2] || i == arr[a - 2][b + 2]))
            return true;
        else if ((i == arr[a - 1][b - 1] && i == arr[a + 1][b + 1]) && (i == arr[a + 2][b + 2] || i == arr[a - 2][b - 2]))
            return true;
        else if (i + arr[a - 1][b] + arr[a - 2][b] + arr[a - 3][b] == 4 || i + arr[a - 1][b] + arr[a - 2][b] + arr[a - 3][b] == -4)
            return true;
        else if (i + arr[a + 1][b] + arr[a + 2][b] + arr[a + 3][b] == 4 || i + arr[a + 1][b] + arr[a + 2][b] + arr[a + 3][b] == -4)
            return true;
        else if (i + arr[a][b + 1] + arr[a][b + 2] + arr[a][b + 3] == 4 || i + arr[a][b + 1] + arr[a][b + 2] + arr[a][b + 3] == -4)
            return true;
        else if (i + arr[a][b - 1] + arr[a][b - 2] + arr[a][b - 3] == 4 || i + arr[a][b - 1] + arr[a][b - 2] + arr[a][b - 3] == -4)
            return true;
        else if (i + arr[a + 1][b + 1] + arr[a + 2][b + 2] + arr[a + 3][b + 3] == 4 || i + arr[a + 1][b + 1] + arr[a + 2][b + 2] + arr[a + 3][b + 3] == -4)
            return true;
        else if (i + arr[a - 1][b - 1] + arr[a - 2][b - 2] + arr[a - 3][b - 3] == 4 || i + arr[a - 1][b - 1] + arr[a - 2][b - 2] + arr[a - 3][b - 3] == -4)
            return true;
        else if (i + arr[a + 1][b - 1] + arr[a + 2][b - 2] + arr[a + 3][b - 3] == 4 || i + arr[a + 1][b - 1] + arr[a + 2][b - 2] + arr[a + 3][b - 3] == -4)
            return true;
        else if (i + arr[a - 1][b + 1] + arr[a - 2][b + 2] + arr[a - 3][b + 3] == 4 || i + arr[a - 1][b + 1] + arr[a - 2][b + 2] + arr[a - 3][b + 3] == -4)
            return true;
        else
            return false;
    }

    private void gameFinished(int a, int b) {
        String s;
        if (arr[a][b] == 1)
            s = "BLUE";
        else
            s = "RED";
        Snackbar.make(getActivity().findViewById(R.id.game_container),
                s + " won the game !!", Snackbar.LENGTH_LONG)
                .show();
        disableButtons();
        gameRun = false;
    }

    private void disableButtons() {
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b14.setEnabled(false);
        b15.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);
        b23.setEnabled(false);
        b24.setEnabled(false);
        b25.setEnabled(false);
        b31.setEnabled(false);
        b32.setEnabled(false);
        b33.setEnabled(false);
        b34.setEnabled(false);
        b35.setEnabled(false);
        b41.setEnabled(false);
        b42.setEnabled(false);
        b43.setEnabled(false);
        b44.setEnabled(false);
        b45.setEnabled(false);
        b51.setEnabled(false);
        b52.setEnabled(false);
        b53.setEnabled(false);
        b54.setEnabled(false);
        b55.setEnabled(false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(BUNDLE_COLORED_CELLS, arr);
        outState.putBoolean(BUNDLE_GAME_RUNNING_STATE, gameRun);
        outState.putBoolean(BUNDLE_TURN, turn);
    }

    private Button relateBtn(int a, int b) {
        String s = "" + (a - 2) + (b - 2);
        switch (s) {
            case "11":
                return b11;
            case "12":
                return b12;
            case "13":
                return b13;
            case "14":
                return b14;
            case "15":
                return b15;
            case "21":
                return b21;
            case "22":
                return b22;
            case "23":
                return b23;
            case "24":
                return b24;
            case "25":
                return b25;
            case "31":
                return b31;
            case "32":
                return b32;
            case "33":
                return b33;
            case "34":
                return b34;
            case "35":
                return b35;
            case "41":
                return b41;
            case "42":
                return b42;
            case "43":
                return b43;
            case "44":
                return b44;
            case "45":
                return b45;
            case "51":
                return b51;
            case "52":
                return b52;
            case "53":
                return b53;
            case "54":
                return b54;
            case "55":
                return b55;
            default:
                return null;
        }
    }
}