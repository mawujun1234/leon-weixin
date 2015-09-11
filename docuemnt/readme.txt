1:实现AbstractResponseProcess，AbstractRequestProcess，MessageService
	AbstractResponseProcess，AbstractRequestProcess已经对各种事件进行了区分，到时候只要实现相应方法的实现就可以了，在实现类里面做真正的业务
	DefaultMessageService主要是为了返回AbstractResponseProcess，AbstractRequestProcess的实现类
	并且在weixin.properties中做好配置
	
2:在web.xml中配置好MessageServlet
    <servlet>  
        <servlet-name>messageServlet</servlet-name>  
        <servlet-class>  
            com.mawujun.message.servlet.MessageServlet  
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
    2.1和spring mvc进行整合,不需要在web.xml中配置上面的类了，只要
  
 3：  
 3:配置weixin.properties
	#实现MessageService的类配置，注意使用全限定类名
	messageService=com.mawujun.message.service.DefaultMessageService
	
	#在微信上配置服务器的死后，填写的Token的值
	Token=mawujun1234
	##########获取access_token的配置############
	#获取access_token填写client_credential
	grant_type=client_credential
	#第三方用户唯一凭证
	appid=wxc57f66afafe529c2
	#第三方用户唯一凭证密钥，即appsecret
	appsecret=b0fcc1ff54ed693eecde7ce51f68040d
	
	
	
	#AccessTokenCache接口的实现类
	#AccessTokenCache接口是用来缓存AccessToken的，可以实现这个接口，来吧AccessToken放到数据库中.默认实现DefaultAccessCache是放在缓存中的
	accessTokenCache=com.mawujun.messge.context.DefaultAccessTokenCache
4：AutoReplyService是对微信后台的自动回复的封装，只要new，然后再调用就可以了，这个基本是没有用的，因为使用了"开发者中心"后，这里就不能进行设置了
	AutoReplyService autoReplyService=new AutoReplyService();
	BaseMessage[] responseMessage= autoReplyService.getMessageAutoreply(message);