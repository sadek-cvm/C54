package com.example.projetpetitionnaire;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class TroisiemeFragment extends Fragment {

    private String mParam1;
    private String mParam2;

    private EditText texteAge;
    private CheckBox checkBox;

    public TroisiemeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup )inflater.inflate(R.layout.fragment_troisieme, container, false);

        texteAge = rootView.findViewById(R.id.texteAge);
        checkBox = rootView.findViewById(R.id.checkBox);
        Ecouteur ec = new Ecouteur();
        checkBox.setOnCheckedChangeListener(ec);
        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();

        Membre.Builder m =((ConteneurFragmentsActivity) getActivity()).getM();


        if ( checkBox.isChecked())
            m.setAge(Integer.parseInt(texteAge.getText().toString()));


    }

    private class Ecouteur implements CompoundButton.OnCheckedChangeListener
    {



        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if ( b)
                texteAge.setEnabled(true);
            else
                texteAge.setEnabled(false);
        }
    }
}