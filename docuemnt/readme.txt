1:实现IResponseProcess，IRequestProcess，MessageService
	在实现类里面做真正的业务
	并且在weixin.properties中做好配置
2:在web.xml中配置好MessageServlet
    <servlet>  
        <servlet-name>messageServlet</servlet-name>  
        <servlet-class>  
            com.mawujun.message.servlet.CoreServlet  
        </servlet-class> 
        <!--初始化的配置文件 -->
        <init-param> 
		<param-name>config_file_path</param-name> 
		<param-value>weixin.properties</param-value> 
		</init-param>  
    </servlet>  
  
    <!-- url-pattern中配置的/coreServlet用于指定该Servlet的访问路径 -->  
    <servlet-mapping>  
        <servlet-name>messageServlet</servlet-name>  
        <url-pattern>/messageServlet</url-pattern>  
    </servlet-mapping>
 3:框架默认是7000秒去获取accesstoken一次，这个值可以自定义