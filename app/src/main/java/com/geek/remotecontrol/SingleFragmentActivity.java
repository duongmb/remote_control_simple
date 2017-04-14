package com.geek.remotecontrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


public abstract class SingleFragmentActivity extends FragmentActivity {

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.layout_container);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.layout_container, fragment).commit();
        }
    }
}
