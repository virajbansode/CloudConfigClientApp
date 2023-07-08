server.port=8080<br />

spring.application.name=cloud-config-client-app
# name give to the web service

spring.config.import=configserver:http://localhost:8888
# pointed to the config server location

management.endpoints.web.exposure.include=refresh
# actuator activated for refresh only


# to disable config server connection use
//spring.cloud.config.enabled=false


my.user.name=Sachin <br />
office.name=Sweet Office
# api properties for local use

How API Works : <br />
@Refreshscope added on bean to be refreshed when configuration is get updated at config server

POST http://localhost:8080/actuator/refresh is needed to call to refresh/read the properties from config server <br />

At config server two property files are maintained <br />
1) api specific 'cloud-config-client-app.properties' and 2) general to all 'application.properties'
my.user.name is  api specific so kept in 'cloud-config-client-app.properties' <br />
office.name is open to all config clients to read, is metained in 'application.properties'

# 
Request http://localhost:8080/details , <br />
response: Welcome Viraj Bansode, greetings from : Very sweet Office
# 



http://localhost:8888/cloud-config-client-app/default : is used to check properties at config server
out put <br />
response: {"name":"cloud-config-client-app","profiles":["default"],"label":null,"version":"1a492c420067a160868e134e3b501dbdac5be379","state":null,"propertySources":[{"name":"https://github.com/virajbansode/springConfig.git/cloud-config-client-app.properties","source":{"my.user.name":"Viraj Bansode"}},{"name":"https://github.com/virajbansode/springConfig.git/application.properties","source":{"office.name":"Very sweet Office"}}]}




