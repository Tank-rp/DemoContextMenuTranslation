package sg.edu.rp.c346.id20022678.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String worldClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText);

        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        if (v == tvTranslatedText){
            worldClicked = "hello";
        }
        else if(v == tvTranslatedText2){
            worldClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()== 0 ) {
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            if (worldClicked.equalsIgnoreCase("hello")){
                tvTranslatedText.setText("Hello");
            }
            else if (worldClicked.equalsIgnoreCase("bye")){
                tvTranslatedText.setText("Bye");
            }
            return true;
        }
        else if(item.getItemId()== 1 ) {
            Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
            if (worldClicked.equalsIgnoreCase("hello")) {
                tvTranslatedText.setText("Ciao");
            } else if (worldClicked.equalsIgnoreCase("bye")) {
                tvTranslatedText.setText("Addio");
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }


}