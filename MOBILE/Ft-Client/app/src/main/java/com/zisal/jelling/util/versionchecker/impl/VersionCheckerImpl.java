package com.zisal.jelling.util.versionchecker.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.zisal.jelling.util.versionchecker.IVersionChecker;

/**
 * Created by Dian on 3/14/2016.
 */
public class VersionCheckerImpl implements IVersionChecker {

    @Override
    public Integer getVersionCode(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
}
