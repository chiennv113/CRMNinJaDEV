package com.example.crm.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crm.Model.ModelSearchCu.Search;
import com.example.crm.R;
import com.example.crm.Retrofit.ApiClient;
import com.example.crm.Retrofit.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentListCall extends Fragment {
    private ServiceRetrofit service;
    private static final String KEY_COOKIE = "FragmentListCall.KEY_COOKIE";
    private EditText mEdtInfoSearch;
    private ImageButton mBtnSearch;
    private RecyclerView mRecycleviewRemind;
    private TextView mTvTest;


    public static Fragment newInstance(String cookie) {
        Fragment fragment = new FragmentListCall();
        Bundle args = new Bundle();
        args.putString(KEY_COOKIE, cookie);
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        service = ApiClient.getClient().create(ServiceRetrofit.class);
        if (getArguments() != null) {
            String cookie = getArguments().getString(KEY_COOKIE);
            search("0979090897", "search_customer", cookie, "application/x-www-form-urlencoded");

        }


    }

    public void search(String info, String option, String cookie, String content) {

        Call<Search> searchCall = service.search(info, option, cookie, content);
        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Toast.makeText(getContext(), "" + response.body().getFullname(), Toast.LENGTH_SHORT).show();
                Log.e("customer_id", "" + response.body().getPhonecall().get(0).getCustomerId());
                Log.e("customer_id", "" + response.body().getPhonecall().get(0).getContent());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        mEdtInfoSearch = view.findViewById(R.id.edtInfoSearch);
        mBtnSearch = view.findViewById(R.id.btnSearch);
        mRecycleviewRemind = view.findViewById(R.id.recycleview_remind);
        mTvTest = view.findViewById(R.id.tvTest);
    }
}
