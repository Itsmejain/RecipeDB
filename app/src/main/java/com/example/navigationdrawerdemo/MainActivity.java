package com.example.navigationdrawerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.draw_layout);

        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListner);
        navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



//        getSupportFragmentManager().beginTransaction().
//                replace(R.id.fragment_container,new HomeFragment()).commit();

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }
    private NavigationBarView.OnItemSelectedListener navListner =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_visual_search:
                            selectedFragment = new VisualSearchFragment();
//                            Toast.makeText(MainActivity.this, "VIS SEARCh", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_statistics:
                            selectedFragment = new StatisticsFragment();
//                            Toast.makeText(MainActivity.this, "STATS", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,selectedFragment)
                            .commit();
                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,new HomeFragment())
                        .commit();
                break;
            case R.id.nav_how_to_use:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,new HowToUseFragment())
                        .commit();
                break;
            case R.id.nav_faq:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,new FaqFragment())
                        .commit();
                break;
            case R.id.nav_contactus:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,new ContactUsFragment())
                        .commit();
                break;
            case R.id.nav_cosylab:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,new CosylabsFragment())
                        .commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);        return true;
    }
}