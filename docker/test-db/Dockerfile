FROM mysql:8.0.16

# Windowsでもコンテナ内でmy.cnfのパーミッションが644になるようにchmodしておく。
ADD config/my.cnf /etc/my.cnf
RUN chmod 644 /etc/my.cnf

# /docker-entrypoint-initdb.d/ に.shや.sqlを置いておくと
# mysqlのdockerイメージのENTRYPOINTで実行されるスクリプトが呼んでくれる。
# 呼ばれるのはDB未作成時のみ。
COPY docker-entrypoint-initdb.d/* /docker-entrypoint-initdb.d/
