package com.example.month_test.xxxxmodel;

import com.example.month_test.xxxxcontract.Contract;

import Api.ApiManager;
import Bean.FoodBean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Model implements Contract.Model {
    @Override
    public Subscription getFoodData(Subscriber<FoodBean> beanSubscriber) {
        Observable<FoodBean> homedata=ApiManager.getFoodData();
        Subscription subscription=homedata.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(beanSubscriber);
        return subscription;
    }
}
