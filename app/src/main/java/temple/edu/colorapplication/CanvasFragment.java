package temple.edu.colorapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends Fragment {
    private TextView displayColor;
    private Layout background;
    int id = -1;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(int position) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KeyData.PASS_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);
        displayColor = (TextView) v.findViewById(R.id.displayColor);
        int position = getArguments().getInt(KeyData.PASS_POSITION);
        String[] colors = getResources().getStringArray(R.array.colors);
        String[] names = getResources().getStringArray(R.array.colorNames);
        displayColor.setText(names[position]);
        v.setBackgroundColor(Color.parseColor(colors[position]));
        return v;
    }
}
