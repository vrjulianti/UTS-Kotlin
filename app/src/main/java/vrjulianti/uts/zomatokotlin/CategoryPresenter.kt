package vrjulianti.uts.zomatokotlin

import android.content.Context
import org.jetbrains.anko.doAsync
import android.app.Activity
import org.jetbrains.anko.uiThread


class CategoryPresenter(
    val context: Context,
    val view: CategoryView
) {

    fun onFecthingData() {

        val res = context.resources

        val title = res.getStringArray(R.array.category_title)
        val outlet = res.getStringArray(R.array.category_outlet)
        val detail = res.getStringArray(R.array.category_detail)
        val imageUrl = res.getStringArray(R.array.category_imageUrl)
        val datas: MutableList<Category> = mutableListOf()

        title.indices.forEach { i ->
            datas.add(Category(title[i], outlet[i], detail[i], imageUrl[i]))
        }
        view.getData(datas)

    }

}