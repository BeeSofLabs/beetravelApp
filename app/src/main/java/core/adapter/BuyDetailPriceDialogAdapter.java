package core.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tv.tvprototype.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.component.FontManager;

/**
 * Created by ary on 5/11/17.
 */

public class BuyDetailPriceDialogAdapter extends ArrayAdapter<String> {
    @BindView(R.id.layout_buy_button)
    RelativeLayout layoutBuyButton;
    @BindView(R.id.confirm_buy_button)
    Button confirmBuyButton;

    @BindView(R.id.label_price_description)
    TextView  labelPriceDescription;
    @BindView(R.id.label_price_amount)
    TextView  labelPriceAmount;

    private ArrayList data;

    public BuyDetailPriceDialogAdapter(@NonNull Context context, ArrayList data) {
        super(context, 0, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_price_list, parent, false);
        ButterKnife.bind(this, convertView);

        FontManager.useFontAwesome(confirmBuyButton);

        labelPriceDescription.setText((String) this.data.get(position));
        if (position == (this.data.size() - 1)) layoutBuyButton.setVisibility(View.VISIBLE); // will visible the button in last position.

        confirmBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Texting buy click", Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }

}
