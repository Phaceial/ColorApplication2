package temple.edu.colorapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends Fragment {
    private View canvasView;

    public CanvasFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CanvasFragment newInstance(String color) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KeyData.PASS_COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);
//        canvasView = v.findViewById(R.id.);
        return v;
    }
}
