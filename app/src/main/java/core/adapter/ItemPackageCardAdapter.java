package core.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import seeds.PackageSeed;

import java.util.List;

/**
 * Created by ary on 9/23/15.
 */
public class ItemPackageCardAdapter extends RecyclerView.Adapter<ItemPackageCardAdapter.ViewHolder> {

    List<PackageSeed> mItems;
    ViewHolder viewHolder;

    public ItemPackageCardAdapter(){
        super();

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_package) ImageView imagePackage;
        @BindView(R.id.text_title_package) TextView titlePackage;
        @BindView(R.id.text_description_package) TextView descriptionPackage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package_card, parent, false);
        viewHolder = new ViewHolder(v);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        NatureItemDummy nature = mItems.get(position);
//        holder.tripTitle.setText(nature.getName());
//        holder.tripDescription.setText(nature.getDes());
//        holder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return 3; //mItems.size();
    }
}
