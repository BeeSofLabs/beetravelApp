package core.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tv.tvprototype.R;
import com.tv.tvprototype.activity.PaymentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 4/24/17.
 */

public class PaymentStepOneFragment extends BaseFragment {
    @BindView(R.id.step_one_button)
    TextView stepOneButton;

    private TextView stepOneLabel;
    private ProgressBar progressBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_step_one_payment, container, false);
        ButterKnife.bind(this, rootView);

        stepOneLabel = (TextView) getActivity().findViewById(R.id.step_payment_one);
        stepOneLabel.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar.setProgress(30);

        stepOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PaymentActivity) getActivity()).showFragment(new PaymentStepTwoFragment());
            }
        });


        return rootView;
    }
}
