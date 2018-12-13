package com.innvandoapps.library.factugrafialibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
}
