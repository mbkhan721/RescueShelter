package com.example.rescueshelter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Dogs = {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4, R.drawable.dog5,
    R.drawable.dog6};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView); // gridView control is instantiated
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge); // imgView instantiated and cannot be changed
        grid.setAdapter(new ImageAdapter(this)); // imageAdapter class displays images in the grid
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {// Waits for user interaction in gridView
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // onItemClick method
                // AdapterView records where the user touched the screen
                // View is the specified view within the item where the user touched
                Toast.makeText(getBaseContext(), "Dog number: " + (position + 1), Toast.LENGTH_SHORT).show(); // custom toast message
                pic.setImageResource(Dogs[position]); // setImage res displays the selected img
            }
        });
    }
    public class ImageAdapter extends BaseAdapter { // handling the image display
        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }
        @Override
        public int getCount() {
            return Dogs.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context); // instance of ImageView
            pic.setImageResource(Dogs[position]); // img referenced in array is displayed in pic
            pic.setScaleType(ImageView.ScaleType.CENTER); // scaled to fit
            pic.setLayoutParams(new GridView.LayoutParams(300,300)); // images in gridView are resized
            return pic;
        }
    }
}