package temple.edu.colorapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import temple.edu.colorapplication.adapters.colorAdapter;

public class MainActivity extends AppCompatActivity implements PaletteFragment.SpinnerSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //directions said to instantiate fragments using set arguments but this could be done blank. Used 0 since I'm not sure to include it or not.
        PaletteFragment palette = PaletteFragment.newInstance(0);

        Bundle bundle = new Bundle();
        bundle.putStringArray(KeyData.PASS_COLOR, getResources().getStringArray(R.array.colors));
        bundle.putStringArray(KeyData.PASS_POSITION, getResources().getStringArray(R.array.colorNames));
        palette.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.palette_fragment, palette).commit();
    }

    @Override
    public void setCanvasColor(int position) {
        CanvasFragment canvas = CanvasFragment.newInstance(position);
        getSupportFragmentManager().beginTransaction().add(R.id.canvas_fragment, canvas).addToBackStack(null).commit();
    }
}
