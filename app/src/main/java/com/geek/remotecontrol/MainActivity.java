package com.geek.remotecontrol;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new RemoteControlFragment();
    }
}
