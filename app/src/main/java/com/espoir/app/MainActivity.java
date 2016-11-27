package com.espoir.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

import java.util.ArrayList;
public class MainActivity extends Activity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] prgmNameList={ "Peiture","Photographie","Musique", "Mode", "Theatre",};
    public static int [] prgmImages={ R.drawable.ic_color_lens_white_24dp, R.drawable.ic_linked_camera_white_24dp, R.drawable.ic_library_music_white_24dp, R.drawable.ic_library_music_white_24dp, R.drawable.ic_library_music_white_24dp,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomGridViewActivity(this, prgmNameList,prgmImages));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
