package com.choose_gold.baserecyclerviewadapterhelperdemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*** ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 *
 *
 * 项目名称：BaseRecyclerViewAdapterHelperDemo
 * 类描述：com.choose_gold.baserecyclerviewadapterhelperdemo
 * 创建人：kevin
 * 创建时间：2017/9/2
 * 修改人：kevin
 * 修改时间：
 * 修改备注：
 */

public class PullToRefreshAdapter extends BaseQuickAdapter<Status,BaseViewHolder>{
    public PullToRefreshAdapter(@LayoutRes int layoutResId, @Nullable List<Status> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition()% 3){
            case 0:
                helper.setImageResource(R.id.img,R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img,R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img,R.mipmap.animation_img3);
                break;
        }


        helper.setText(R.id.tweetName,"Hoteis in Rio de Janeiro");
        String msg="\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ( (TextView)helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ( (TextView)helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());



    }
    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {

            Toast.makeText(mContext, "事件触发了 landscapes and nedes", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
