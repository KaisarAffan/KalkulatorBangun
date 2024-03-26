package com.example.kalkulatorbangun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.kalkulatorbangun.BangunDatar.BangunDatarParent;
import com.example.kalkulatorbangun.BangunRuang.BangunRuangParent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new BangunDatarParent()).addToBackStack(null).commit();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;

                if(item.getItemId() == R.id.bangun_datar)
                {
                    fragment = new BangunDatarParent();
                }
                else if(item.getItemId() == R.id.bangun_ruang)
                {
                    fragment = new BangunRuangParent();
                }
                else if(item.getItemId() == R.id.profile)
                {
                    fragment = new ProfileFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                return true;
            }
        });
    }
}