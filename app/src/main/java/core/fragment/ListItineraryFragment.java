package core.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tv.tvprototype.R;
import com.tv.tvprototype.activity.PackageDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 4/14/17.
 */
public class ListItineraryFragment extends BaseFragment {
    @BindView(R.id.itinerary_recycler_view)
    RecyclerView timelineView;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


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
        View rootView = inflater.inflate(R.layout.fragment_itinerary_timeline_list, container, false);
        ButterKnife.bind(this, rootView);

        timelineView.setHasFixedSize(true);

        // click listener
        timelineView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), timelineView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.d("EVENT", "trigger from click!");

                Intent intent = new Intent(getActivity(), PackageDetailActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Log.d("EVENT", "trigger from long click!");
            }
        }));


        layoutManager = new LinearLayoutManager(this.getContext());
        timelineView.setLayoutManager(layoutManager);

//        adapter = new ItemItineraryTimelineAdapter();
//        timelineView.setAdapter(adapter);


        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
