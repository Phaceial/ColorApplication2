package temple.edu.colorapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import temple.edu.colorapplication.adapters.colorAdapter;

public class PaletteFragment extends Fragment {
    private SpinnerSelectedInterface mCallback;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(String color) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KeyData.PASS_COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);
        boolean spinnerInitial = true;
        final Spinner spinner = (Spinner) v.findViewById(R.id.colorSpinner);
        final String[] colors = getResources().getStringArray(R.array.colors);
        final String[] names = getResources().getStringArray(R.array.colorNames);

        spinner.setAdapter(new colorAdapter(getActivity(), colors, names));
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCallback.SpinnerSelected(((TextView) view).getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }

    public interface SpinnerSelectedInterface {
        public void SpinnerSelected(String color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallback = (SpinnerSelectedInterface) context;
        } catch (ClassCastException e){
            throw new ClassCastException (context.toString() + " must implement SpinnerSelectedInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}
