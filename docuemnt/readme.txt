1:实现IResponseProcess，IRequestProcess，MessageService用来接收消息，这些都是被动回复消息，类似于自动回复
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
 3:AccessTokenCache接口是用来缓存AccessToken的，可以实现这个接口，来吧AccessToken放到数据库中.默认实现DefaultAccessCache是放在缓存中的