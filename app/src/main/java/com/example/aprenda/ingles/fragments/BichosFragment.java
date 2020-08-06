package com.example.aprenda.ingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprenda.ingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonDog;
    private ImageButton buttonCat;
    private ImageButton buttonLion;
    private ImageButton buttonMonkey;
    private ImageButton buttonSheep;
    private ImageButton buttonCow;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);


        buttonDog = view.findViewById(R.id.buttonDog);
        buttonCat = view.findViewById(R.id.buttonCat);
        buttonLion = view.findViewById(R.id.buttonLion);
        buttonMonkey = view.findViewById(R.id.buttonMonkey);
        buttonSheep = view.findViewById(R.id.buttonSheep);
        buttonCow = view.findViewById(R.id.buttonCow);


        //this diz que vou tratar o evento de clique na própria classe
        buttonDog.setOnClickListener(this);
        buttonCat.setOnClickListener(this);
        buttonLion.setOnClickListener(this);
        buttonMonkey.setOnClickListener(this);
        buttonSheep.setOnClickListener(this);
        buttonCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.buttonDog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                play();
            break;
            case R.id.buttonCat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                play();
            break;
            case R.id.buttonLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                play();
            break;
            case R.id.buttonMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                play();
            break;
            case R.id.buttonSheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                play();
            break;
            case R.id.buttonCow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                play();
            break;
        }
    }


    private void play() {
        if( mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
