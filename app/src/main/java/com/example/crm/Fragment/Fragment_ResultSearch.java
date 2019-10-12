package com.example.crm.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.crm.Model.ModelAdd;
import com.example.crm.Model.ModelCustomeFeelNew;
import com.example.crm.R;
import com.example.crm.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ResultSearch extends Fragment {
    private LinearLayout mLnItem;
    private TextView mTvRsName;
    private TextView mTvRsEmail;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<Integer> cus_id = new ArrayList<>();
    private Dialog dialog;

    private Button mBtnNo;
    private Button mBtnOk;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            final String cont = getArguments().getString("cont");
            final int b = getArguments().getInt("cus_id", 0);
            final String cookie = getArguments().getString("cookie");

            arrayList.add(0, cont);
            arrayList.add(1, cookie);
            cus_id.add(0, b);


            String name = getArguments().getString("name");
            String email = getArguments().getString("email");
            mTvRsEmail.setText(email);
            mTvRsName.setText(name);
            mLnItem.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Onclick Linear", Toast.LENGTH_SHORT).show();


                    dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.dialog_addcall);
                    mBtnOk = dialog.findViewById(R.id.btn_ok);
                    mBtnNo = dialog.findViewById(R.id.btn_no);
                    dialog.show();

                    mBtnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            getCustomerFeel("get_PhoneCallFeel");
                            dialog.dismiss();
                        }
                    });
                    mBtnNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });


                }
            });


        }

    }

    private void initView(View view) {
        mLnItem = view.findViewById(R.id.ln_item);
        mTvRsName = view.findViewById(R.id.tv_Rs_name);
        mTvRsEmail = view.findViewById(R.id.tv_Rs_email);
    }


    public void add(String option, int id, String content, String cus_feel, String cookie, String type) {
        ApiClient.getInstance().add(option, id, content, cus_feel, cookie, type).enqueue(new Callback<ModelAdd>() {
            @Override
            public void onResponse(Call<ModelAdd> call, Response<ModelAdd> response) {
                Toast.makeText(getContext(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelAdd> call, Throwable t) {

            }
        });


    }

    public void getCustomerFeel(final String option) {
        ApiClient.getInstance().getFeel(option).enqueue(new Callback<List<ModelCustomeFeelNew>>() {
            @Override
            public void onResponse(Call<List<ModelCustomeFeelNew>> call, Response<List<ModelCustomeFeelNew>> response) {
                Log.e("size", "onResponse: " + response.body().size());
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                    }
                    int positonRandom = (int) Math.floor(Math.random() * response.body().size());

                    Log.e("cus", "onResponse: " + cus_id.get(0));

                    add("add_phone_call", cus_id.get(0), arrayList.get(0), response.body().get(positonRandom).getName(),
                            arrayList.get(1), "application/x-www-form-urlencoded");
                }


            }

            @Override
            public void onFailure(Call<List<ModelCustomeFeelNew>> call, Throwable t) {

            }
        });
    }

}
