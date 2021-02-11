CREATE DATABASE IF NOT EXISTS `app`;

CREATE USER 'app'@'%' IDENTIFIED BY 'app';

GRANT ALL ON `app`.* TO 'app'@'%';

-- Flywayが起動時に「performance_schema.user_variables_by_thread 」を参照しようとしてエラーになるので、SELECT権限を付与する。
GRANT SELECT ON performance_schema.user_variables_by_thread TO 'app'@'%';