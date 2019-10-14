package com.example.crm;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.crm.Fragment.FragmentListCall;
import com.example.crm.Fragment.Fragment_AddCall;
import com.example.crm.Fragment.Fragment_Remind;
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
        ft.replace(R.id.abc, new FragmentListCall());
        ft.commit();


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
                    case  R.id.navRemind:
                        fragment=new Fragment_Remind();
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

}
