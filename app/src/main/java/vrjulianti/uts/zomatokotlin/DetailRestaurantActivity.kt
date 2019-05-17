package vrjulianti.uts.zomatokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_restaurant.*

class DetailRestaurantActivity : AppCompatActivity() {

    private lateinit var restaurant: Restaurant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_restaurant)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        restaurant = Restaurant(
            intent.getStringExtra("title"),
            intent.getStringExtra("location"),
            intent.getStringExtra("type"),
            intent.getStringExtra("price"),
            intent.getStringExtra("rating"),
            intent.getStringExtra("image")
        )


        Glide.with(this).load(restaurant.imageUrl).asBitmap().into(imagePoster)
        textview_det_title.text = restaurant.title
        textview_det_location.text = restaurant.location
        textview_det_type.text = restaurant.type
        textview_det_price.text = restaurant.price
        textview_det_rating.text = restaurant.rating
    }
}
