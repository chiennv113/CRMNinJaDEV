package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.crm.Fragment.FragmentListCall;
import com.example.crm.Model.ModelLogin.Login;
import com.example.crm.Retrofit.ApiClient;
import com.example.crm.Retrofit.ServiceRetrofit;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText mEdtUser;
    private TextInputEditText mEdtPass;
    private Button mBtnLogin;
    private ServiceRetrofit service;

    private List<Login> logins;

    FragmentTransaction transaction;

    String email;
    String password;
    private Handler AndroidNetworking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mEdtPass.setText("123456");
        mEdtUser.setText("app@ninjateam.vn");
        logins = new ArrayList<>();


        service = ApiClient.getClient().create(ServiceRetrofit.class);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidation()) {
                    Log.e("user", "onClick: " + email);
                    if (CommonMethod.isNetworkAvailable(LoginActivity.this)) {
                        loginRetrofit2Api(email, password, "login");
                    } else {
                        CommonMethod.showAlert("Internet Connectivity Failure", LoginActivity.this);
                    }

                }
            }
        });


    }

    private boolean checkValidation() {
        email = mEdtUser.getText().toString();
        password = mEdtPass.getText().toString();

        if (mEdtUser.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("UserId Cannot be left blank", LoginActivity.this);
            return false;
        } else if (mEdtPass.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("password Cannot be left blank", LoginActivity.this);
            return false;
        }

        return true;
    }

    private void loginRetrofit2Api(final String email, final String password, String option) {
        final Login login = new Login(email, password, "login");
        Call<Login> call = service.createUser(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Log.e("abc", "onResponse: " + response.body());
//                Login login1 = response.body();
                logins.add(response.body());

                Log.e("size", "onResponse: " + logins.size());
                Log.e("abc", "onResponse: " + logins.get(0).getMessage());

                if (response.body().getMessage().equals("Đăng nhập thành công")) {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
                Log.e("cookie", "onResponse a: " + response.headers().toString());
                String a = response.headers().get("Set-Cookie");


                Log.e("coooo", "" + a);
                String aaa = logins.get(0).getMessage();
                Toast.makeText(LoginActivity.this, "" + aaa, Toast.LENGTH_SHORT).show();

//                switchFragment(FragmentListCall.newInstance(a));


//                Bundle bundle = new Bundle();
//                bundle.putString("edttext", a);
//// set Fragmentclass Arguments
//                FragmentListCall fragobj = new FragmentListCall();
//                fragobj.setArguments(bundle);
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
    }


    private void initView() {
        mEdtUser = findViewById(R.id.edtUser);
        mEdtPass = findViewById(R.id.edtPass);
        mBtnLogin = findViewById(R.id.btn_login);
    }

<<<<<<< HEAD
    public void SignUpbtn(View view) {
    }

    public void ForgotPassword(View view) {
    }

=======
    public void switchFragment(Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.abc, fragment);
        ft.addToBackStack(name);
        ft.commit();
    }
>>>>>>> 50c807cbae48b3e63b0e8b694671be8e9f849149

    ///* Over here we are sending a POST request with two fields as POST request body params */
    //@POST("/data/2.1")
    //Call < T > postMovieDetails(@Field("userId") String userID, @Field("token") String token);
}
