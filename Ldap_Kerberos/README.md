
# Repository 
Local Repository 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2020.03.01 

## 0. Architecture
- Kerberos



## A. Code List

**1. AD join = Realm Join, SSSD Service**

.# realm leave -v -r -U 'appadadmin' DOMAIN.COM     (암호입력)  
.# realm join -v --computer-name='servername' --computer-ou='OU=Computers,OU=cbdp_prd,DC=DOMAIN,dc=com' -U 'appadadmin' ap1p.domain.com  (암호입력)  
'servername'은 계정관리등에서 사용하려면 hostname으로 명명

.# vi /etc/sssd/sssd.conf  
.=======================================  
use_fully_qualified_names = False  
fallback_homedir=/home/%u  
'=======================================  

.# systemctl restart sssd  

**1. LDAP Search **  
.# ldapsearch -Z -x -H ldap://ap1p.domain.com -b 'OU=cbdp_prd,DC=domain,DC=com' -D 'appadadmin@DOMAIN.COM' -W '(sAMAccountName=searchid)'  
appadadmin의 계정은 AD서버의 관리자 계정 별도로 bind_user계정을 만들어서 조회해도 됨  

LdapSearchServer.java  
.# javac LdapSearchServer.java  
.# java LdapSearchServer | grep searchid  (실행하면 AD에 등록된 searchid가 조회됨) 
 

**2. Keytab Create**  

.# ktutil  
  
ktutil: add_entry -password -p etl_user@DOMAIN.COM -k 1 -e aes256-cts  
Password for : etl_user@DOMAIN.COM:(AD암호입력)  
  
ktutil: add_entry -password -p etl_user@DOMAIN.COM -k 1 -e rc4-hmac  
Password for : etl_user@DOMAIN.COM:(AD암호입력)  
  
ktutil: l -e  

slot KVNO Principal  
---  ---  --------------------  
1     1    etl_user@DOMAIN.COM (aes256-cts-hmac-sha1-96)  
2     1    etl_user@DOMAIN.COM (arcfour-hmac)  

ktutil: wkt etl_user.keytab  
ktutil: q  

(키탭 정보 조회)
.# ls  
etl_user.keytab 
.# chown etl_user:etl_user etl_user.keytab 
.# chmod 600 etl_user.keytab  


**3. Key 연결**  

.# kinit -kt etl_usr.keytab etl_usr  
.# klist -cae  


**4. KeyTab을 통한 Kerberos Refresh **  
 
(crontab)  10 */6 * * * /bin/kinit /security/etl_usr.keytab etl_usr@domain.com




[1] https://my.cloudera.com/knowledge/Finished-Queries-show-as-Executing-in-the-Cloudera-Manager?id=71576  

  
  


**2. ./py-script/**

    - make-cran-meta.py : Create R meta file 
    - make-current-repo.py : Compare libraries
	- make-download-copy-script.py : Make download script



## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/repository.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr


