package core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 5/5/17.
 */

public class ItinerarySlideFragment extends Fragment {
    @BindView(R.id.text_description_package)
    TextView descriptionPackage;

    private int pos;

    public ItinerarySlideFragment(int pos) {
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_itinerary_slide_page, container, false);
        ButterKnife.bind(this, rootView);

        descriptionPackage.setText("Card Itinerary #" + (pos + 1));
        return rootView;
    }
}
