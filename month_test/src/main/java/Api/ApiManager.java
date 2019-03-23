package Api;

import Bean.FoodBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ApiManager {
    public static int id=1;
    public static int limit=20;
    public static int page=1;

    private static final String HomeUrl="http://www.qubaobei.com/ios/cf/";
    private static final Retrofit retrofit=new Retrofit.Builder().baseUrl(HomeUrl).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    private  static  final  APiService SERVICE=retrofit.create(APiService.class);

    public static Observable<FoodBean> getFoodData()
    {
        return  SERVICE.getFoodData(id,limit,page);
    }

}
