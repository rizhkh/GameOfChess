package com.example.ahmed.chess;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import engine.Board;
import engine.Pieces;
import engine.Space;

public class ChessGame extends Chess_Board implements GameDialog.GameDialogListener {

    private Button ai;
    private Button undoButton;
    private Button draw;
    private Button resign;

    private TextView playerTurn;

    /* On start - start of the app - Player options display attributes */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chess_game_activity);

        ai = (Button) findViewById(R.id.btnAI);
        undoButton = (Button) findViewById(R.id.btnUndo);
        draw = (Button) findViewById(R.id.btnDraw);
        resign = (Button) findViewById(R.id.btnResign);

        playerTurn = (TextView) findViewById(R.id.message);

        playerTurn.setTextColor(Color.BLACK);

        setIviews();

        drawPicture();

        for (int i = 0; i < iviews.length; i++) {
            for (int j = 0; j < iviews[i].length; j++) {
                if (((i + j) % 2) == 0) {
                    iviews[i][j].getImageView().setBackgroundColor(getResources().getColor(R.color.aqua)/*Color.GRAY*/);
                } else {
                    iviews[i][j].getImageView().setBackgroundColor(getResources().getColor(R.color.Blue)/*Color.WHITE*/);
                }

                //set up engine board
                board.fillBoard2();

                iviews[i][j].getImageView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int index = v.getId();
                        onClickGridSub(index);
                        if (undoButton.isClickable() == false)
                            undoButton.setClickable(true);
                    }
                });
            }
        }

        playerTurn.setText(player());

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDidUndo()){
                    Toast.makeText(getApplicationContext(), "Already used undo feature", Toast.LENGTH_SHORT);
                }else{
                    undoMove();
                    setDidUndo(true);
                    playerTurn.setText(player());
                }
            }
        });

        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aiButton();
                playerTurn.setText(player());
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(1);
            }
        });

        resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(2);
            }
        });
    }


    /* Displays interactive dialogs for notifications in-game */
    public void openDialog(int type){
        if (type == 0){
            //game winner, save request

            if (board.isKingDead()){
                if (board.getKingKiller() == 0){
                    //white winner
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        builder = new AlertDialog.Builder(ChessGame.this, android.R.style.Theme_Material_Dialog_Alert);
                    else {
                        builder = new AlertDialog.Builder(getApplicationContext());
                    }
                    builder.setTitle("Game Over")
                            .setMessage("White Wins! Do you Want to save this game?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //
                                    GameDialog gameDialog = new GameDialog();
                                    gameDialog.show(getSupportFragmentManager(), "display winner");
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                    Intent intent = new Intent(ChessGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else{
                    //black winner
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        builder = new AlertDialog.Builder(ChessGame.this, android.R.style.Theme_Material_Dialog_Alert);
                    else {
                        builder = new AlertDialog.Builder(getApplicationContext());
                    }
                    builder.setTitle("Game Over")
                            .setMessage("Black Wins! Do you Want to save this game?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //
                                    GameDialog gameDialog = new GameDialog();
                                    gameDialog.show(getSupportFragmentManager(), "display winner");
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                    Intent intent = new Intent(ChessGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        }else if (type == 1){
            //draw
            //2nd Alert Dialog
            AlertDialog.Builder alertDialogBuilderSuccess = new AlertDialog.Builder(
                    ChessGame.this);
            alertDialogBuilderSuccess.setTitle("Game Over");
            // set dialog message

            alertDialogBuilderSuccess
                    .setMessage(
                            "Game ended in draw! " + "Would you like to save this game?")
                    .setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    GameDialog gameDialog = new GameDialog();
                                    gameDialog.show(getSupportFragmentManager(), "display winner");
                                }
                            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(ChessGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                    );

            // create alert dialog
            final AlertDialog alertDialogSuccess = alertDialogBuilderSuccess.create();

            //////////////////////////////////
            //1st Alert
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    ChessGame.this);
            alertDialogBuilder.setTitle("Draw Request");
            // set dialog message
            alertDialogBuilder
                    .setMessage("Opponent has requested draw. Do you accept?")
                    .setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {

                                    //calling the second alert when it user press the confirm button
                                    alertDialogSuccess.show();
                                }
                            })
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    if (isWhite()){
                                        setIsWhite(false);
                                    }else{
                                        setIsWhite(true);
                                    }

                                    playerTurn.setText(player());
                                    dialog.cancel();
                                }
                            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }else if (type == 2){
            //resign

            String player = "";
            if (isWhite())
                player+="White Resigned! ";
            else
                player+= "Black Resigned! ";

            //2nd Alert Dialog
            AlertDialog.Builder alertDialogBuilderSuccess = new AlertDialog.Builder(
                    ChessGame.this);
            alertDialogBuilderSuccess.setTitle("Game Over");
            // set dialog message
            alertDialogBuilderSuccess
                    .setMessage(
                            player + "Would you like to save this game?")
                    .setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    GameDialog gameDialog = new GameDialog();
                                    gameDialog.show(getSupportFragmentManager(), "display winner");
                                }
                            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(ChessGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                    );

            // create alert dialog
            final AlertDialog alertDialogSuccess = alertDialogBuilderSuccess.create();

            //////////////////////////////////
            //1st Alert
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    ChessGame.this);
            alertDialogBuilder.setTitle("Resign");
            // set dialog message
            alertDialogBuilder
                    .setMessage("Are you sure you want to resign?")
                    .setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {

                                    //calling the second alert when it user press the confirm button
                                    alertDialogSuccess.show();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    if (isWhite()){
                                        setIsWhite(false);
                                    }else{
                                        setIsWhite(true);
                                    }

                                    playerTurn.setText(player());
                                    dialog.cancel();
                                }
                            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
    }

    /* Selection of piece on board */
    public void onClickGridSub(int index){
        onClickGrid(index);
        playerTurn.setText(player());
    }

    //sets the player turn
    public String player(){
        String player = "Player: ";
        if (isWhite()){
            player+= "White";
        }else{
            player+= "Black";
        }
        return player;
    }

    /* Undo option for the move */
    public void undoMove(){
        if (undo.isSet()){
            setBoardUndo(undo.getSpace1(), undo.getSpace2());
        }
    }

    /* Updates the board after the undo option */
    public void setBoardUndo(Space s1, Space s2){
        Board.board2[s1.getX()][s1.getY()] = s2;
        Board.board2[s2.getX()][s2.getY()] = s1;
        int x1 = s1.getX();
        int x2 = s2.getX();
        int y1 = s1.getY();
        int y2 = s2.getY();

        Board.board2[x1][y1].setX(x1);
        Board.board2[x1][y1].setY(y1);
        Board.board2[x1][y1].getPiece().setX(x1);
        Board.board2[x1][y1].getPiece().setY(y1);

        Board.board2[x2][y2].setX(x2);
        Board.board2[x2][y2].setY(y2);
        Board.board2[x2][y2].getPiece().setX(x2);
        Board.board2[x2][y2].getPiece().setY(y2);

        drawImage(Board.board2[x1][y1].getX(), Board.board2[x1][y1].getY(), Board.board2[x2][y2].getX(), Board.board2[x2][y2].getY());
        undo.flushUndo();

        if (isWhite())
            setIsWhite(false);
        else
            setIsWhite(true);

        playerTurn.setText(player());

    }

    /* Turn taken through AI playset */
    public void aiButton(){
        List<Pieces> piecesInPlay;
        int color = 0;
        if (isWhite()){
            //white turn
            color = 0;
            piecesInPlay = board.getWhiteInPlay();
        }else{
            //black turn
            color = 1;
            piecesInPlay = board.getBlackInPlay();
        }

        for (Pieces x : piecesInPlay){
            List<Integer> moves = board.getAIMoves(x);

            for (int i = 0; i < moves.size(); i+=2){

                movePiece(x.getX(), x.getY(), moves.get(i), moves.get(i+1));

                if (color == 0 && isWhite()){
                    //player did not change (white), move is invalid
                    continue;
                }else if (color == 1 && !isWhite()){
                    //player did not change (black), move is invalid
                    continue;
                }else{
                    //move is valid, no more checking
                    //have to set new x and y for pieces in array
                    x.setX(moves.get(i));
                    x.setY(moves.get(i+1));
                    return;
                }
            }
        }
    }


    @Override
    public void applyTexts(String fileName) throws IOException {
        //take fileName and save the game

        ///first will save fileName in a list of fileNames
            //these fileNames will be displayed in the Replay Activity

        String FILE_NAME = fileName;
        FileOutputStream fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getMoves());
        fos.close();
        oos.close();
    }
}
