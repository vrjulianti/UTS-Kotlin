package vrjulianti.uts.zomatokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_category.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import java.text.FieldPosition

class CategoryAdapter(val context: Context, val data: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bindItems(context, data[position], position)
    }


    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindItems(context: Context, category: Category, position: Int) {

            containerView.textview_category.text = category.title
            containerView.textview_outlet.text = category.outlet
            containerView.textview_detail.text = category.detail


            category.imageUrl.let {
                Glide.with(context).load(it).asBitmap().into(containerView.poster_image)
            }

            containerView.setOnClickListener {
                context.startActivity(
                    context.intentFor<RestaurantActivity>(
                        "title" to category.title,
                        "outlet" to category.outlet,
                        "detail" to category.detail,
                        "image" to category.imageUrl
                    )
                )

            }
        }
    }
}