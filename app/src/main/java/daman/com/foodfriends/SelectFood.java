package daman.com.foodfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * Created by DELL on 12-May-16.
 */
public class SelectFood extends Activity{

    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String cat="PUNJABI";
                Intent intent = new Intent(context, FoodList.class);
                intent.putExtra("CHOICE",cat);
                startActivity(intent);

            }

        });

        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String cat="SOUTH INDIAN";
                Intent intent = new Intent(context, FoodList.class);
                intent.putExtra("CHOICE",cat);
                startActivity(intent);

            }

        });

        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String cat="GUJRATI";
                Intent intent = new Intent(context, FoodList.class);
                intent.putExtra("CHOICE",cat);
                startActivity(intent);

            }

        });

        button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String cat="STREET FOOD";
                Intent intent = new Intent(context, FoodList.class);
                intent.putExtra("CHOICE",cat);
                startActivity(intent);

            }

        });

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
                Intent intent = new Intent(SelectFood.this, Credits.class);
                startActivity(intent);

                break;
            default:
                break;
        }

        return true;
    }
}
