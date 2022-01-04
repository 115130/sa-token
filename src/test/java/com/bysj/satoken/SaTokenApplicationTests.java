package com.bysj.satoken;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.bysj.satoken.entity.User;
import com.bysj.satoken.service.IAuthorityService;
import com.bysj.satoken.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;

@SpringBootTest
class SaTokenApplicationTests {

    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/bysj", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("yangjiahui") // 设置作者
                            .enableSwagger()// 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/home/miao/code/java/sa-token/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.bysj") // 设置父包名
                            .moduleName("satoken") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/home/miao/code/java/sa-token/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_authority","t_commute_record","t_commute_limit","t_user_info","t_user") // 设置需要生成的表名
                            .addTablePrefix("t_");
                            //.addFieldPrefix("t_","u_");
                    // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    @Resource
    IUserService userService;

    @Resource
    IAuthorityService authorityService;

    @Test
    public void t(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email","admin");
        User one = userService.getOne(queryWrapper);
        System.out.println(one);
    }

    @Test
    void t1(){
        System.out.println(authorityService.getPermissionByUserId("1"));
    }



}
