package com.ascemme.cookingtime2.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Добрый день, я помогу выбрать блюдо на сегодня)");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
