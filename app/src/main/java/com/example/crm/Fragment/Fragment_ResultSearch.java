package com.example.crm.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.crm.Model.ModelAdd;
import com.example.crm.Model.ModelCustomeFeelNew;
import com.example.crm.R;
import com.example.crm.Retrofit.ServiceRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ResultSearch extends Fragment {
    private LinearLayout mLnItem;
    private TextView mTvRsName;
    private TextView mTvRsEmail;
    private ServiceRetrofit service;


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
            String a = getArguments().getString("cont");
            int b = getArguments().getInt("cus_id", 0);
            String name = getArguments().getString("name");
            String email = getArguments().getString("email");
            mTvRsEmail.setText(email);
            mTvRsName.setText(name);
            mLnItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Onclick Linear", Toast.LENGTH_SHORT).show();
                    getCustomerFeel("get_PhoneCallFeel");

                }
            });
            Log.e("pass", "onViewCreated: " + a + "   " + b);

//            for (int i = 0;i<5;i++){
//
//            }
//            retrofit2.Call<CustomerFeel> getFeel = service.getFeel("get_PhoneCallFeel", "application/x-www-form-urlencoded");
//            getFeel.enqueue(new Callback<CustomerFeel>() {
//                @Override
//                public void onResponse(retrofit2.Call<CustomerFeel> call, Response<CustomerFeel> response) {
//                    Log.e("feel", "" + response.body());
//                }
//
//                @Override
//                public void onFailure(Call<CustomerFeel> call, Throwable t) {
//
//                }
//            });

        }

    }

    private void initView(View view) {
        mLnItem = view.findViewById(R.id.ln_item);
        mTvRsName = view.findViewById(R.id.tv_Rs_name);
        mTvRsEmail = view.findViewById(R.id.tv_Rs_email);
    }


    public void add() {
        Call<ModelAdd> addCall = service.add("add_phone_call", 145, "khách cần mua",
                "Rất hài lòng", "crm_ninja=eyJpdiI6InBncG4xVlwvRXJmekt3K3RrY3J2K3N3PT0iLCJ2YWx1ZSI6ImVWVllJa1U1RU4xQmpqV1lpcXdVT3BSdHB3clhScVpmRmdvTExJbVhRb3JEdmVoZmltUWE0bzZBdGZYODBoWGwiLCJtYWMiOiIyMmUwZmMyZmE1OTY5YjVkNjk0M2I0MGEyZmYyMTM1MzVjNTAxZmNjMjVkNTg3OTc4NzQzYWZhNzliZmQxNDRjIn0%3D; expires=Fri, 11-Oct-2019 07:15:05 GMT; Max-Age=86400; path=/; httponly", "application/x-www-form-urlencoded");
        addCall.enqueue(new Callback<ModelAdd>() {
            @Override
            public void onResponse(Call<ModelAdd> call, Response<ModelAdd> response) {
                Log.e("add", "onResponse: " + response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ModelAdd> call, Throwable t) {

            }
        });
    }

    public void getCustomerFeel(String option) {
        Call<List<ModelCustomeFeelNew>> getFeel = service.getFeel(option);
        getFeel.enqueue(new Callback<List<ModelCustomeFeelNew>>() {
            @Override
            public void onResponse(Call<List<ModelCustomeFeelNew>> call, Response<List<ModelCustomeFeelNew>> response) {
                Log.e("TAG", "onResponse: " + response.body().size());
                if (response.isSuccessful() && response.body() != null) {
                    Log.e("TAG", "onResponse: " + response.body().size());
                    for (ModelCustomeFeelNew test : response.body()) {
                        Log.e("TAG", "onResponse: " + test.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelCustomeFeelNew>> call, Throwable t) {

            }
        });
    }

//    public void getFeel(){
//
//        TestRetrofit.getInstance().test("get_PhoneCallFeel").enqueue(new Callback<List<TestModel>>() {
//            @Override
//            public void onResponse(Call<List<TestModel>> call, Response<List<TestModel>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    Log.e("TAG", "onResponse: " + response.body().size());
//                    for (TestModel test : response.body()) {
//                        Log.e("TAG", "onResponse: " + test.getName());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<TestModel>> call, Throwable t) {
//
//            }
//        });
//    }


}
