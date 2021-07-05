package th.kasidet.meteeputthi.linemanwongnai

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import th.kasidet.meteeputthi.linemanwongnai.data.model.Coin

class CoinAdapter(context : Context, coins : List<Coin>, activity : Activity): BaseAdapter(){
    private val mContext : Context = context
    private val mActivity : Activity = activity
    private val coins : List<Coin> = coins

    override fun getCount(): Int {
        return coins.size
    }

    override fun getItem(p0: Int): Any {
        return coins[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
        return if((p0+1) % 5 == 0 && p0 != 0) {
            setViewCustomRowIconRight(layoutInflater, p0, p2)
        } else{
            setViewCustomRowIconLeft(layoutInflater, p0, p2)
        }
    }


    private fun setViewCustomRowIconLeft(layoutInflater : LayoutInflater, p0 : Int, p2 : ViewGroup?): View {
        val customRowIconLeft: View = layoutInflater.inflate(R.layout.custom_row_icon_left, p2, false)

        val nameView = customRowIconLeft.findViewById<TextView>(R.id.name_view)
        val descriptionView = customRowIconLeft.findViewById<TextView>(R.id.description_view)
        val iconView = customRowIconLeft.findViewById<ImageView>(R.id.icon_url_view)
        val uri : Uri = Uri.parse(coins[p0].iconUrl)

        nameView.text = coins[p0].name
        descriptionView.text = coins[p0].description
        GlideToVectorYou.justLoadImage(mActivity, uri, iconView)

        return customRowIconLeft
    }

    private fun setViewCustomRowIconRight(layoutInflater : LayoutInflater, p0 : Int, p2 : ViewGroup?): View {
        val customRowIconRight: View = layoutInflater.inflate(R.layout.custom_row_icon_right, p2, false)
        val nameView = customRowIconRight.findViewById<TextView>(R.id.name_view)
        val iconView = customRowIconRight.findViewById<ImageView>(R.id.icon_url_view)
        val uri : Uri = Uri.parse(coins[p0].iconUrl)
        nameView.text = coins[p0].name
        GlideToVectorYou.justLoadImage(mActivity, uri, iconView)

        return customRowIconRight
    }
}