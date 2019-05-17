package vrjulianti.uts.zomatokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity(), RestaurantView {

    private var datas: MutableList<Restaurant> = mutableListOf()
    private lateinit var restaurantAdapter: RestaurantAdapter
    private lateinit var restaurantPresenter: RestaurantPresenter
    private lateinit var category: Category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        category = Category(
            intent.getStringExtra("title"), intent.getStringExtra("outlet"),
            intent.getStringExtra("detail"), intent.getStringExtra("image")
        )

        Glide.with(this).load(category.imageUrl).asBitmap().into(imageHeader)
        textview_category.text = category.title
        textview_outlet.text = category.outlet
        textview_detail.text = category.detail

        restaurantPresenter = RestaurantPresenter(this, this)
        restaurantPresenter.onFetchingData()

        restaurantAdapter = RestaurantAdapter(this, datas)
        rv_restaurant.layoutManager = GridLayoutManager(this, 2)
        rv_restaurant.adapter = restaurantAdapter
    }

    override fun getData(data: List<Restaurant>?) {

        data?.let {
            datas.addAll(it)
        }
    }
}