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

import com.tv.tvprototype.activity.PackageDetailActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.ItemPackageCardAdapter;

/**
 * Created by ary on 4/14/17.
 */
public class ListPackageFragment extends BaseFragment {
    @BindView(R.id.package_recycler_view)
    RecyclerView packageView;

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
        View rootView = inflater.inflate(R.layout.fragment_package_list, container, false);
        ButterKnife.bind(this, rootView);

        packageView.setHasFixedSize(true);

        // click listener
        packageView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), packageView, new RecyclerTouchListener.ClickListener() {
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
        packageView.setLayoutManager(layoutManager);

        adapter = new ItemPackageCardAdapter();
        packageView.setAdapter(adapter);


        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
