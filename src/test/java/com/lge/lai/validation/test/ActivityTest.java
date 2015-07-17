package com.lge.lai.validation.test;

import org.junit.Test;

import android.content.ComponentName;
import android.content.Intent;

import com.lge.lai.common.annotation.ActionWith;
import com.lge.lai.common.annotation.ActionWith.Call;
import com.lge.lai.common.annotation.ActionWith.Component;
import com.lge.lai.common.checker.InterfaceChecker;

public class ActivityTest {
    InterfaceChecker checker = new InterfaceChecker(getClass());

    @Test
    @ActionWith(toPackage = "com.android.dialer", callType = Call.EXPLICIT, componentType = Component.ACTIVITY)
    public void explicitCall() {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.android.dialer", "com.android.dialer.RecentCallsListActivity");
        intent.setComponent(componentName);
        checker.validates(intent);
    }

    @Test
    @ActionWith(toPackage="com.android.dialer", callType = Call.IMPLICIT, componentType = Component.ACTIVITY)
    public void implicitCall() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        checker.validates(intent);
    }
}
