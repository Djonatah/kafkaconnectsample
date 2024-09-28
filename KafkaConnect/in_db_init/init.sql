-- create database and table
use master

IF OBJECT_ID('dbo.[test_producer]') IS NULL
BEGIN
    create database test_producer
END

use test_producer

IF OBJECT_ID('[test_producer].dbo.[client]') IS NULL
BEGIN
    create table client(
        uuid varchar(50) primary key,
        name varchar(100) not null,
        email varchar(20) not null
    )
END

-- enable cdc on test_producer database/tabase
exec sys.sp_cdc_enable client

exec sys.sp_cdc_enable_table
    @source_schema = 'dbo',
    @source_name   = 'client',
    @role_name     = ',',
    @supports_net_changes = 1

-- more on sql server cdc: https://gist.github.com/NISH1001/e1b13457f6f4515314493e7da75962f1