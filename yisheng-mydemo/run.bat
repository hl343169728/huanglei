echo off
D:
SET JAVAFANS_HOME=%cd%
SET TOMCAT_HOME=D:\apache-tomcat-7.0.59
cd %JAVAFANS_HOME%
SET MAVEN_OPTS=-Xms256m -Xmx512m -XX:ReservedCodeCacheSize=64m -XX:MaxPermSize=128m

:mvn_command
ECHO 0-生成框架的eclipse项目工程文件
ECHO 1-生成框架的eclipse项目工程文件,强制更新依赖相同版本的jar包
ECHO 2-编译框架代码,不执行测试
ECHO 3-编译框架代码,强制更新依赖相同版本的jar包 不执行测试
ECHO 4-编译框架代码,启动tomcat
ECHO 5-直接启动tomcat

set /p isopt=【选择命令】
if /i "%isopt%"=="0" goto mvn_eclipse
if /i "%isopt%"=="1" goto mvn_eclipse1
if /i "%isopt%"=="2" goto mvn_compile
if /i "%isopt%"=="3" goto mvn_compile1
if /i "%isopt%"=="4" goto mvn_tocmat
if /i "%isopt%"=="5" goto run_tocmat

echo "无效选项，请选择(0-4)"
goto mvn_command

:mvn_eclipse
	echo [INFO]  开始生成平台相关eclipse文件
	cd %JAVAFANS_HOME%
	call mvn clean eclipse:eclipse
	goto mvn_end

:mvn_eclipse1
	echo [INFO]  开始生成平台相关eclipse文件 强制更新相同版本的jar包
	cd %JAVAFANS_HOME%
	call mvn clean -U eclipse:eclipse
	goto mvn_end

:mvn_compile
	echo [INFO]  开始编译测试框架
	cd %JAVAFANS_HOME%
	call mvn clean install -Dmaven.test.skip=true
	goto mvn_end

:mvn_compile1
	echo [INFO]  开始编译测试框架
	cd %JAVAFANS_HOME%
	call mvn clean -U install -Dmaven.test.skip=true
	goto mvn_end

:mvn_tocmat
	echo [INFO]  开始编译打包 并启动web工程
	cd %JAVAFANS_HOME%
	call mvn clean -U install -Dmaven.test.skip=true
	echo [INFO]  启动tomcat
	cd %TOMCAT_HOME%\bin
	call startup.bat
	goto mvn_end

 :run_tocmat
	echo [INFO]  直接启动web工程
	cd %JAVAFANS_HOME%
	echo [INFO]  启动tomcat
	cd %TOMCAT_HOME%\bin
	call startup.bat
	goto mvn_end


:mvn_end

cd %JAVAFANS_HOME%