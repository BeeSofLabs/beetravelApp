package core.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tv.tvprototype.R;
import com.tv.tvprototype.activity.HotelActivity;
import com.tv.tvprototype.activity.ItineraryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 4/15/17.
 */

public class PackageDayFragment extends Fragment {
    @BindView(R.id.itineray_label)
    TextView label;
    @BindView(R.id.change_itinerary)
    TextView changeItineraryLabel;
    @BindView(R.id.change_hotel)
    TextView changeHotelLabel;

    private int day;

    public PackageDayFragment(int day) {
        this.day = day;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_package_day, container, false);
        ButterKnife.bind(this, rootView);

        label.setText("Pick your car #" + day);


        changeItineraryLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ItineraryActivity.class);
                startActivity(intent);
            }
        });

        changeHotelLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HotelActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
