package com.sst.template.view.dialog;

import android.content.Context;

/**
 * @author LongHV.
 */

public class DialogFactory {

    public static void showDialogLoading(final Context context) {
        LoadingDialog loadingDialog = new LoadingDialog(context);
        loadingDialog.show();
    }

}
