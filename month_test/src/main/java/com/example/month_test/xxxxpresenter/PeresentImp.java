package com.example.month_test.xxxxpresenter;

import android.util.Log;

import com.example.month_test.xxxxcontract.Contract;
import com.example.month_test.xxxxmodel.Model;

import Api.ApiManager;
import Bean.FoodBean;
import rx.Subscriber;

public class PeresentImp extends HomePresenter {
    private Contract.View view;
    private Model model;

    public PeresentImp(Contract.View view) {
        this.view=view;
        this.model=new Model();
    }

    Subscriber<FoodBean> subscriber=new Subscriber<FoodBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e("onError","请求失败");
        }

        @Override
        public void onNext(FoodBean foodBean) {
            Log.e("OnNext","我已经请求到网络数据");
            view.loadData(foodBean);
        }
    };

    @Override
    public void loadData() {
        addSunscribe(model.getFoodData(subscriber));
    }
}
