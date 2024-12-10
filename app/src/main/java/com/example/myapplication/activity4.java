package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.R;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;

public class activity4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

   NavigationView navigationView;
   ActionBarDrawerToggle toogle;
   DrawerLayout drawerLayout;
   Toolbar toolbar;
   Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        /*-------------------------- Conteneurs ----------------------------*/
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        /*-------------------------- Tool Bar ----------------------------*/
        //setSupportActionBar(toolbar);
        /*-------------------------- Navigation Drawer Menu ----------------------------*/
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        navigationView.bringToFront();
        toogle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.close,R.string.close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        //Fermer le menu si je clique sur le bouton return
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.nav_home) {
            // Action pour "Home"
        } else if (menuItem.getItemId() == R.id.nav_calc) {
            Intent intent = new Intent(activity4.this, MyThirdActivity.class);
            startActivity(intent);
        } else if (menuItem.getItemId() == R.id.nav_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_LONG).show();
        }

        // Fermer le menu
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}