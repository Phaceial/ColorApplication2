package temple.edu.colorapplication;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        TextView displayColor = (TextView) findViewById(R.id.displayColor);
        Intent color = getIntent();
        String colorString = color.getStringExtra(KeyData.PALETTE_TO_CANVAS);
        View canvasColor = findViewById(R.id.canvasColor);

        displayColor.setTextColor(Color.BLACK);
        displayColor.setText(colorString);
        canvasColor.setBackgroundColor(Color.parseColor(colorString));

    }
}
