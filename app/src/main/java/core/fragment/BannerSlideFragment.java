package core.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tv.tvprototype.R;
import com.tv.tvprototype.activity.ItineraryTimelineActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 5/5/17.
 */

public class BannerSlideFragment extends Fragment {
    @BindView(R.id.card_banner)
    CardView bannerCard;
//    @BindView(R.id.text_description_package)
//    TextView descriptionPackage;

    private int pos;

    public BannerSlideFragment(int pos) {
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_banner_slide_page, container, false);
        ButterKnife.bind(this, rootView);

        bannerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ItineraryTimelineActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
