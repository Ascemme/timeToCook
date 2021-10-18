package com.ascemme.cookingtime2.ui.dashboard;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ascemme.cookingtime2.R;
import com.ascemme.cookingtime2.databinding.FragmentDashboardBinding;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kotlin.random.URandomKt;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    List<String> list = new ArrayList<>();
    ImageView iv;
    TextView tv;
    ImageView civ;
    int clickCounter = 0;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_dashboard, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv = getView().findViewById(R.id.imageViewCircler);
        tv =  getView().findViewById(R.id.textDashboard);
        civ = getView().findViewById(R.id.coursorIm);
        tv.setOnClickListener(this);
        iv.setOnClickListener(this);
        edditor();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageViewCircler:
                startAnimation();
                break;
            case R.id.textDashboard:
                clickCounter +=1;
                Text(clickCounter);
                break;
        }
    }

    void Text(int counter){
        switch (counter){
            case 1:
                tv.setText(list.get(0));
                break;
            case 2:
                tv.setText(list.get(1));
                break;
            case 3:
                tv.setText(list.get(2));
                break;
            case 4:
                clickCounter = 0;
                break;
            default: clickCounter=0;
        }

    }
    void edditor(){
        list.add("Добрый день, я помогу выбрать блюдо на сегодня)");
        list.add("Вам необходимо нажать на круг и “рулетка блюд“ запуститься)");
        list.add("Ура, ваш номер блюда “ ” . Переходим в отдел рецептов)");
    }
    private void startAnimation() {

        Random random = new Random();
        int in = random.nextInt( 10000);
        float ivPos = iv.getRotation();
        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(iv, "rotation", ivPos, ivPos + in)
                .setDuration(5000);
        heightAnimator.start();
        ObjectAnimator coursor = ObjectAnimator
                .ofFloat(civ, "rotation",
                        0,-20,-10,-20,-10,-20,-10,-20,-10,-20,-10,-20,-30,
                        -20,-10,-20,-10,-20,-10,-20,-10,-20,-10,-20,-10
                                -20,-10,-20,-10,-20,-10,-20,-10,-20,-10,-20,-10,
                        -20,-10,-20,-10,-20,-10,-20,-10,-20,-10,-20,-10,
                        -20,-10,-20,-10,-20,-10,-20,-10,-20,-10,-20,-10,0)
                .setDuration(5010);
        coursor.start();
        ObjectAnimator textAppearing = ObjectAnimator
                .ofFloat(tv, "alpha",0,1)
                .setDuration(5000);
        textAppearing.start();

    }

}
