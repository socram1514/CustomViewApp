package com.innvandoapps.library.factugrafialibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NroFacturaView extends LinearLayout {

    private EditText edtNrosFact1;
    private EditText edtNrosFact2;
    private EditText edtNrosFact3;

    public NroFacturaView(Context context) {
        super(context);
        init();
    }

    public NroFacturaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(infService);
        layoutInflater.inflate(R.layout.nro_factura_view,this, true);

        edtNrosFact1 = (EditText)findViewById(R.id.edtNrosFact1);
        edtNrosFact2 = (EditText)findViewById(R.id.edtNrosFact2);
        edtNrosFact3 = (EditText)findViewById(R.id.edtNrosFact3);

        asignarEventos();
    }

    public String getNroFactura(){
        return edtNrosFact1.getText().toString() + edtNrosFact2.getText().toString() + edtNrosFact3.getText().toString();
    }

    public String getNroEstablecimiento(){
        return edtNrosFact1.getText().toString();
    }

    public String getNroPuntoExpedicion(){
        return edtNrosFact2.getText().toString();
    }

    public String getNroDocumento(){
        return edtNrosFact3.getText().toString();
    }

    public boolean validar(){
        if(edtNrosFact1.getText().toString().equals("")||
           edtNrosFact2.getText().toString().equals("")||
           edtNrosFact3.getText().toString().equals("")){
            return false;
        }

        if(edtNrosFact1.getText().toString().equals("000")||
           edtNrosFact2.getText().toString().equals("000")||
           edtNrosFact3.getText().toString().equals("0000000")){
            return false;
        }
        return true;
    }

    private String agregarCeros(int longreal,int longmax){
        String resul="";
        for(int i=0;i<(longmax-longreal);i++){
            resul=resul+"0";
        }
        return resul;
    }

    private void asignarEventos(){
        edtNrosFact1.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(edtNrosFact1.getText().toString().length()<3){
                        edtNrosFact1.setText(agregarCeros(edtNrosFact1.getText().toString().length(), 3)+ edtNrosFact1.getText().toString());
                    }
                }else{
                    edtNrosFact1.setText("");
                }
            }
        });
        edtNrosFact2.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(edtNrosFact2.getText().toString().length()<3){
                        edtNrosFact2.setText(agregarCeros(edtNrosFact2.getText().toString().length(), 3)+ edtNrosFact2.getText().toString());
                    }
                }else{
                    edtNrosFact2.setText("");
                }
            }
        });
        edtNrosFact3.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(edtNrosFact3.getText().toString().length()<7){
                        edtNrosFact3.setText(agregarCeros(edtNrosFact3.getText().toString().length(), 7)+ edtNrosFact3.getText().toString());
                    }
                }else{
                    edtNrosFact3.setText("");
                }
            }
        });
    }
}
