package com.nicholas.mkulimabiashara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private CartFragment cartFragment;
    private NotificationsFragment notificationsFragment;
    private MessageFragment messageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hooks to fragments
        homeFragment=new HomeFragment();
        cartFragment=new CartFragment();
        notificationsFragment=new NotificationsFragment();
        messageFragment=new MessageFragment();

        setFragment(homeFragment);
        //create hooks on the views
        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.homeicon:
                        setFragment(homeFragment);
                        return true;
                    case R.id.carticon:
                        setFragment(cartFragment);
                        return true;
                    case R.id.notificationicon:
                        setFragment(notificationsFragment);
                        return true;
                    case R.id.messageicon:
                        setFragment(messageFragment);
                        return true;

                    default:
                        return false;


                }
            }
        });
    }
    //create a new method to start fragment transaction
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framee,fragment);
        fragmentTransaction.commit();
    }
}