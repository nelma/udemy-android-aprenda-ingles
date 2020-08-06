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
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonOne;
    private ImageButton buttonTwo;
    private ImageButton buttonThree;
    private ImageButton buttonFour;
    private ImageButton buttonFive;
    private ImageButton buttonSix;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);


        buttonOne = view.findViewById(R.id.buttonOne);
        buttonTwo = view.findViewById(R.id.buttonTwo);
        buttonThree = view.findViewById(R.id.buttonThree);
        buttonFour = view.findViewById(R.id.buttonFour);
        buttonFive = view.findViewById(R.id.buttonFive);
        buttonSix = view.findViewById(R.id.buttonSix);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonOne:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                play();
                break;
            case R.id.buttonTwo:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                play();
                break;
            case R.id.buttonThree:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                play();
                break;
            case R.id.buttonFour:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                play();
                break;
            case R.id.buttonFive:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                play();
                break;
            case R.id.buttonSix:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
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
