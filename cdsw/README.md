
# Repository 
Local Repository 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2020.03.01 

## 0. Architecture
- DEBUG Mode in CDSW  
- cdsw-build.sh (conda version)  



## A. Code List

**1. (spark) DEBUG Mode in CDSW for spark debug**
   
    - log4j.properties file add bellows:  
	- log4j.appender.file.threshold=DEBUG  
	- log4j.appender.file.file=/home/cdsw/spark-driver-DEBUG.log  

**2. (kubernates) CDSW DB 조회**
   
    //show all tables  
    - kubectl exec $(kubectl get pods -l role=db --no-headers=true -o custom-columns=NAME:.metadata.name) -ti -- psql -U sense -c "\dt"  

    //run "select * from jobs"  
    - kubectl exec $(kubectl get pods -l role=db --no-headers=true -o custom-columns=NAME:.metadata.name) -ti -- psql -U sense -c "select * from jobs"   

    //kubernates Pod 전체 조회
	- kubectl get pod --all-namespaces -o wide
	
	//Kubernates pod 한개 상세 조회
	- kubectl describe pod (NAME) -n (NAMESPACE)
	- kubectl describe pod 5oasdfasfdsvdsb0b -n defaut-user-17
	
	//Kubernates 시크릿파일 보기
	- kubectl get secrets internal-secrets -o yaml/json
    
    //Kubernates 시크릿파일 수정
    - kubectl edit secret internal-secrets	

**3. (conda) cdsw-build.sh (conda version)**

    echo ""  
	echo ""  
	echo "=========== 1. Conda Path               ==============="  
	echo " -> export PATH=${PATH}:/opt/conda/bin"  
	export PATH=${PATH}:/opt/conda/bin
	
	echo ""  
	echo ""  
	echo "=========== 2. Conda Channel Adjust     ==============="  
	echo " -> conda config --remove channels defaults"  
	echo " -> conda config --add channels http://repo.domain.com/conda/pkgs/main/"  
	conda config --remove channels defaults    
	conda config --add channels http://repo.domain.com/conda/pkgs/main/  
	
	echo ""  
	echo ""  
	echo "=========== 3. Conda Virtual Env Create ==============="  
    echo " -> conda create -n python3.6 python=3.6.10"  
	conda create -n python3.6 python=3.6.10  
	
    echo ""  
	echo ""  
	echo "=========== 4. Conda Library Install    ==============="  
    echo " -> conda create -n python3.6 python=3.6.10 scikit-learn=0.19.0"  
	conda create -n python3.6 python=3.6.10	scikit-learn=0.19.0  
	
	echo ""  
	echo ""  
	echo "=========== 5. Conda Virtual Env Activate ==============="  
    echo " -> conda init bash"
	conda init bash  
	
	echo " -> source /home/cdsw/.bashrc"  
	source /home/cdsw/.bashrc  
	
	echo " -> /bin/bash"   
	/bin/bash  
	
	echo " -> conda activate python3.6"
	conda activate python3.6
	
	
	echo ""  
	echo ""  
	echo "=========== 6. Conda Env View ==============="  
	echo " -> conda env list"  
	conda env list  
	
	echo " -> conda list"  
	conda list  
	
	

## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/repository.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr


