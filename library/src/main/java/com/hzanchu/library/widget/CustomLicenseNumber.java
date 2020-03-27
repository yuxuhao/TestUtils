package com.hzanchu.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzanchu.library.R;
import com.hzanchu.library.dialog.LicenseDialog;
import com.hzanchu.library.utils.DisplayUtils;
import com.hzanchu.library.utils.ShapeCreator;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import java.util.ArrayList;
import java.util.List;

public class CustomLicenseNumber extends RelativeLayout {
    private LinearLayout linear;
    private TextView tvXny;
    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvThree;
    private TextView tvFour;
    private TextView tvFive;
    private TextView tvSix;
    private TextView tvSeven;
    private TextView tvEight;
    private List<TextView> textList;
    private int tag = 1;
    private int number = 9;
    private BasePopupView basePopupView;
    private LicenseDialog popupView;
    private String numOne="",numTwo="",numThree="",numFour="",numFive="",numSix="",numSeven="",numEight="";
    public CustomLicenseNumber(Context context) {
        super(context);
        init();
    }

    public CustomLicenseNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), R.layout.layout_custom_liceeensee, this);
        linear = inflate.findViewById(R.id.linear);
        tvXny = inflate.findViewById(R.id.tv_xny);
        tvOne = inflate.findViewById(R.id.tv_one);
        tvTwo = inflate.findViewById(R.id.tv_two);
        tvThree = inflate.findViewById(R.id.tv_three);
        tvFour = inflate.findViewById(R.id.tv_four);
        tvFive = inflate.findViewById(R.id.tv_five);
        tvSix = inflate.findViewById(R.id.tv_six);
        tvSeven = inflate.findViewById(R.id.tv_seven);
        tvEight = inflate.findViewById(R.id.tv_eight);

        textList = new ArrayList<>();
        textList.add(tvOne);
        textList.add(tvTwo);
        textList.add(tvThree);
        textList.add(tvFour);
        textList.add(tvFive);
        textList.add(tvSix);
        textList.add(tvSeven);
        textList.add(tvEight);

        for (int i = 0; i < textList.size(); i++) {
            if ((textList.size() - 1) == i) {
                ShapeCreator.create()
                        .setCornerRadius(2)
                        .setStrokeColor(this.getResources().getColor(R.color.color_4F4F4F))
                        .setStrokeWidth(1)
                        .setSolidColor(this.getResources().getColor(R.color.color_orange_FF18B24F))
                        .into(textList.get(i));
            } else {
                shapUnll(textList.get(i));
            }

        }
        popupView = new LicenseDialog(getContext());
        popupView.setMinimumHeight((DisplayUtils.getEdgeScreenWidth(getContext()) - 90) / 10);
        basePopupView = new XPopup.Builder(getContext())
                .asCustom(popupView);
        popupView.setListener(new LicenseDialog.LicenseProvinceListener() {
            @Override
            public void getProvince(String tv, boolean isDelete) {
                if (isDelete) {
                    butDelete();
                } else {
                    butAdd(tv);
                }
            }
        });
        linear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                basePopupView.show();
            }
        });

    }

    private void butDelete() {
        if (tag > 0) {
            tag -= 1;
            listTextDelete(tag);
            switch (tag) {
                case 1:
                    tvOne.setText("");
                    numOne="";
                    popupView.setSwitch(true);
                    break;
                case 2:
                    numTwo="";
                    tvTwo.setText("");
                    break;
                case 3:
                    numThree="";
                    tvThree.setText("");
                    break;
                case 4:
                    numFour="";
                    tvFour.setText("");
                    break;
                case 5:
                    numFive="";
                    tvFive.setText("");
                    break;
                case 6:
                    numSix="";
                    tvSix.setText("");
                    break;
                case 7:
                    numSeven="";
                    tvSeven.setText("");
                    break;
                case 8:
                    numEight="";
                    tvEight.setText("");
                    break;
            }

        }
    }

    private void butAdd(String tv) {
        if (tag < number) {
            if (tag == 0) {
                tag += 1;
            }
            listTextAdd(tag);
            switch (tag) {
                case 1:
                    tvOne.setText(tv);
                    numOne=tv;
                    popupView.setSwitch(false);
                    break;
                case 2:
                    numTwo=tv;
                    tvTwo.setText(tv);
                    break;
                case 3:
                    numThree=tv;
                    tvThree.setText(tv);
                    break;
                case 4:
                    numFour=tv;
                    tvFour.setText(tv);
                    break;
                case 5:
                    numFive=tv;
                    tvFive.setText(tv);
                    break;
                case 6:
                    numSix=tv;
                    tvSix.setText(tv);
                    break;
                case 7:
                    numSeven=tv;
                    tvSeven.setText(tv);
                    break;
                case 8:
                    numEight=tv;
                    tvEight.setText(tv);
                    basePopupView.dismiss();
                    break;
            }
            tag += 1;
        }
    }


    private void listTextAdd(int id) {
        for (int i = 0; i < textList.size(); i++) {
            if ((i + 1) == id) {
                if ((textList.size()) == id) {
                    ShapeCreator.create()
                            .setCornerRadius(2)
                            .setStrokeWidth(1)
                            .setStrokeColor(this.getResources().getColor(R.color.color_FB453A))
                            .setSolidColor(this.getResources().getColor(R.color.color_orange_FF18B24F))
                            .into(tvEight);
                } else {
                    shapData(textList.get(i));

                }

            } else {
                if ((textList.size() - 1) == i) {
                    ShapeCreator.create()
                            .setCornerRadius(2)
                            .setStrokeColor(this.getResources().getColor(R.color.color_4F4F4F))
                            .setStrokeWidth(1)
                            .setSolidColor(this.getResources().getColor(R.color.color_orange_FF18B24F))
                            .into(textList.get(i));
                } else {
                    shapUnll(textList.get(i));
                }

            }
        }
    }

    private void listTextDelete(int id) {
        for (int i = 0; i < textList.size(); i++) {
            if (i + 1 == id - 1) {
                shapData(textList.get(i));
            } else {
                if((textList.size()-1)==i){
                    ShapeCreator.create()
                            .setCornerRadius(2)
                            .setStrokeColor(this.getResources().getColor(R.color.color_4F4F4F))
                            .setStrokeWidth(1)
                            .setSolidColor(this.getResources().getColor(R.color.color_orange_FF18B24F))
                            .into(textList.get(i));
                }else {
                    shapUnll(textList.get(i));
                }

            }
        }
    }

    private void shapUnll(TextView textView) {
        ShapeCreator.create()
                .setCornerRadius(2)
                .setStrokeColor(this.getResources().getColor(R.color.color_4F4F4F))
                .setStrokeWidth(1)
                .setSolidColor(this.getResources().getColor(R.color.color_FFFFFF))
                .into(textView);
    }

    private void shapData(TextView textView) {
        ShapeCreator.create()
                .setCornerRadius(2)
                .setStrokeWidth(1)
                .setStrokeColor(this.getResources().getColor(R.color.color_FB453A))
                .setSolidColor(this.getResources().getColor(R.color.color_FFFFFF))
                .into(textView);
    }

    public String getCarNumber(){
        String str=numOne+numTwo+numThree+numFour+numFive+numSix+numSeven+numEight;
        return str;
    }
}
