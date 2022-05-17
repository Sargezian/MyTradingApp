package com.example.mytradingapp.View.ReportApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mytradingapp.R;


public class ReportFragment extends Fragment {

    EditText Subject;
    EditText Text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        Subject   = (EditText)view.findViewById(R.id.Subject);
        Text   = (EditText)view.findViewById(R.id.Text);

        Button sendEmailButton = view.findViewById(R.id.button_send_mail);

        sendEmailButton.setOnClickListener(this::emailToCreators);

        return view;
    }


    public void emailToCreators(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"lennart_1997@hotmail.com"});

        intent.putExtra(Intent.EXTRA_SUBJECT, Subject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, Text.getText().toString());

        startActivity(intent);
    }
}