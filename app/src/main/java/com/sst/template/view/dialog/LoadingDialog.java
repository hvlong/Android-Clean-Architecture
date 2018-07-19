package com.sst.template.view.dialog;

import android.content.Context;
import android.os.Bundle;

import com.sst.template.R;

/**
 * @author LongHV.
 */
public class LoadingDialog extends BaseDialog {

    LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.loading_dialog;
    }
}
