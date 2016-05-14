package daman.com.foodfriends;

import android.app.ActionBar;
import android.app.Activity;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Descrip extends Activity {
    public static final String EXTRA_FOODNO = "foodNo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descrip);
        ActionBar actionBar = getActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
//Get the drink from the intent
        int foodNo = (Integer)getIntent().getExtras().get(EXTRA_FOODNO);
//Create a cursor
        try {
            SQLiteOpenHelper Dbhelp = new Dbhelp(this);
            SQLiteDatabase db = Dbhelp.getReadableDatabase();
            Cursor cursor = db.query ("FOODTABLE",
                    new String[] {"NAME", "DESCRIPTION"},
                    "_id = ?",
                    new String[] {Integer.toString(foodNo)},
                    null, null,null);
            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {
//Get the drink details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);

//Populate the drink name
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);
//Populate the drink description
                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);
            }
            cursor.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_settings was selected
            case R.id.action_settings:
                Intent intent = new Intent(Descrip.this, Credits.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}