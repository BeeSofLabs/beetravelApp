package com.tv.tvprototype.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.Holder;
import com.orhanobut.dialogplus.OnCancelListener;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.BuyDetailPriceDialogAdapter;
import core.event.MessageEvent;
import core.fragment.PackageFragment;

/**
 * Created by ary on 4/7/17.
 */

public class PackageDetailActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.show_detail)
    TextView showDetail;
    @BindView(R.id.button_buy)
    Button buttonBuy;

    private ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Day 1", "Day 2", "Day 3"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.package_detail_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showFragment(new PackageFragment(titles, getSupportFragmentManager()));

        showDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialogPackageDetail();
            }
        });
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventBus().post(new MessageEvent("Hello everyone!"));
                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showDialogPackageDetail() {
        final String[] values = new String[]{"Tour to Singapore", "Tour Raja Ampat", "Waisak Day 3D2N"};
        final ArrayList data = new ArrayList();
        for (int i = 0; i < values.length; ++i) data.add(values[i]);

        showCompleteDialog(Gravity.BOTTOM, (new BuyDetailPriceDialogAdapter(this, getApplication(), data)),
                new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        switch (view.getId()){
                            case R.id.partial_dialog_close:
                                dialog.dismiss();
                                break;
                            case R.id.button_buy:
                                dialog.dismiss();
                                Intent intent = new Intent(PackageDetailActivity.this, PaymentActivity.class);
                                startActivity(intent);
                                break;
                        }
                    }
                },
                false);

    }


    private void showCompleteDialog(int gravity, BuyDetailPriceDialogAdapter adapter,
                                    OnClickListener dialogOnClick,
                                    boolean expanded) {
        final DialogPlus dialog = DialogPlus.newDialog(this)
                .setHeader(R.layout.partial_dialog_header)
                .setFooter(R.layout.partial_buy_dialog_footer)
                .setCancelable(true)
                .setGravity(gravity)
                .setAdapter(adapter)
                .setOnClickListener(dialogOnClick)
                .setExpanded(expanded)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();
        dialog.show();
    }

}
