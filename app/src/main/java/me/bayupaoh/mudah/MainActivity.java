package me.bayupaoh.mudah;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.bayupaoh.mudah.Fragment.HalalFragment;
import me.bayupaoh.mudah.Fragment.KursAsingFragment;

public class MainActivity extends AppCompatActivity {
    
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declarationWidget();
        setToolbar();
        settingNavBar();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void settingNavBar() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.container_body, new HalalFragment()).commit();


        navigationView.setNavigationItemSelectedListener(navItemSelect);
    }

    private void declarationWidget() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.fragment_navigation_drawer);
    }

    NavigationView.OnNavigationItemSelectedListener navItemSelect = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {

            menuItem.setCheckable(true);
            FragmentManager fragmentManager = getSupportFragmentManager();
            drawerLayout.closeDrawer(GravityCompat.START);

            switch (menuItem.getItemId()){
                case R.id.id_menu_halal:
                    fragmentManager.beginTransaction().replace(R.id.container_body, new HalalFragment()).commit();
                    return true;
                case R.id.id_menu_bioskop:
                    return true;
                case R.id.id_menu_cuaca:
                    return true;
                case R.id.id_menu_kurs:
                    fragmentManager.beginTransaction().replace(R.id.container_body, new KursAsingFragment()).commit();
                    return true;
                case R.id.id_menu_tagihan:
                    return true;
                case R.id.id_menu_about:
                    return true;
                default:
                    return true;
            }
        }
    };
}
