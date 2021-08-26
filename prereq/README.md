
# Repository 
Local Repository 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2021.04.01 

## 0. Prerequisite Syllabus
1. OS Configuration
2. Passwordless-SSH
3. Create Scripts 
**Scripts**
  3.1 ssh.sh
  3.2 rsync.sh
  
4. DNS Server
5. sysctl.conf 
6. k8s.conf
7. rc.local
8. Deploy to Hosts

## A. Details

**1. OS Configurations**
Adding hosts list at /etc/hosts

    - vi /etc/hosts
    172.10.12.1    cpdata01.site.com    cpdata1p
	172.10.12.2    cpdata02.site.com    cpdata2p
	172.10.12.3    cpdata03.site.com    cpdata3p
	172.10.12.4    cpdata04.site.com    cpdata4p
	172.10.12.5    cpdata05.site.com    cpdata5p
	172.10.12.31   cpmast01.site.com    cpmast1p
	172.10.12.32   cpmast02.site.com    cpmast2p
	172.10.12.33   cpmast03.site.com    cpmast3p
	172.10.12.41   cputil.site.com      cputil1p
	172.10.12.51   cdsw.site.com        cpcdswmp
	172.10.12.52   cdsw01.site.com      cpcdsw1p
	
**2. Passwordless-SSH **
Create .ssh in Util Server

    - ssh-keygen 
    - chmod 700 .ssh
	- cat id_rsa.pub >> authorized_key
	- chmod 600 authorized_keys
	

**3.1 ssh.sh Script **
Create ssh.sh in Util Server

    - vi ssh.sh
	
	#================================
    #!/bin/bash
	
	hosts=(
	cpdata1p
	cpdata2p
	cpdata3p
	cpdata4p
	cpdata5p
	cpmast1p
	cpmast2p
	cpmast3p
	cpcdswmp
	cpcdsw1p
	cputil1p
	)
	
	for host in "${host[@]}"
	do
	echo "======ssh.sh $host ======="
	ssh $host "$@"
	echo ""
	done
	#================================


**3.2 rsync.sh Script **
Create ssh.sh in Util Server

    - vi rsyn.c.sh
	
	#================================
	#!/bin/bash
	
	hosts=(
	cpdata1p
	cpdata2p
	cpdata3p
	cpdata4p
	cpdata5p
	cpmast1p
	cpmast2p
	cpmast3p
	cpcdswmp
	cpcdsw1p
	cputil1p
	)
	
	for host in "${host[@]}"
	do
	echo "====== rsync.sh $host ======="
	rsync -av $1 $host:$2
	echo ""
	done
	#================================


** 4. DNS **
Edit DNS Server

    - vi /etc/resolv.conf
	
	#================================
	# Site Search Here
	search site.com
	
	# AD/Ldap DNS Server
	nameserver 10.10.112.1
	
	# Company DNS Server
	nameserver 10.10.20.1
	nameserver 10.10.20.2
	#================================


** 5. sysctl.conf **
Edit sysctl.conf

    - vi /etc/sysctl.conf
	
	#================================
	# Site Search Here
	
	# hostname
	kernal.hostname=cpcdswmp
	
	vm.swappiness=1
	vm.dirty_ratio=50
	vm.dirty_background_ratio=20
	vm.overcommit_memory=1
	vm.overcommit_ratio=50
	
	net.core.somaxconn=8192
	net.core.netdev_max_backlog=8192
	net.core.rmem_max=134217728
	net.core.wmem_max=134217728
	net.core.rmem_default=524288
	net.core.wmem_default=524288
	
	net.ipv4.tcp_sack=0
	net.ipv4.tcp_dsack=0
	net.ipv4.tcp_keepalive_time=600
	net.ipv4.tcp_keepalive_probes=5
	net.ipv4.tcp_keepalive_intvl=15
	net.ipv4.tcp_fin_timeout=30
	net.ipv4.tcp_rmem= 4096 65536 134217728
	net.ipv4.tcp_wmem= 4096 65536 134217728
	net.ipv4.tcp_retries2=10
	net.ipv4.tcp_synack_retries=3
	net.ipv4.tcp_max_tw_buckets=144000
	net.ipv4.tcp_tw_reuse=1
	net.ipv4.tcp_tw_recycle=0
		
	net.ipv6.conf.all.disable_ipv6=1
	net.ipv6.conf.default.disable_ipv6=1
	
	#================================

    - sysctl -p
	- sysctl net.core.comaxconn

** 6. k8s.conf **
Edit k8s.conf

    - vi /etc/sysctl.d/k8s.conf
	
	#================================
	# k8s.conf
	
	net.bridge.bridge-nf-call-iptables=1
	net.bridge.bridge-nf-call-ip6tables=1
	net.ipv4.ip_forward=1
	net.ipv4.conf.default.forwarding=1

** 7. rc.local **

    - vi /etc/rc.local
    
	#================================
	echo never > /sys/kernel/mm/transparent_hugepage/enabled
	echo never > /sys/kernel/mm/transparent_hugepage/defrags
	
	- chmod +x /etc/rc.d/rc.local
	- systemctl enable rc-local
	- systemctl start rc-local
	
** 8. umask **

    - echo umask 022 >> /etc/profile

** 9. Deployee to Hosts **

    - ~/rsync.sh /etc/hosts /etc
    - ~/rsync.sh /root.ssh  /root
    - ~/rsync.sh /etc/resolv.conf /etc	
	- ~/rsync.sh /etc/sysctl.conf /etc
	- ~/rsync.sh /etc/sysctl.d/k8s.conf /etc/sysctl.d
	- ~/rsync.sh /etc/rc.d/rc.local /etc/rc.d/
	- ~/rsync.sh /etc/profile /etc
	
	
** 10. Service Off **
ssh.sh 로 전체 서버에 실행
    
    - bluetooth
	
	systemctl status bluetooth
    systemctl disable bluetooth
    systemctl stop bluetooth	

    - cups
	
	systemctl status cups
	systemctl disable cups
	systemctl stop cups
	
	- libvird
	
	systemctl status libvirtd
	systemctl disable libvirtd
	systemctl stop libvirtd
	
	- NIC
	
	ip link set virbr0 down
	ip link set virbr0-nic down
	ip link delete virbr0
	ip link delete virbr0-nic
	brctl delbr virbr0
	brctl delbr virbr0-nic
	
** 11. Time Service **
kudu use ntp service only.

    - chronyd
    
    systemctl stop chronyd
    systemctl disable chronyd

    - ntp (vi /etc/ntp.conf)
    systemctl start ntpd
    systemctl enable ntpd


** 12. mysql / java **

    - rsync.sh mysql-connector-java* ~/
    - rsync.sh java-1.8.0-openjdk-devel* ~/
    
	- ssh.sh yum install -y mysql-connecyor-java
	- ssh.sh yum install -y java-1.8.0-openjdk-devel
     	


## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/cdp.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr


