package com.example.crm.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;


import android.widget.ImageView;


import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
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
    private ImageView imgViewSearch;
    private RecyclerView mRecycleviewRemind;


    private static final String KEY_COO_KIE = "FragmentListCall.KEY_COOKIE";
    private ImageView mBtnSearch;



    public static Fragment newInstance(String cookie) {
        Fragment fragment = new FragmentListCall();
        Bundle args = new Bundle();
        args.putString(KEY_COOKIE, cookie);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initView(view);
        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mEdtInfoSearch.setText("0979090897");


        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = mEdtInfoSearch.getText().toString().trim();
                if (getArguments() != null) {
                    String cookie = getArguments().getString(KEY_COOKIE);
                    Search(info, "search_customer", cookie, "application/x-www-form-urlencoded");
                }
            }
        });
    }

    public void Search(String info, String option, final String cookie, String content) {

        ApiClient.getInstance().search(info, option, cookie, content).enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Toast.makeText(getContext(), "" + response.body().getFullname(), Toast.LENGTH_SHORT).show();

                Log.e("customer_id", "" + response.body().getPhonecall().get(0).getCustomerId());
                Log.e("customer_id", "" + response.body().getPhonecall().get(0).getContent());
                int customer_id = response.body().getPhonecall().get(0).getCustomerId();
                String content = response.body().getPhonecall().get(0).getContent();
                String name = response.body().getFullname();
                String email = response.body().getEmail();

                Bundle bundle = new Bundle();
                bundle.putInt("cus_id", customer_id);
                bundle.putString("cont", content);
                bundle.putString("cookie", cookie);
                bundle.putString("name", name);
                bundle.putString("email", email);
                Fragment_ResultSearch fragment2 = new Fragment_ResultSearch();
                fragment2.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.abc, fragment2)
                        .commit();
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
            }
        });
    }

    private void initView(View view) {
        // mEdtInfoSearch = view.findViewById(R.id.edtInfoSearch);
        //  mBtnSearch = view.findViewById(R.id.btnSearch);
        mRecycleviewRemind = view.findViewById(R.id.recycleview_remind);


    }



    }



