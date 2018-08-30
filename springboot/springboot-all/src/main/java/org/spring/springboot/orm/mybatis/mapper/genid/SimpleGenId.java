package org.spring.springboot.orm.mybatis.mapper.genid;

import tk.mybatis.mapper.genid.GenId;

public class SimpleGenId implements GenId<Long> {
    private Long    time;
    private Integer seq;

    @Override
    public synchronized Long genId(String table, String column) {
        long current = System.currentTimeMillis();
        if (time == null || time != current) {
            time = current;
            seq = 1;
        } else if (current == time) {
            seq++;
        }
        return (time << 20) | seq;
    }
}
