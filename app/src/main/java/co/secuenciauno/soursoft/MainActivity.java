package co.secuenciauno.soursoft;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    FragmentManager fragmentManager;
    FragmentCategoria fragmentStep0;
    FragmentMapa fragmentStep1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentStep0 = new FragmentCategoria();
        fragmentStep1 = new FragmentMapa();

        fragmentTransaction.add(R.id.rl_fragment_problema, fragmentStep0);
        fragmentTransaction.add(R.id.rl_fragment_problema, fragmentStep1);

        fragmentTransaction.show(fragmentStep0);
        fragmentTransaction.hide(fragmentStep1);

        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
