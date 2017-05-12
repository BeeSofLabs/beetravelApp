package core.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tv.tvprototype.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.component.FontManager;

/**
 * Created by ary on 5/9/17.
 */

public class BuyDetailDialogAdapter extends ArrayAdapter {
    @BindView(R.id.list_buy_details)
    ListView listBuyDetails;

    @BindView(R.id.confirm_buy_button)
    TextView confirmBuyButton;


    public BuyDetailDialogAdapter(Context context) {
        super(context, 0, new String[]{"Item 1"});
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("POS1>>>", position+"");

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cost_detail, parent, false);
        ButterKnife.bind(this, convertView);
        FontManager.useFontAwesome(confirmBuyButton);

        final String[] values = new String[]{"Item 1", "Item 2", "Item 3", "Item 4"};
        final ArrayList data = new ArrayList();
        for (int i = 0; i < values.length; ++i) {
            data.add(values[i]);
        }

        BuyDetailPriceDialogAdapter adapter = new BuyDetailPriceDialogAdapter(getContext(), data);
        listBuyDetails.setAdapter(adapter);

        return convertView;
    }

}
