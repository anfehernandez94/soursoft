package co.secuenciauno.soursoft;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;

public class ActivityMain extends AppCompatActivity {

    FragmentManager fragmentManager;
    EditText etSearch;
    ImageButton ibtnSearch;


    FragmentCategoria fragmentCategoria = new FragmentCategoria();
    FragmentMapa fragmentMapa = new FragmentMapa();
    FragmentListCategoria fragmentListCategoria = new FragmentListCategoria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibtnSearch = (ImageButton)findViewById(R.id.ibtn_search);
        etSearch = (EditText)findViewById(R.id.et_search);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentCategoria);
        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentMapa);
        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentListCategoria);

        fragmentTransaction.show(fragmentCategoria);
        fragmentTransaction.hide(fragmentMapa);
        fragmentTransaction.hide(fragmentListCategoria);

        fragmentTransaction.commit();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("Categorias"));
        tabLayout.addTab(tabLayout.newTab().setText("Mapa"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                        goToFragment(fragmentMapa, fragmentCategoria);
                }else{
                    if(fragmentCategoria.isVisible())
                        goToFragment(fragmentCategoria, fragmentMapa);
                    else if(fragmentListCategoria.isVisible())
                        goToFragment(fragmentListCategoria, fragmentMapa);
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

    public void changeCategory(String categoria){
        fragmentListCategoria.tvCategoria.setText(categoria);
        goToFragment(fragmentCategoria, fragmentListCategoria);
    }


    @Override
    public void onBackPressed() {
        if (fragmentListCategoria.isVisible()) {
            goToFragment(fragmentListCategoria, fragmentCategoria);
            return;
        }
        finish();
    }
}
