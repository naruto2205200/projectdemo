package com.example.demo.utils;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/7/1611:24
 */
public interface CLibrary extends Library {
    CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "Newtonsoft.Json" : "c"), CLibrary.class);
    void ToString(String value);

}
