package com.example.month_test.xxxxcontract;

import Bean.FoodBean;
import rx.Subscriber;
import rx.Subscription;

public interface Contract {
    interface Model {
 Subscription getFoodData(Subscriber<FoodBean> beanSubscriber);
    }

    interface View {
     void loadData(FoodBean foodBean);
    }

    interface Presenter {
    }
}
