package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartFragment extends Fragment {

    private TextView startFeedbackText;
    private ProgressBar startProgressBar;

    private NavController navController;

    private static final String TAG = "StartFragment";

    private FirebaseAuth firebaseAuth;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        firebaseAuth = FirebaseAuth.getInstance();

        startFeedbackText = view.findViewById(R.id.start_feedback);
        startProgressBar = view.findViewById(R.id.start_progress_bar);

        startFeedbackText.setText(R.string.checking_user_account);
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser == null){
            startFeedbackText.setText(R.string.creating_new_account);
            // create new user
            firebaseAuth.signInAnonymously()
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       startFeedbackText.setText(R.string.account_created);
                       navController.navigate(R.id.action_startFragment_to_listFragment);

                   }else {
                       Log.d(TAG, "onComplete: " +task.getException());
                   }
                }
            });
        }else {
            // navigate to homepage
            startFeedbackText.setText(R.string.logged_in);

            navController.navigate(R.id.action_startFragment_to_listFragment);

        }
    }
}