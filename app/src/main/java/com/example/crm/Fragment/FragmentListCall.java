package com.example.crm.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.crm.Model.ModelSearchCu.Search;
import com.example.crm.R;
import com.example.crm.Retrofit.ApiClient;
import com.example.crm.Retrofit.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentListCall extends Fragment {
    private ServiceRetrofit service;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listcall, container, false);
        service = ApiClient.getClient().create(ServiceRetrofit.class);

        search("0979090897",
                "search_customer",
                "crm_session=eyJpdiI6IkMyZkJXXC9pV00wN1JWZjA5SERRQVR3PT0iLCJ2YWx1ZSI6Iks1SFlCNUp1K1FFTmhWcmx5UmZrN0tvazl6QkVZS0FcL1ZEZVJ2dExqWEFRYTNKT0J5Wm9LU0dMYU9SalBXVWo1IiwibWFjIjoiYmY3YTFhYzQwNGFiOWNmZTIyMjcwZmJlM2Q0ZjJjNzQ2NzlhYTQyZTFmMmI4ZjU1YzdkN2Y4YWJmYzllYmFlNCJ9; expires=Thu, 10-Oct-2019 07:39:50 GMT; Max-Age=86400; path=/; httponly",
                "application/x-www-form-urlencoded");

        return view;
    }

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
}
