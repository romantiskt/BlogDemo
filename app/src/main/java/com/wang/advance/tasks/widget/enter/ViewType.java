package com.wang.advance.tasks.widget.enter;

/**
 * Created by wangyang on 2017/9/13.
 */

public enum ViewType {
    AnnularView("AnnularView"),
    BrickView("BrickView"),
    CustomView1("CustomView1"),
    CustomView2("CustomView2"),
    CustomView3("CustomView3"),
    CustomView4("CustomView4"),
    CustomView5("CustomView5"),
    CustomView6("CustomView6"),
    MatrixImageView("MatrixImageView"),
    MultiCricleView("MultiCricleView"),
    ShaderView("ShaderView"),
    LoadingIndicatorView("LoadingIndicatorView"),
    CircleView("CircleView");
    private String typeName;

    ViewType(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 根据类型的名称，返回类型的枚举实例。
     *
     * @param typeName 类型名称
     */
    public static ViewType fromTypeName(String typeName) {
        for (ViewType type : ViewType.values()) {
            if (type.getTypeName().equals(typeName)) {
                return type;
            }
        }
        return null;
    }

    public String getTypeName() {
        return this.typeName;
    }
}
