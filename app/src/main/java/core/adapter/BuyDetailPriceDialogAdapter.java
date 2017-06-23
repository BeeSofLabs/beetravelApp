package core.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.dialogplus.DialogPlus;
import com.tv.tvprototype.R;
import com.tv.tvprototype.activity.PackageDetailActivity;
import com.tv.tvprototype.activity.PaymentActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.component.FontManager;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by ary on 5/11/17.
 */

public class BuyDetailPriceDialogAdapter extends ArrayAdapter<String> {
    @BindView(R.id.label_price_description)
    TextView labelPriceDescription;
    @BindView(R.id.label_price_amount)
    TextView labelPriceAmount;

    private ArrayList data;
    private Activity activity;

    public BuyDetailPriceDialogAdapter(Activity activity, @NonNull Context context, ArrayList data) {
        super(context, 0, data);
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_price_list, parent, false);
        ButterKnife.bind(this, convertView);
        labelPriceDescription.setText((String) this.data.get(position));
        return convertView;
    }

}
