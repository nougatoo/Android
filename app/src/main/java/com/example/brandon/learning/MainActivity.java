package com.example.brandon.learning;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import WorkoutFiles.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.firstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(item.getItemId())
        {
            case R.id.action_search:
                    //openSearch();
                    return true;
            case R.id.action_settings:
                    openSettings();
                    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Called when the clicks the send app
    public void sendMessage(View view){


        //Intent intent = new Intent(this, DisplayMessageAcivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);

        //startActivity(intent);
    }

    //Called when the clicks the send app
    public void openSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);

        startActivity(intent);
    }

    //Opens up the test page activity
    public void openTestPage(View view){
        Intent intent = new Intent(this, GridTesterActivity.class);

        startActivity(intent);
    }

    //Creates a workout object and goes to the page
    public void createWorkout(View view) throws IOException {

        new AlertDialog.Builder(this)
                .setTitle("Create New Workout")
                .setMessage("This will erase your old workout")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Creating a new workout object
                        Workout newWorkout = new Workout();
                        newWorkout.setNamme("Dickfondler");

                        //Create the Activity
                        EditText editText = (EditText) findViewById(R.id.nameWorkout);
                        String message = editText.getText().toString();
                        newWorkout.setNamme(message);
                        Intent intent = new Intent(getApplicationContext(), CreateWorkoutActivity.class);

                        try {
                            //Settuping Creating a new file
                            FileOutputStream outputStream;
                            FileOutputStream fos = openFileOutput("WorkoutPage", Context.MODE_PRIVATE);
                            ObjectOutputStream os = new ObjectOutputStream(fos);
                            os.writeObject(newWorkout);
                            os.close();
                            fos.close();

                            startActivity(intent);
                        }
                        catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        return;
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();



    }

    public String workOutNameDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please enter a name for you workout");
        String m_Text = "";

        final EditText input = new EditText(this);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String value = input.getText().toString();
                return;
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

        return m_Text;
    }
}
