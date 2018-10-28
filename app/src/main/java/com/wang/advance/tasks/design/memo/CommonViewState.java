package com.wang.advance.tasks.design.memo;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class CommonViewState extends View.BaseSavedState {
    public boolean enable;

    public String text;

    CommonViewState(Parcelable superState) {
        super(superState);
    }

    private CommonViewState(Parcel in) {
        super(in);
        enable = in.readInt() == 1;
        text = in.readString();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(enable ? 1 : 0);
        out.writeString(text);
    }

    public static final Parcelable.Creator<CommonViewState> CREATOR =
            new Parcelable.Creator<CommonViewState>() {
                @Override
                public CommonViewState createFromParcel(Parcel in) {
                    return new CommonViewState(in);
                }

                @Override
                public CommonViewState[] newArray(int size) {
                    return new CommonViewState[size];
                }
            };
}
