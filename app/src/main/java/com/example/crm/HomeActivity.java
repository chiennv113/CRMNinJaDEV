package com.example.crm;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.crm.Fragment.FragmentListCall;
import com.example.crm.Fragment.Fragment_AddCall;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navView = findViewById(R.id.nav_view);

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new FragmentListCall());
        ft.commit();


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new FragmentListCall();
                        break;

                    case R.id.navigation_dashboard:
                        fragment = new Fragment_AddCall();
                        break;




                }

                return loadFragment(fragment);
            }


            private boolean loadFragment(Fragment fragment) {
                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                    return true;
                }
                return false;
            }



        });

    }

}