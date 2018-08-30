package org.spring.springboot.orm.mybatis.mapper.genid;

import java.util.UUID;

import tk.mybatis.mapper.genid.GenId;

/**
 *  UUID 的实现类
 * @author chen haifeng
 *
 */
public class UUIdGenId implements GenId<String> {
    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString();
    }
}
