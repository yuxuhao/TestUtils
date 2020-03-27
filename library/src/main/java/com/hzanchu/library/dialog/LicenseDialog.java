package com.hzanchu.library.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hzanchu.library.R;
import com.hzanchu.library.utils.DisplayUtils;
import com.hzanchu.library.utils.ShapeCreator;
import com.lxj.xpopup.core.BottomPopupView;

import java.util.ArrayList;
import java.util.List;

public class LicenseDialog extends BottomPopupView {

    private LinearLayout linearLayout;
    private Context mContext;
    private List<String> provinceList;
    List<String> strings;
    private GridLayout gridLayout;
    private int item1;

    public LicenseDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.layout_license_dialog;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        linearLayout = findViewById(R.id.linear);
        header();
    }

    //第一个位置的省数据
    private List<String> provinceList() {
        provinceList = new ArrayList<>();
        provinceList.clear();
        provinceList.add("京");
        provinceList.add("津");
        provinceList.add("沪");
        provinceList.add("渝");
        provinceList.add("蒙");
        provinceList.add("新");
        provinceList.add("藏");
        provinceList.add("宁");
        provinceList.add("桂");
        provinceList.add("黑");

        provinceList.add("吉");
        provinceList.add("辽");
        provinceList.add("晋");
        provinceList.add("冀");
        provinceList.add("青");
        provinceList.add("鲁");
        provinceList.add("豫");
        provinceList.add("苏");
        provinceList.add("皖");
        provinceList.add("浙");

        provinceList.add("闽");
        provinceList.add("赣");
        provinceList.add("湘");
        provinceList.add("鄂");
        provinceList.add("粤");
        provinceList.add("琼");
        provinceList.add("甘");
        provinceList.add("陕");
        provinceList.add("贵");
        provinceList.add("云");

        provinceList.add("川");
        provinceList.add("删除");
        return provinceList;
    }

    private List<String> getEnglishNumbers() {
        provinceList = new ArrayList<>();
        provinceList.clear();
        provinceList.add("1");
        provinceList.add("2");
        provinceList.add("3");
        provinceList.add("4");
        provinceList.add("5");
        provinceList.add("6");
        provinceList.add("7");
        provinceList.add("8");
        provinceList.add("9");
        provinceList.add("0");

        provinceList.add("A");
        provinceList.add("B");
        provinceList.add("C");
        provinceList.add("D");
        provinceList.add("E");
        provinceList.add("F");
        provinceList.add("G");
        provinceList.add("H");
        provinceList.add("J");
        provinceList.add("K");

        provinceList.add("L");
        provinceList.add("M");
        provinceList.add("N");
        provinceList.add("P");
        provinceList.add("Q");
        provinceList.add("R");
        provinceList.add("S");
        provinceList.add("T");
        provinceList.add("U");
        provinceList.add("V");
        provinceList.add("W");
        provinceList.add("X");
        provinceList.add("Y");
        provinceList.add("Z");

        provinceList.add("删除");
        return provinceList;
    }

    @Override
    protected int getMaxHeight() {
        return (DisplayUtils.getEdgeScreenWidth(mContext) - 90) / 10 * 5;
    }

    private LicenseProvinceListener listener;

    public void setListener(LicenseProvinceListener listener) {
        this.listener = listener;
    }

    public interface LicenseProvinceListener {
        void getProvince(String tv, boolean isDelete);

    }

    public void setSwitch(boolean tag) {
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (tag) {
            header();
        } else {
            foot();
        }

    }

    /**
     * 区域地名键盘
     */
    private void header() {
        gridLayout = new GridLayout(mContext);
        gridLayout.setOrientation(GridLayout.HORIZONTAL);
        gridLayout.setColumnCount(10);
        int edgeScreenWidth = DisplayUtils.getEdgeScreenWidth(mContext);
        int i1 = (edgeScreenWidth - 110) / 10;

        strings = provinceList();
        gridLayout.removeAllViews();
        for (int i = 0; i < strings.size(); i++) {
            final int finalI = i;
            TextView textView = new TextView(mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i1, i1);
            layoutParams.setMargins(10, 10, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            ShapeCreator.create()
                    .setCornerRadius(3)
                    .setSolidColor(mContext.getResources().getColor(R.color.color_FFFFFF))
                    .into(textView);
            textView.setText(provinceList().get(i));

            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.getProvince(provinceList().get(finalI), (strings.size() - 1) == finalI ? true : false);

                }
            });
            gridLayout.addView(textView);
        }
        linearLayout.addView(gridLayout);
    }

    /**
     * 英文数字键盘
     */
    private void foot() {
        gridLayout = new GridLayout(mContext);
        gridLayout.setOrientation(GridLayout.HORIZONTAL);
        gridLayout.setColumnCount(10);
        int edgeScreenWidth = DisplayUtils.getEdgeScreenWidth(mContext);
        int i1 = (edgeScreenWidth - 110) / 10;

        strings = getEnglishNumbers();
        gridLayout.removeAllViews();
        for (int i = 0; i < strings.size(); i++) {
            final int finalI = i;

            TextView textView = new TextView(mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i1, i1);
            layoutParams.setMargins(10, 10, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            ShapeCreator.create()
                    .setCornerRadius(2)
                    .setSolidColor(mContext.getResources().getColor(R.color.color_FFFFFF))
                    .into(textView);
            textView.setText(getEnglishNumbers().get(i));

            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.getProvince(getEnglishNumbers().get(finalI), (strings.size() - 1) == finalI ? true : false);

                }
            });
            gridLayout.addView(textView);
        }
        linearLayout.addView(gridLayout);
    }
}
