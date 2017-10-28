package com.example.ruslanio.androidhackaton.fragments;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;

/**
 * Created by Ruslanio on 28.10.2017.
 */

public class NoteView extends BaseFragment {

    public static NoteView getInstance(){
        return new NoteView();
    }
    @Override
    protected int getLayout() {
        return R.layout.fragment_note;
    }
}
