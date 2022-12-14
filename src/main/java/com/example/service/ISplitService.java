package com.example.service;

import java.io.IOException;

/**
 * @author ckn
 */
public interface ISplitService {
    /**
     * 拆分Ims search简单sql
     * @param configChineseName sql目录下的文件名(XXXX.sql)
     * @throws IOException
     */
    void split(String configChineseName) throws IOException;
}
