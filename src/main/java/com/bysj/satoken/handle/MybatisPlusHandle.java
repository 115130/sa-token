package com.bysj.satoken.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MybatisPlusHandle implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.error("新增注入开始");
        this.strictInsertFill(metaObject, "gmtModified", Date::new, Date.class);
        this.strictInsertFill(metaObject, "gmtCreate", Date::new, Date.class);
        this.fillStrategy(metaObject,"isDeleted",0);
    }



    @Override
    public void updateFill(MetaObject metaObject) {
        log.error("更新注入开始");
        this.strictInsertFill(metaObject, "gmtModified", Date::new, Date.class);
    }
}
