package co.secuenciauno.soursoft;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentCategoria fragmentStep0;
        final FragmentMapa fragmentStep1;

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentStep0 = new FragmentCategoria();
        fragmentStep1 = new FragmentMapa();

        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentStep0);
        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentStep1);

        fragmentTransaction.show(fragmentStep0);
        fragmentTransaction.hide(fragmentStep1);

        fragmentTransaction.commit();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("Categorias"));
        tabLayout.addTab(tabLayout.newTab().setText("Mapa"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    goToFragment(fragmentStep1, fragmentStep0);
                }else{
                    goToFragment(fragmentStep0, fragmentStep1);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


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

    private void goToFragment(Fragment hide, Fragment show) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(show);
        fragmentTransaction.hide(hide);
        fragmentTransaction.commit();
    }
}
