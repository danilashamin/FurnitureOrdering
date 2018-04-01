package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class OnFurnitureDragListener implements View.OnDragListener {

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        // Handles each of the expected events
        switch (event.getAction()) {

            case DragEvent.ACTION_DRAG_STARTED:

                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                    // As an example of what your application might do,
                    // applies a blue color tint to the View to indicate that it can accept
                    // data.
                    //v.setColorFilter(Color.BLUE);

                    // Invalidate the view to force a redraw in the new tint
                    v.invalidate();

                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                }

                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                v.setX(event.getX());
                v.setY(event.getY());
            case DragEvent.ACTION_DRAG_LOCATION:

            case DragEvent.ACTION_DRAG_EXITED:

            case DragEvent.ACTION_DROP:

            case DragEvent.ACTION_DRAG_ENDED:

                return true;

            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }

        return true;
    }
}

