package com.sam.friendlens.ui.dashboard;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        Log.d("MY", String.valueOf(1));

        assert e1 != null;
        float deltaY = e2.getY() - e1.getY();
        float deltaX = e2.getX() - e1.getX();
        Log.d("MY", String.valueOf(deltaY));

        if (Math.abs(deltaY) > Math.abs(deltaX)) {

            if (Math.abs(deltaY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                Log.d("MY", String.valueOf(deltaY));

                if (deltaY > 0) {
                    onSwipeDown();
                } else {
                    onSwipeUp();
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return true;
    }

    private void onSwipeUp() {
        Log.d("SWIPE", "Bạn đã vuốt LÊN");
    }

    private void onSwipeDown() {
        Log.d("SWIPE", "Bạn đã vuốt XUỐNG");
    }
}
