package vrjulianti.uts.zomatokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CategoryView {

    private lateinit var categoryPresenter: CategoryPresenter
    private lateinit var categoryAdapter: CategoryAdapter
    private var datas: MutableList<Category> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryPresenter = CategoryPresenter(this, this)
        categoryPresenter.onFecthingData()

        categoryAdapter = CategoryAdapter(this, datas)
        rv_category.layoutManager = LinearLayoutManager(this)
        rv_category.adapter = categoryAdapter
    }


    override fun getData(data: List<Category>?) {
        data?.let { datas.addAll(it) }
    }
}
