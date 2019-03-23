package com.example.month_test.xxxxpresenter;

import com.example.month_test.xxxxcontract.Contract;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class Presenter implements Contract.Presenter {
protected CompositeSubscription compositeSubscription;

 public  void  OnunSubscribe()
 {
     if (compositeSubscription!=null&&compositeSubscription.hasSubscriptions())
     {
         compositeSubscription.unsubscribe();
     }
 }

 public  void  addSunscribe(Subscription subscription)
 {
     if (compositeSubscription==null) {
     compositeSubscription=new CompositeSubscription();
     }
     compositeSubscription.add(subscription);
 }
 }


