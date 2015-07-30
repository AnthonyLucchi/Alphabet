package com.example.ajl.alphabet;

/**
 * @author Anthony Lucchi
 * @version 3.1
 *
 * COP 4331C
 * Mon/Wed 12:00pm-1:50pm
 * Prof. Damla Turgut
 *
 * This is a standard grid view
 * it takes in a Integer array of images and displays them on the screen in a grid.
 *
 * @since       11/01/13 I begin the add a grid view
 * @since       11/03/13 Start invalidating the grid view and restarting to change view
 * @since       11/05/13 I added the function to change a tile a blank
 * @since	   11/07/13 Changed feature to be able to reload original view on back
 * @since	   11/09/13 Alphabet changes views now based on correct letters.
 * @since	   11/15/13 Got the timer to work and display the user's current drunk level.
 */

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return MainActivity.imgArray.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes

            //Calculation of ImageView Size - density independent.
            //maybe you should do this calculation not exactly in this method but put is somewhere else.
            Resources r = Resources.getSystem();
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, r.getDisplayMetrics());



            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams((int)px, (int)px));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(MainActivity.imgArray[position]);
        return imageView;
    }
}
