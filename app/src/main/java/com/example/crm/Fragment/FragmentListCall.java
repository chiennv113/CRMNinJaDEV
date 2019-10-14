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
    // private ImageView mBtnSearch;
    private RecyclerView mRecycleviewRemind;


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
        service = ApiClient.getClient().create(ServiceRetrofit.class);


        //  imgViewSearch=view.findViewById(R.id.imgViewSearch);
        //  mEdtInfoSearch = view.findViewById(R.id.edtInfoSearch);
//        imgViewSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Tim kiemkiem", Toast.LENGTH_LONG ).show();
//            }
//        });
//        mEdtInfoSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Please long press the key", Toast.LENGTH_LONG ).show();
//            }
//        });

//        String strtext = getArguments().getString("edttext");
//        Log.e("abcde", "onCreateView: "+strtext);

        search("0979090897", "search_customer", "crm_ninja=eyJpdiI6IkxNXC9Sblg2bHIyNTBRNlRGUHE2Z1dnPT0iLCJ2YWx1ZSI6ImJaYmxGUWxmQjFXZjBrWkZyaXFxZzlMSGdJMjBRQ0lzbzVLSG5IbHMrcXZ5aVhyd2l1WUdkUjdhOE8xZTE1RFkiLCJtYWMiOiIxNWMwZDk1ZTA5NWQ0MThjZDBlNjZhNTA0ODg4NjM2YWVlMGRmNjQ4NjMwYjg5ZWM0MzEyMDhjNDhlMzFiMWZhIn0%3D; expires=Fri, 11-Oct-2019 04:11:41 GMT; Max-Age=86400; path=/; httponly", "application/x-www-form-urlencoded");

        return view;
    }


    //    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        if (getArguments() != null) {
//            String cookie = getArguments().getString(KEY_COOKIE);
//            Log.e("hehehe", "" + cookie);
//        }
//    }

    public void search(String info, String option, String cookie, String content) {
        final Search abc = new Search("0979090897", "search_customer");

        Call<Search> searchCall = service.search(info, option, cookie, content);
        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Log.e("search", response.body().getFullname());
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
