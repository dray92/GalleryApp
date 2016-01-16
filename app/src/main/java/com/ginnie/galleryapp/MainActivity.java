package com.ginnie.galleryapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.ginnie.galleryapp.Fragments.LoginFragment;
import com.ginnie.galleryapp.Fragments.SplashFragment;


public class MainActivity extends FragmentActivity {
FrameLayout mainframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainframe=(FrameLayout)findViewById(R.id.main_container);
        SelectItem(2);
    }


    public void SelectItem(int possition) {

        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (possition) {
            case 0:
                fragment = new LoginFragment();
                break;
            case 1:
                fragment = new SplashFragment();
                break;
            case 2:
                fragment = new SplashFragment();
                break;

            default:
                break;
        }

        FragmentManager frgManager = getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.main_container, fragment).addToBackStack(null)
                .commit();


    }

}
