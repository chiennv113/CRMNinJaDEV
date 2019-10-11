package com.example.crm.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.crm.R;
import com.example.crm.Retrofit.ApiClient;
import com.example.crm.Retrofit.ServiceRetrofit;

public class Fragment_AddCall extends Fragment {
    public static String cus = "cus_id";
    public static String Content = "cont";
    private ServiceRetrofit service;
    private int cus_id;
    private String con;


//    public static void newInStance(int customer_id, String content) {
//        Bundle bundle = new Bundle();
//        bundle.putInt("cus_id", customer_id);
//        bundle.putString("cont", content);
//    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listcall, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service = ApiClient.getClient().create(ServiceRetrofit.class);
//        getFeel("get_PhoneCallFeel", "application/x-www-form-urlencoded");

//        if (getArguments() != null) {
//            cus_id = getArguments().getInt("cus", 0);
//            con = getArguments().getString("con");
//
//            Log.e("0123", "onViewCreated: " + cus_id + "    " + con);
//        }

//        Bundle bundle = this.getArguments();
//        if(bundle != null){
//            String a = getArguments().getString("cont");
//            int b = getArguments().getInt("cus_id",0);
//            Log.e("pass", "onViewCreated: "+a+"   "+b );
//        }
//
//        Call<ModelAdd> addCall = service.add("add_phone_call", 145, "khách cần mua",
//                "Rất hài lòng", "crm_ninja=eyJpdiI6InBncG4xVlwvRXJmekt3K3RrY3J2K3N3PT0iLCJ2YWx1ZSI6ImVWVllJa1U1RU4xQmpqV1lpcXdVT3BSdHB3clhScVpmRmdvTExJbVhRb3JEdmVoZmltUWE0bzZBdGZYODBoWGwiLCJtYWMiOiIyMmUwZmMyZmE1OTY5YjVkNjk0M2I0MGEyZmYyMTM1MzVjNTAxZmNjMjVkNTg3OTc4NzQzYWZhNzliZmQxNDRjIn0%3D; expires=Fri, 11-Oct-2019 07:15:05 GMT; Max-Age=86400; path=/; httponly", "application/x-www-form-urlencoded");
//        addCall.enqueue(new Callback<ModelAdd>() {
//            @Override
//            public void onResponse(Call<ModelAdd> call, Response<ModelAdd> response) {
//                Log.e("add", "onResponse: " + response.body().getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<ModelAdd> call, Throwable t) {
//
//            }
//        });
    }

//    public void getFeel(String option, String type) {
//        Call<CustomerFeel> getFeel = service.getFeel(option, type);
//        getFeel.enqueue(new Callback<CustomerFeel>() {
//            @Override
//            public void onResponse(Call<CustomerFeel> call, Response<CustomerFeel> response) {
//                Log.e("feel", "" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<CustomerFeel> call, Throwable t) {
//
//            }
//        });
//    }

    public class Content {
    }
}
