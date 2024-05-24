# WhiteJotter

## 前端wj-vue,后端wj

## 修改配置
  1.需要安装redis<br/>
    https://blog.csdn.net/weixin_44893902/article/details/123087435<br/>
  2.wj/src/main/resources/application.properties 修改sql设置<br/>
  3.wj/pom.xml 识别maven<br/>

## 启动说明
  1.wj-vue 控制台输入npm run dev<br/>
  2.wj 运行WjApplication<br/>
  3.打开localhost:8080/index进入前台<br/>
  4.进入后台需要登录，提供admin editor test三个身份，密码均为123<br/>

## 已知Bug
  1.文章录入时Type不录入<br/>
  2.在未退出登录时结束程序后，下次启动进入登录/管理界面会白屏，清空缓存可解决<br/>
