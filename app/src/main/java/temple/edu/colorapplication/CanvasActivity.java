package temple.edu.colorapplication;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.security.Key;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        TextView displayColor = (TextView) findViewById(R.id.displayColor);
        Intent color = getIntent();
        int colorString = color.getIntExtra(KeyData.PASS_COLOR, -1);
        String[] colors = getResources().getStringArray(R.array.colors);
        String[] names = getResources().getStringArray(R.array.colorNames);

        View canvasColor = findViewById(R.id.canvasColor);

        displayColor.setTextColor(Color.BLACK);
        displayColor.setText(names[colorString]);
        canvasColor.setBackgroundColor(Color.parseColor(colors[colorString]));
    }
}
