package ch.heigvd.pro.b04.android;

import androidx.fragment.app.Fragment;

/**
 * A host (typically an {@code Activity}} that can display fragments and knows how to respond to
 * navigation events.
 */
interface NavigationHost {
    /**
     * Trigger a navigation to the specified fragment, optionally adding a transaction to the back
     * stack to make this navigation reversible.
     */
    void navigateTo(Fragment fragment, boolean addToBackstack);
}
