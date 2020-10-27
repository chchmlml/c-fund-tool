FROM mysql:5.7.18

#设置免密登录
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

#将所需文件放到容器中
COPY entrypoint.sh /mysql/entrypoint.sh
COPY init.sql /mysql/init.sql
COPY privileges.sql /mysql/privileges.sql

#设置容器启动时执行的命令
CMD ["sh", "/mysql/entrypoint.sh"]