package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.BuyDetailPriceDialogAdapter;
import core.fragment.PackageFragment;

/**
 * Created by ary on 4/7/17.
 */

public class PackageDetailActivity extends BaseAppCompatActivity {
    @BindView(R.id.button_show_detail)
    Button buttonShowDetail;

    private ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Day 1", "Day 2", "Day 3"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(R.string.package_detail_title);

        showFragment(new PackageFragment(titles, getSupportFragmentManager()));


        buttonShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getEventBus().post(new MessageEvent("Hello everyone!"));
//                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
//                startActivity(intent);


                final String[] values = new String[]{ "Tour to Singapore", "Tour Raja Ampat", "Waisak Day 3D2N" };
                final ArrayList data = new ArrayList();
                for (int i = 0; i < values.length; ++i) {
                    data.add(values[i]);
                }

                DialogPlus dialog = DialogPlus.newDialog(PackageDetailActivity.this)

                        .setAdapter(new BuyDetailPriceDialogAdapter(getApplication(), data))
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                            }
                        })
                        .setGravity(Gravity.BOTTOM)
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();

                dialog.show();
            }
        });
    }

}
