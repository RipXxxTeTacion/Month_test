package Api;

import Bean.FoodBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;

public interface APiService {
    @GET("dish_list.php?")
    Observable<FoodBean> getFoodData(  @Query("stage_id")int id, @Query("limit") int limit, @Query("page")int page);
}
//    @Query("stage_id")int id, @Query("limit") int limit, @Query("page")int page