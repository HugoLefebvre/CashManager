FROM mysql

# Environment variables
ENV MYSQL_ROOT_PASSWORD ""

# Create Database
RUN	mkdir /usr/sql
RUN	chmod 644 /usr/sql

ADD ["sql/sources.sql", "/usr/sql/sources.sql"]

RUN /etc/init.d/mysql start && \
        mysql -u root -p${MYSQL_ROOT_PASSWORD} -e "CREATE DATABASE CashManager"
