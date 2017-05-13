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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.layout_buy_button)
    RelativeLayout layoutBuyButton;
    @BindView(R.id.button_buy)
    Button buttonBuy;

    @BindView(R.id.label_price_description)
    TextView  labelPriceDescription;
    @BindView(R.id.label_price_amount)
    TextView  labelPriceAmount;
    @BindView(R.id.label_total_cost_value)
    TextView labelTotalCostValue;

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

        FontManager.useFontAwesome(buttonBuy);

        labelPriceDescription.setText((String) this.data.get(position));

        if (position == (this.data.size() - 1)) {
            layoutBuyButton.setVisibility(View.VISIBLE); // will visible the button in last position.
            labelTotalCostValue.setText("Rp 500.000,00");
        }

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Click buy package!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getContext(), PaymentActivity.class);
                activity.startActivity(intent);
            }
        });
        return convertView;
    }

}
