package com.example.brandon.learning;

import android.app.AlertDialog;
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

    //Opens up the test page activity
    public void createWorkout(View view){

        //NEED TO PUT EXTRA THE THING THAT WE ENTER
        EditText editText = (EditText) findViewById(R.id.nameWorkout);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, CreateWorkoutActivity.class).putExtra("asdf", message);

        //workOutNameDialog();

        startActivity(intent);
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
