package annotation;

import com.example.customannotation.GzhFragment;
import com.example.customannotation.PyqFragment;
import com.example.customannotation.SearchConstant;
import com.example.customannotation.SphFragment;
import com.example.customannotation.XcxFragment;

public enum SearchEnum {
    DEFAULT(PyqFragment.class, SearchConstant.DEFAULT, "默认fragment"),
    PYQ(PyqFragment.class, SearchConstant.PYQ, "朋友圈"),
    GZH(GzhFragment.class, SearchConstant.GZH, "公众号"),
    XCX(XcxFragment.class, SearchConstant.XCX, "小程序"),
    SPH(SphFragment.class, SearchConstant.SPH, "视频号");

    public Class clazz;
    public String type;
    public String hint;

    SearchEnum(Class clazz, String type, String hint) {
        this.clazz = clazz;
        this.type = type;
        this.hint = hint;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getHint() {
        return hint;
    }

    public String getType() {
        return type;
    }
}
