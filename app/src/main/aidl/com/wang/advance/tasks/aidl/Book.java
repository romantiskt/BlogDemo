package com.wang.advance.tasks.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangyang on 2019/4/17.16:09
 */
public class Book implements Parcelable {

    private String name;
    private int page;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.page);
    }
    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        name = dest.readString();
        page = dest.readInt();
    }


    public Book() {
    }

    protected Book(Parcel in) {
        this.name = in.readString();
        this.page = in.readInt();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
