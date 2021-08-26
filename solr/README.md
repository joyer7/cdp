
# CDP - Solr 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2020.03.01 

## 0. Architecture
- Get solr collections  
- cdsw-build.sh (conda version)  



## A. Code List

**1. delete ranger_audits**
   
    - solrctl --zk mast02.domain.com:2181/solr-infra collection --list  
    - solrctl --zk mast02.domain.com:2181/solr-infra collection --delete ranger_audits  
    - solrctl --zk mast02.domain.com:2181/solr-infra collection --list  

    - curl -v --negotiate -u: "http://mast02.domain.com:8993/solr/admin/collections?action=CLUSTERSTATUS&wt=json"  


**2. cdsw-build.sh (conda version)**

   
	
	

## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/repository.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr


