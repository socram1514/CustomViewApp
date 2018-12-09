package com.innovandoapps.library.customviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomRounedEditText extends LinearLayout {

    private TextView txttitulo;
    private EditText edtCuadroTxt;

    private boolean mshowTitle;
    private String title;

    public CustomRounedEditText(Context context) {
        super(context);
        init();
    }

    public CustomRounedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomRounedEditText, 0, 0);
        try {
            mshowTitle = a.getBoolean(R.styleable.CustomRounedEditText_showTitle, true);
            title = a.getString(R.styleable.CustomRounedEditText_stringTitle);
        }finally {
            a.recycle();
        }

        if(title == null){
            title = "";
        }

        init();
    }

    private void init(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(infService);
        layoutInflater.inflate(R.layout.rouned_focus_custom_edittex,this, true);

        txttitulo = (TextView)findViewById(R.id.txttitulo);
        edtCuadroTxt = (EditText)findViewById(R.id.edtCuadroTxt);

        if(!mshowTitle){
            txttitulo.setVisibility(GONE);
        }else{
            txttitulo.setVisibility(VISIBLE);
            txttitulo.setText(title);
        }

        asignarEventos();
    }

    private void asignarEventos(){
        edtCuadroTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public String getText(){
        return edtCuadroTxt.getText().toString();
    }
}
