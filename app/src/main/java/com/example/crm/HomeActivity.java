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
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String a = getIntent().getStringExtra("cookie");
        addFragment(FragmentListCall.newInstance(a));

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.navListCall:
                        fragment = new FragmentListCall();
                        break;

                    case R.id.navAddCall:
                        fragment = new Fragment_AddCall();
                        break;
                }


                return loadFragment(fragment);
            }


            private boolean loadFragment(Fragment fragment) {
                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.abc, fragment)
                            .commit();
                    return true;
                }
                return false;
            }



        });

    }

    public void addFragment(Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.add(R.id.abc, fragment);
        ft.addToBackStack(name);
        ft.commit();
    }
}
