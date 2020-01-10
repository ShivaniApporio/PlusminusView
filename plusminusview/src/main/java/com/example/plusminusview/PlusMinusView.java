package com.example.plusminusview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlusMinusView extends LinearLayout {

    private Context mContext ;
    private Button plus , minus ;
    private TextView value ;

    public static String PLUS = "plus";
    public static String MINUS = "minus";


    private OnPlusMinusClickListeners onPlusMinusClickListeners ;



    public PlusMinusView(Context context) {
        super(context);
        initializeView(context);
    }

    public PlusMinusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public PlusMinusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context);
    }

    @SuppressLint("NewApi")
    public PlusMinusView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeView(context);
    }


    private void initializeView(Context context ){
        this.mContext = context ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_layout, this);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        try{
           plus = findViewById(R.id.plus);
           minus = findViewById(R.id.minus);
           value = findViewById(R.id.value);


           setOnClickListeners ();


        }catch (Exception e){

        }
    }


    public void setInterface (OnPlusMinusClickListeners onPlusMinusClickListeners){
        this.onPlusMinusClickListeners = onPlusMinusClickListeners ;
    }



    private void setOnClickListeners(){
        plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                value.setText(""+ (Integer.parseInt(""+value.getText().toString())  +  1));
                onPlusMinusClickListeners.onButtonTypeClicked(PLUS);
            }
        });


        minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                value.setText(""+ (Integer.parseInt(""+value.getText().toString())  +  1));
                onPlusMinusClickListeners.onButtonTypeClicked(PLUS);
            }
        });




    }


    public String getValue(){
        return value.getText().toString() ;
    }


    public interface OnPlusMinusClickListeners{
        void onButtonTypeClicked(String type);
    }



}
