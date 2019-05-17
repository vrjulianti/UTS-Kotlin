package vrjulianti.uts.zomatokotlin

import android.content.Context

class RestaurantPresenter (val context : Context, val view : RestaurantView) {

    fun onFetchingData(){

        val res = context.resources

        val title = res.getStringArray(R.array.res_title)
        val location = res.getStringArray(R.array.res_location)
        val type = res.getStringArray(R.array.res_type)
        val price = res.getStringArray(R.array.res_price)
        val rating = res.getStringArray(R.array.res_rating)
        val imageUrl = res.getStringArray(R.array.res_imageUrl)

        val datas: MutableList<Restaurant> = mutableListOf()

        title.indices.forEach { i ->
            datas.add(Restaurant(title[i], location[i], type[i], price[i], rating[i], imageUrl[i]))
        }

        view.getData(datas)

    }
}
