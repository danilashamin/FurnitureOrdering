package ru.mail.danilashamin.furnitureordering.mvp.model;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.View;

public class OnFurnitureTouchListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((String) v.getTag());
        ClipData dragData = new ClipData((String) v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
        View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder();
        v.startDrag(dragData, dragShadowBuilder, null, 0);
        return true;
    }
}
