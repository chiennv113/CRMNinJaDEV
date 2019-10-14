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
<<<<<<< HEAD
=======
    private ImageView mBtnSearch;
>>>>>>> e1d9cd3b64d6bcbf905a1b27e81bc7a5cc020029
    private RecyclerView mRecycleviewRemind;


    private static final String KEY_COO_KIE = "FragmentListCall.KEY_COOKIE";
<<<<<<< HEAD
    private ImageView mBtnSearch;
=======

>>>>>>> e1d9cd3b64d6bcbf905a1b27e81bc7a5cc020029



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
<<<<<<< HEAD
=======
//        service = ApiClient.getClient().create(ServiceRetrofit.class);


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

//        search("0979090897", "search_customer", "crm_ninja=eyJpdiI6IkxNXC9Sblg2bHIyNTBRNlRGUHE2Z1dnPT0iLCJ2YWx1ZSI6ImJaYmxGUWxmQjFXZjBrWkZyaXFxZzlMSGdJMjBRQ0lzbzVLSG5IbHMrcXZ5aVhyd2l1WUdkUjdhOE8xZTE1RFkiLCJtYWMiOiIxNWMwZDk1ZTA5NWQ0MThjZDBlNjZhNTA0ODg4NjM2YWVlMGRmNjQ4NjMwYjg5ZWM0MzEyMDhjNDhlMzFiMWZhIn0%3D; expires=Fri, 11-Oct-2019 04:11:41 GMT; Max-Age=86400; path=/; httponly", "application/x-www-form-urlencoded");


>>>>>>> e1d9cd3b64d6bcbf905a1b27e81bc7a5cc020029
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
         mEdtInfoSearch = view.findViewById(R.id.edtInfoSearch);
         mBtnSearch = view.findViewById(R.id.btnSearch);
        mRecycleviewRemind = view.findViewById(R.id.recycleview_remind);


    }



    }



