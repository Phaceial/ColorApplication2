package temple.edu.colorapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import temple.edu.colorapplication.adapters.colorAdapter;

public class PaletteActivity extends AppCompatActivity {
    boolean spinnerInitial = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.colorSpinner);
        String[] colors = getResources().getStringArray(R.array.colors);

        spinner.setAdapter(new colorAdapter(this, colors));
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinnerInitial){
                    spinnerInitial = false;
                    return;
                }
                Intent launchCanvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                String colorString = (String) spinner.getItemAtPosition((position));

                launchCanvasIntent.putExtra(KeyData.PALETTE_TO_CANVAS, colorString);
                startActivity(launchCanvasIntent);
                view.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
