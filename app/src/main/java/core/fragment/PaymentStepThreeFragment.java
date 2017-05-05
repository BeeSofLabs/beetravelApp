package core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tv.tvprototype.R;

/**
 * Created by ary on 4/24/17.
 */

public class PaymentStepThreeFragment extends BaseFragment {

    private TextView stepThreeLabel;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_step_three_payment, container, false);

        stepThreeLabel = (TextView) getActivity().findViewById(R.id.step_payment_three);
        stepThreeLabel.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar.setProgress(100);

        return rootView;
    }
}
