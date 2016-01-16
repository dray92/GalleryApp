package com.ginnie.galleryapp.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ginnie.galleryapp.MainActivity;
import com.ginnie.galleryapp.R;


/**
 * Created by su on 7/8/15.
 */
public class LoginFragment extends Fragment {

EditText username,paswrd;
    Button login;
    public LoginFragment()
    {

    }

    ImageView back;
    private static final String TAG = "SignupActivity";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        username=(EditText)view.findViewById(R.id.username);
        paswrd=(EditText)view.findViewById(R.id.paswrd);
        login=(Button)view.findViewById(R.id.login);
        back=(ImageView)view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SplashFragment fragment2 = new SplashFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.main_container, fragment2);
                transaction.commit();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();

            }
        });


        return view;
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        login.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
        String name = username.getText().toString();

        String password = paswrd.getText().toString();






        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public boolean validate() {
        boolean valid = true;
        String name = username.getText().toString();

        String password = paswrd.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            username.setError("at least a characters");
            valid = false;
        } else {
            username.setError(null);
        }

        if (password.isEmpty() || password.length() < 4) {
            paswrd.setError("Minimum of 6 alphanumeric characters");
            valid = false;
        } else {
            paswrd.setError(null);
        }



        return valid;
    }

    public void onSignupSuccess() {
        login.setEnabled(true);
        Toast.makeText(getActivity(), "Login Succesfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
    public void onSignupFailed() {
        Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_LONG).show();

        login.setEnabled(true);
    }

}
