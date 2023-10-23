package com.example.projetpetitionnaire;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FinFragment extends Fragment {


    private String mParam1;
    private String mParam2;

    private Button boutonSauv;

    public FinFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup )inflater.inflate(R.layout.fragment_fin, container, false);

        boutonSauv = rootView.findViewById(R.id.boutonSauvegarder);
        Ecouteur ec = new Ecouteur();
        boutonSauv.setOnClickListener(ec);
        return rootView;
    }

    private class Ecouteur implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            // sauvegarder ds fichier de sérialisation
            Membre membre = ((ConteneurFragmentsActivity)getActivity()).getM().build();
            try(
                    FileOutputStream fos = getActivity().openFileOutput("fichier.ser", Context.MODE_PRIVATE);
                    ObjectOutputStream oss = new ObjectOutputStream(fos);
                    )
            {
                oss.writeObject(membre);
                getActivity().finish();
            }
            catch( Exception e){
                e.printStackTrace();
            }

        }
    }
}