package vrjulianti.uts.zomatokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_restaurant.view.*
import org.jetbrains.anko.intentFor

class RestaurantAdapter (private val context: Context, private val data: List<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bindItems(context, data[position], position)
    }

    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindItems(context: Context, restaurant: Restaurant, position: Int) {

            restaurant.imageUrl.let {
                Glide.with(context).load(it).asBitmap().into(containerView.poster_image)
            }
            containerView.textview_title.text = restaurant.title
            containerView.textview_location.text = restaurant.location
            containerView.textview_type.text = restaurant.type
            containerView.textview_price.text = restaurant.price
            containerView.textview_rating.text = restaurant.rating

            containerView.setOnClickListener {

                context.startActivity(context.intentFor<DetailRestaurantActivity>(
                    "title" to restaurant.title,
                    "location" to restaurant.location,
                    "type" to restaurant.type,
                    "price" to restaurant.price,
                    "rating" to restaurant.rating,
                    "image" to restaurant.imageUrl
                ))

            }

        }
    }
}