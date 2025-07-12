package com.mobile.tests;

import org.testng.annotations.Test;

public final class MobilePopupTest extends MobileTestBase {


    @Test
    public void testMobilePopup() {
        mobileHomePage.goToPreferenceList().handlePopup();
    }
}
