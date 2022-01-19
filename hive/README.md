
# Hive 
Local Repository 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2021.06.01 

## 0. Architecture
- beeline
- Hive Query Detail

## A. Code List

**1. Beeline**
    - beeline -u "jdbc:hive2://cpmast01.domain.com:2181,cpmast02.domain.com:2181,cpmast03.domain.com:2181/default;principal=hive/cpmaria.domain.com@WCBIG.COM;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2"

**2. query detail**

    - hdfs dfs -cat /ranger/audit/hiveServer2/20170807/* | grep <user> | grep <database>  
     It will provide you the details like the user ('reqUser'), time('evtTime'), what type of access the user has('access'), ip address('cliIP'), host('agentHost') and query ('reqData':'show databases like) etc..




## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/repository.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr
