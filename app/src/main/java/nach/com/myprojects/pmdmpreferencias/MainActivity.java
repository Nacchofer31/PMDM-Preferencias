package nach.com.myprojects.pmdmpreferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, PreferencesActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if(pref != null) {
            tv1.setText(pref.getString("opcion1", ""));
            switch (pref.getString("colorFondo", "")) {
                case "rojo":
                    tv1.setBackgroundColor(getResources().getColor(R.color.rojo));
                    break;
                case "amarillo":
                    tv1.setBackgroundColor(getResources().getColor(R.color.yellow));
                    break;
                case "verde":
                    tv1.setBackgroundColor(getResources().getColor(R.color.verde));
                    break;
            }

            switch (pref.getString("colorLetra","")){
                case "blanco":
                    texto.setTextColor(getResources().getColor(R.color.blanco));
                    break;
                case "negro":
                    texto.setTextColor(getResources().getColor(R.color.negro));
                    break;
                case "azul":
                    texto.setTextColor(getResources().getColor(R.color.azul));
                    break;
            }
        }
        super.onResume();
    }
}
