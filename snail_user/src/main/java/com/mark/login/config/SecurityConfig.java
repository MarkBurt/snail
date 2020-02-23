package com.mark.login.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description :  Servlet组件扫描
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 01:31$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 01:31$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */

@Configuration
@ServletComponentScan("com.mark.common.web.app.security")
public class SecurityConfig {
}
