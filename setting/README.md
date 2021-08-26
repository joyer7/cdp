
# Setting 
Local Repository 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2020.03.01 

## 0. Architecture
- All Hosts
- Local : Local Library Server
- Process : 
**External Library Server**
  1. Download Libraries in an External Server
  2. Compress & Transport libraries to Local Library Server
**Local Library Server**
  1. Uncompress libraries files
  2. Copy files to Local Library Path


## A. Setting

**1. All Hosts**

    - Host Memory Swapping Thresholds : (host_memswap_thresholds)  
	  Warning - Specify : 200000000  
	  Critical - Never  
	- Host Process Health Test : unchecked
	
**2. Host**

    - Memory Overcommit Validation Threshold : 0.9  

**3. Atlas (Service-Wide)**

    - HBase Service(hbase_service)  
	  Atlas(Service-Wide) : checked (not activate)  
	  Hue(Service-Wide) : unchecked  
	  
	- KAFKA Service(kafka_service)  
 	  Atlas(Service-Wide) : Ranger (Checked)  
	
	- RANGER Service(ragner_service)  
	  Atlas : Ranger (Checked)  
	  
	- Enable Kerberos Authentication(kerveros.auth.enable)  
	  Atlas : Checked
	  
	- Solr Service (solr_service)  
	  Atlas : Checked (not activate)  
	  
	- HDFS SErvice (hdfs_service)  
	  Atlas : Checked (not activate)  

**4. Atlas Server**

    - Admin Password (atlas_admin) : Hahahahah1!    
	  
	- Enable File Authentication (atlas_authentication_method_file)  
	  Atlas > Atlas Server Default Group (checked)  
		  
	- Enable LDAP Authentication  (atlas_authentication_method_ldap)  
	  Atlas > Atlas Server Default Group (Checked)
	  
	- LDAP Server URL (atlas_authentication_method_ldap_url)  
	  Atlas > Atlas Server Default Group : ldap://ad.domain.com:389  
	  
	- LDAP Group-Search Base (atlas_authentication_method_ldap_groupSearchBase)  
	  Atlas > Atlas Server Default Group : OU=Groups,OU=cbdp_prod,DC=domain,DC=com  
	  
	- LDAP DN (atlas_authentication_method_ldap_base_dn)  
	  Atlas > Atlas Server Default Group : OU=cbdp_prod,DC=domain,DC=com  
	  
	- LDAP Bind DN Username (atlas_authentication_method_ldap_bind_dn)  
      Atlas > Atlas Server Default Group : CN=cbdp_binduser,OU=cbdp_prod,DC=domain,DC=com 
      (* cbdp_binduser는 AD(,OpenLdap)에  User로 추가)
	  
	- LDAP Bind DN Password (atlas_authentication_method_ldap_bind_password)
	  Atlas > Atlas Server Default Group : Hahahahah1!
	  
	- LDAP UGI Groups (atlas_authentication_method_ldap_ugi_groups)  
	  Atlas > Atlas Server Default Group (Checked)
	  
	- AD Domain Name(Only for AD) (atlas_authentication_method_ldap_ad_domain)
	  Atlas > Atlas Server Default Group : domain.com
	  
	- AD URL (atlas_authentication_method_ldap_ad_url)  
	  Atlas > Atlas Server Default Group : ldap://ad.domain.com:389  
	  
	- AD Base DN (atlas_authentication_method_ldap_ad_base_dn)  
	  Atlas > Atlas Server Default Group : OU=cbdp_prod,DC=domain,DC=com  
	  
	- AD Base DN Username (atlas_authentication_method_ldap_ad_bind_dn)  
	  Atlas > Atlas Server Default Group : CN=cbdp_binduser,OU=cbdp_prod,DC=domain,DC=com
	  
	- AD Base DN Password (atlas_authentication_method_ldap_ad_bind_password)  
	  Atlas > Atlas Server Default Group : Hahahah1!  
	  
	- LDAP Authentication Type (altas_authentication_method_ldap_type)  
	  none, ldap, ad (checked)  
	  
	- Atlas Max Heapsize (atlas_max_heap_size) : 6 GiB

**5. CDSW (Service-Wide)**

    - HBase Service (hbase_service)  
	  Atlas(Service-Wide) : HBase  checked (not activate)  
	  Hue(Service-Wide) : HBase unchecked  

    - SPARK_ON_YARN Service (spark_on_yarn_service)  
	  CDSW (Service-Wide) : Spark unchecked
	  
	- ATLAS Service (atlas_service)  
	  CDSW (Service-Wide) : Atlas Checked  
	  
	- Cloudera Data Science Workbench (cdsw.domain.config)  
	  CDSW (Service-Wide) : bigds.woorifg.com
	  
	- Enable GPU Support (cdsw.enable.gpu.config)  
	  CDSW (Service-Wide) : Checked
	  
	- Hive Service (hive_service)  
	  CDSW (Service-Wide) : Hive Checked  
	  
    - Solr Service (solr_service)  
      Atlas (Service-Wide) : CDP-INFRA-SOLR Checked (not activate)  

    - HDFS Service (hdfs_service)
      Atlas (Service-Wide) : HDFS Checked (not activate)

    - YARN Service (yarn_service)
      CDSW (Service-Wide) : YARN Checked (not activate)	

**6. (CDSW) Application**

    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never

    - Enable TLS (cdsw.enable .tls.config) 
	  Application Default Group : checked
	  
	- TLS Certificate for Internal Termination(cdsw.tls.cert.config)    
	  Application Default Group : /opt/cloudera/security/pki/tls/star_domain_com_cert.pem  
	  
	- TLS Key for internal Termination (cdsw.tls.key.config)    
	  Application Default Group : /opt/cloudera/security/pki/tls/star_domain_com_key_decrypted.pem  
	 
	- TLS root certificate authority (cdsw.tls.rootca)        
	  Application Default Group : /opt/cloudera/security/pki/tls/Chain_RootCA_Bundle.pem  
	  
**7. (CDSW) Docker Daemon**

    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never

    - Docker Block Device (cdsw.docker.devices.config) 
	  Dockr Daemon Default Group : 
	  /dev/sda/  
	  /dev/sdb/  
	  /dev/sdc/  
	  /dev/sdd/  
	 
**8. (CDSW) Worker**

    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never
	  
**9. (HBase) HBase REST Server**

    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never  
	  
	- Java Heap Size of HBase REST Server in Bytes (hbase_resstserver_java_heapsize)  
	  HBase Rest Server Default Group : 1536 MiB = 1.5 GiB 
	
	- Maximum Process File Descriptors  (rlimit_fds)  
	  CDP-INFRA-SOLR > Solr Server Default Group : 65536  
	  Kudu > Master Default Group : 131072

**10. (HBase) HBase Thrift Server**

    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never  
	  
	- Java Heap Size of HBase Thrift Server in Bytes (hbase_thriftserver_java_heapsize)  
	  HBase Thrift Server Default Group : 1536 MiB = 1.5 GiB 
	
	- Maximum Process File Descriptors  (rlimit_fds)  
	  CDP-INFRA-SOLR > Solr Server Default Group : 65536  
	  Kudu > Master Default Group : 131072	
	  
**11. (HBase) RegionServer**

    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never  
	  
	- Java Heap Size of HBase RegionServer Server in Bytes (hbase_regionserver_java_heapsize)  
	  HBase > RegionServer Default Group : 8 GiB 
	
	- HBase Region Server TLS/SSL Client Trust Store File(regionserver_truststore_file)  
	  HBase > RegionServer Default Group : /opt/cloudera/security/pki/tls/truststore  
	  
	- HBase Region Server TLS/SSL Client Trust Store Password(regionserver_truststore_password)
	  HBase > RegionServer Default Group : Hahahah (인증서 암호)
	  
	- Maximum Process File Descriptors (rlimit_fds)
	  CDP-INFRA-SOLR > Solr Server Default Group : 65536  
	  Kudu > Master Default Group : 131072	

**12. HBase (Service-Wide)**  

    - Enable Atlas Hook (hbase_atlas_hook_enable)  
      HBase (Service-Wide) Checked  

    - HBase Secure Authentication (hbase_security_authentication)
      HBase (Service-Wide) : simple , kerberos (Checked) 커버로스 사용 하는 경우  

    - HBase Secure Authorization (hbase_security_authorization)  	  
      HBase (Service-Wide) Checked
	  
	- HBase Thrift Authentication (hbase_thriftserver_security_authentication)  
	  HBase (Service-Wide) : none, auth, auth-int, auth-conf (checked)
	  
	- Ranger Service (ranger_service)
	  HBase (Service-Wide) : Ranger Checked  
	  
	- Zookeeper Service (zookeeper_service) (CDP-INFRA-SOLR, HBase, HDFS, Hive, Hive on Tez, Hue, Kafka, Oozie, Ranger RMS, YARN, YARN Queue Manager)  
	  CDP-INFRA-SOLR(Service-Wide) : ZooKeeper Checked (Not Activate)
	  
	- HDFS Service (hdfs_service) (Atlas, CDP-INFRA-SOLR, CDSW, HBase, Hive, Hive on Tez, Hue, Impala, Kafka, Kudu, Ranger, YARN) 
	  Atlas (Service-Wide) : HDFS Checked (Not Activate)
	  
**13. (Hadoop) DataNode**  
   
    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  Activity Monitor Default Group : Warning - Sepcify - 200MB, Critical Never
	  HBase > HBase REST Server Default Group: Warning - Sepcify - 300MB, Critical Never   
	  
	- DataNode Failed Volumes Tolerated (hfs_datanode_failed_volumes_tolerated)  
	  HDFS > DataNode Default Group : 6
	  
	- DataNode Data Directory (dfs_data_dir_list)  
	  HDFS > DataNode Default Group  
	  /data01/dfs/dn  
	  /data02/dfs/dn  
	  /data03/dfs/dn  
	  /data04/dfs/dn  
	  /data05/dfs/dn  
	  /data06/dfs/dn  
	  /data07/dfs/dn  
	  /data08/dfs/dn  
	  /data09/dfs/dn  
	  /data10/dfs/dn  
	  /data11/dfs/dn  
	  /data12/dfs/dn  
	  
    - Enable Health Alerts for this Role(enable_alerts)  
	  HDFS > DataNode Default Group  : Checked
	  
	- DataNode Transceiver Port(dfs_datanode_port)  
	  HDFS > DataNode Default Group : 1004  
	  
	- DataNode HTTP Web UI Port (dfs_datanode_http_port)  
	  HDFS > DataNode Default Group : 1006  
	  
	- Java Heap Size of DataNode in Bytes(datanode_java_heapsize)  
	  HDFS > DataNode Default Group : 10 GiB  
	  
	- Maximum Memory Used for Caching  
	  HDFS > DataNode Default Group : 8 GiB   
	
	- DataNode Data Directory Permissions (dfs_datanode_data_dir_perm)
	  HDFS > DataNode Default Group : 700
	  
	- HEap Dump Directory Free Space Monitoring Absolute Thresholds (heap_dump_directory_free_space_absolute_thresholds)
	  HDFS > DataNode Default Group, Failover Controller Default Group, HttpFS Default Group, JournalNOde Default Group, NFS Gateway Default Group, NameNoded Default Group, SecondaryNameNode Default Group   
	  => Warning - Specify 15 GiB, Critical - Specify 5 GiB  
	  Impala > Coordinator, Impala Catalog Server Default Group, Impala Daemon Default Group, Impala StateStore Default Group  
	  => Warning - Specify 5 GiB, Critical - Specify 3 GiB

    - Maximum Process File Descriptors (rlimit_fds)
      CDP-INFRA-SOLR > Solr Server Default Group : 65536
      Kudu > Master Default Group, Tablet Server Default Group : 131072	  
	  

**14. (Hadoop) Failover Controller**  
 
    - Process Swap Memory Thresholds (process_swap_memory_thresholds)  
	  Cloudera Management Service > Activity Monitor Default Group
	  => Warning - Specify 200 MiB, Critical Never 
      HBase REST Server Default Group  
	  => Warning - Specify 300 MiB, Critical Never

    - Heap Dump Directory Free Space Monitoring Absolute Thresholds  
      HDFS > DataNode, Failover Controller, HttpFS, JournalNode, NFS, NameNode, SecondaryNameNOde  
	  => Warning - Specify 15 GiB, Critical - Specify 5 GiB  
      Impala > Coordinator, Impala Catalog Server/Impala Daemon/Impala StateStore Default Group  
      => Warning - Specify 5 GiB, Critical - Specify 3 GiB  	  
	
	- Maximum Process File Descriptors  
	  + CDP-INFRA-SOLR > Solr Server Default Group
	  + HBase > HBase Rest Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/BFS Gateway/NameNode/SecondaryNameNode Default Group
	  + Hive > Hive  Metastore Server/HiveServer2/WebHCat Server Default Group  
	  + Hive on Tez > HiveServer2 Defauly Group  
	  + Oozie > Oozie Server Default Group  
	  + Ranger > Ranger Admin/Ranger Tagsync/Ranger Usersync Default Group  
	  => 65536
	  
	  Kudu > Master/Tablet Server Default Group
	  => 131072
	  
**15. (Hadoop) HttpFS**  	  
	
	- Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  + Cloudera Management Service > Activity Monitor/Alert Publisher/Event Server/Host Monitor/Navigator Audit Server/Navigator Metadata Server/Reports Manager/Service + Monitor/Telemetry Publisher Default Group  
      + Atlas > Atlas Server Default Group  
      + CDP-INFRA-SOLR > Solr Server Default Group  
	  + CDSW > Application/Docker Daemon/Master/Worker Default Group  
	  + Hue > Hue Server/Kerberos Ticket Renewer Default Group  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group
	  + Kudu > Master/Tablet Default Group  
	  + Spark > History  Server (cputil)  
	  + YARN > JobHistory Server/NodeManager/ResourceManager Default Group  
	  + YARN Queue Manager > YARN Queue Manager Store(cputil)/YARN Queue Manager Webapp(cputil)  
	  => Warning - Specify 200 MiB, Critical Never
	  
	  + HBase > HBase REST Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS GAteway/NameNode/SecondaryNameNode Default Group  
	  => Warning - Specify 300 MiB, Critical Never
	  
	- HttpFS TLS/SSL Server JKS Keystore File Location (httpfs_https_keystore_file)  
      HDFS > HttpFS Default Group : /opt/cloudera/security/pki/tls/star_domain_com_cert.jks  

	- HttpFS TLS/SSL Server JKS Keystore File Password (httpfs_https_keystore_password)  
      HDFS > HttpFS Default Group : Hahaha1! (인증서비밀번호)

    - HttpFS TLS/SSL Client Trust Store File (httpfs_https_truststore_file)  	 
	  HDFS > HttpFS Default Group : /opt/cloudera/security/pki/tls/truststore  
	  
	- HttpFS TLS/SSL Client Trust Store Password (httpfs_https_truststore_password) 
	  HDFS > HttpFS Default Group : Hahaha1! (인증서비밀번호)  
	
	- Heap Dump Directory Free Space Monitoring Absolute Thresholds(heap_dump_directory_free_space_absolute_thresholds)  
	  HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS Gateway/NamaNode/SecondaryNameNode Default Group
      => Warning - Specify 15 GiB, Critical Specify 5 GiB	
	  
	  Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group  
	  => Warning - Specify 5 GiB, Critical Specify 3 GiB	
	  
	- Maximum Process File Descriptors (rlimit_fds)  
	  CDP-INFRA-SOLR > Solr Server Default Group
	  HBase > HBase Rest Server/HBase Thrift Server/Master/RegionServer Default Group
	  HDFS > DataNode/Failover Controller/HttpFS/JournalNode/BFS Gateway/NameNode/SecondaryNameNode Default Group
	  Hive > Hive  Metastore Server/HiveServer2/WebHCat Server Default Group  
	  Hive on Tez > HiveServer2 Defauly Group  
	  Oozie > Oozie Server Default Group  
	  Ranger > Ranger Admin/Ranger Tagsync/Ranger Usersync Default Group  
	  => 65536
	  
	  Kudu > Master/Tablet Server Default Group
	  => 131072

**15. (Hadoop) HttpFS**  	  
	
	- Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  + Cloudera Management Service > Activity Monitor/Alert Publisher/Event Server/Host Monitor/Navigator Audit Server/Navigator Metadata Server/Reports Manager/Service Monitor/Telemetry Publisher Default Group  
      + Atlas > Atlas Server Default Group  
      + CDP-INFRA-SOLR > Solr Server Default Group  
	  + CDSW > Application/Docker Daemon/Master/Worker Default Group  
	  + Hue > Hue Server/Kerberos Ticket Renewer Default Group  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group
	  + Kudu > Master/Tablet Default Group  
	  + Spark > History  Server (cputil)  
	  + YARN > JobHistory Server/NodeManager/ResourceManager Default Group  
	  + YARN Queue Manager > YARN Queue Manager Store(cputil)/YARN Queue Manager Webapp(cputil)  
	  => Warning - Specify 200 MiB, Critical Never
	  
	  + HBase > HBase REST Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS GAteway/NameNode/SecondaryNameNode Default Group  
	  => Warning - Specify 300 MiB, Critical Never

    - JournalNode Edits Directory (dfs_journalnode_edits_dir)  
	  + HDFS > JournalNode Default Group : /hadoop/jn
	  
	- Java Heap Size of JournalNode in Bytes
	  + HDFS > JournalNode Default Group : 4 GiB
	  
	- Heap Dump Directory Free Space Monitoring Absolute Thresholds(heap_dump_directory_free_space_absolute_thresholds)  
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS Gateway/NamaNode/SecondaryNameNode Default Group
      => Warning - Specify 15 GiB, Critical Specify 5 GiB	
	  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group  
	  => Warning - Specify 5 GiB, Critical Specify 3 GiB	
	  
	- Maximum Process File Descriptors (rlimit_fds)  
	  + CDP-INFRA-SOLR > Solr Server Default Group
	  + HBase > HBase Rest Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/BFS Gateway/NameNode/SecondaryNameNode Default Group
	  + Hive > Hive  Metastore Server/HiveServer2/WebHCat Server Default Group  
	  + Hive on Tez > HiveServer2 Defauly Group  
	  + Oozie > Oozie Server Default Group  
	  + Ranger > Ranger Admin/Ranger Tagsync/Ranger Usersync Default Group  
	  => 65536
	  
	  + Kudu > Master/Tablet Server Default Group
	  => 131072

**16. (Hadoop) NFS Gateway** 	 
	
    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  + Cloudera Management Service > Activity Monitor/Alert Publisher/Event Server/Host Monitor/Navigator Audit Server/Navigator Metadata Server/Reports Manager/Service Monitor/Telemetry Publisher Default Group  
      + Atlas > Atlas Server Default Group  
      + CDP-INFRA-SOLR > Solr Server Default Group  
	  + CDSW > Application/Docker Daemon/Master/Worker Default Group  
	  + Hue > Hue Server/Kerberos Ticket Renewer Default Group  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group
	  + Kudu > Master/Tablet Default Group  
	  + Spark > History  Server (cputil)  
	  + YARN > JobHistory Server/NodeManager/ResourceManager Default Group  
	  + YARN Queue Manager > YARN Queue Manager Store(cputil)/YARN Queue Manager Webapp(cputil)  
	  => Warning - Specify 200 MiB, Critical Never
	  
	  + HBase > HBase REST Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS GAteway/NameNode/SecondaryNameNode Default Group  
	  => Warning - Specify 300 MiB, Critical Never

	- Heap Dump Directory Free Space Monitoring Absolute Thresholds(heap_dump_directory_free_space_absolute_thresholds)  
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS Gateway/NamaNode/SecondaryNameNode Default Group
      => Warning - Specify 15 GiB, Critical Specify 5 GiB	
	  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group  
	  => Warning - Specify 5 GiB, Critical Specify 3 GiB	  
	  
	- Maximum Process File Descriptors (rlimit_fds)  
	  + CDP-INFRA-SOLR > Solr Server Default Group
	  + HBase > HBase Rest Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/BFS Gateway/NameNode/SecondaryNameNode Default Group
	  + Hive > Hive  Metastore Server/HiveServer2/WebHCat Server Default Group  
	  + Hive on Tez > HiveServer2 Defauly Group  
	  + Oozie > Oozie Server Default Group  
	  + Ranger > Ranger Admin/Ranger Tagsync/Ranger Usersync Default Group  
	  => 65536
	  
	  + Kudu > Master/Tablet Server Default Group
	  => 131072
	  

**17. (Hadoop) NameNode** 	 
	
    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  + Cloudera Management Service > Activity Monitor/Alert Publisher/Event Server/Host Monitor/Navigator Audit Server/Navigator Metadata Server/Reports Manager/Service Monitor/Telemetry Publisher Default Group  
      + Atlas > Atlas Server Default Group  
      + CDP-INFRA-SOLR > Solr Server Default Group  
	  + CDSW > Application/Docker Daemon/Master/Worker Default Group  
	  + Hue > Hue Server/Kerberos Ticket Renewer Default Group  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group
	  + Kudu > Master/Tablet Default Group  
	  + Spark > History  Server (cputil)  
	  + YARN > JobHistory Server/NodeManager/ResourceManager Default Group  
	  + YARN Queue Manager > YARN Queue Manager Store(cputil)/YARN Queue Manager Webapp(cputil)  
	  => Warning - Specify 200 MiB, Critical Never	  
	  
	- NameNode Data directories (dfs_name_dir_list)  
      + HDFS > NameNode Default Group  
      => /hadoop/nn1  
      => /hadoop/nn2  	  
	  
	- NameNode Nameservice (dfs_federation_namenode_nameservice)
      + HDFS > NameNode(cpmast01)/NameNode(cpmast02)  
      => bigclst-prd  	  

    - Quorum-based Storage Journal name(dfs_namenode_quorum_journal_name)  
	  + HDFS > NameNode(cpmast01)/NameNode(cpmast02)  
      => bigclst-prd  	  
	  
	- Enable Automati Failover (autofailover_enabled)  
	  + HDFS > NameNode(cpmast01)/NameNode(cpmast02) : checked
	  
	- NameNode Handler Count
	  + HDFS > NameNode Default Group : 75
	  
	- NameNode Service Handler Count
	  + HDFS > NameNode Default Group : 75

    - NameNode Service RPC Port (dfs_namenode_servicerpc_address)
      + HDFS > NameNode Default Group : 8022
	  
	- Java Heap Size of NameNode in Bytes  
	  + HDFS > NameNode Default Group : 10 GiB
	  
	- HDFS NameNode TLS/SSL Client Trust Store File  
	  + HDFS > NameNode Default Group : /opt/cloudera/security/pki/tls/truststore 
	  
	- HDFS NameNode TLS/SSL Client Trust Store Password  
	  + HDFS > NameNode Default Group : Hahaha (인증서암호)
	
	- Heap Dump Directory Free Space Monitoring Absolute Thresholds(heap_dump_directory_free_space_absolute_thresholds)  
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS Gateway/NamaNode/SecondaryNameNode Default Group
      => Warning - Specify 15 GiB, Critical Specify 5 GiB	
	  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group  
	  => Warning - Specify 5 GiB, Critical Specify 3 GiB	  
	  
	- Maximum Process File Descriptors (rlimit_fds)  
	  + CDP-INFRA-SOLR > Solr Server Default Group
	  + HBase > HBase Rest Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/BFS Gateway/NameNode/SecondaryNameNode Default Group
	  + Hive > Hive  Metastore Server/HiveServer2/WebHCat Server Default Group  
	  + Hive on Tez > HiveServer2 Defauly Group  
	  + Oozie > Oozie Server Default Group  
	  + Ranger > Ranger Admin/Ranger Tagsync/Ranger Usersync Default Group  
	  => 65536
	  
	  + Kudu > Master/Tablet Server Default Group
	  => 131072
	  
**18. (Hadoop) SecondaryNameNode** 	 
	
    - Process Swap Memory Thresholds (process_swap_memory_thresholds)
	  + Cloudera Management Service > Activity Monitor/Alert Publisher/Event Server/Host Monitor/Navigator Audit Server/Navigator Metadata Server/Reports Manager/Service Monitor/Telemetry Publisher Default Group  
      + Atlas > Atlas Server Default Group  
      + CDP-INFRA-SOLR > Solr Server Default Group  
	  + CDSW > Application/Docker Daemon/Master/Worker Default Group  
	  + Hue > Hue Server/Kerberos Ticket Renewer Default Group  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group
	  + Kudu > Master/Tablet Default Group  
	  + Spark > History  Server (cputil)  
	  + YARN > JobHistory Server/NodeManager/ResourceManager Default Group  
	  + YARN Queue Manager > YARN Queue Manager Store(cputil)/YARN Queue Manager Webapp(cputil)  
	  => Warning - Specify 200 MiB, Critical Never	  
	  	
	- HDFS Checkpoint directories (fs_checkpoint_dir_list)  
      + HDFS > SecondaryNameNode Default Group  
      => /hadoop/nn1  

    - Java Heap Size of SecondaryNameNode in Bytes  
	  + HDFS > SecondaryNameNode Default Group : 5182MiB = 5.06 GiB

    - Heap Dump Directory Free Space Monitoring Absolute Thresholds(heap_dump_directory_free_space_absolute_thresholds)  
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/NFS Gateway/NamaNode/SecondaryNameNode Default Group
      => Warning - Specify 15 GiB, Critical Specify 5 GiB	
	  
	  + Impala > Coordinator/Impala Catalog Server/Impala Daemon/Impala StateStore Default Group  
	  => Warning - Specify 5 GiB, Critical Specify 3 GiB	  
	  
	- Maximum Process File Descriptors (rlimit_fds)  
	  + CDP-INFRA-SOLR > Solr Server Default Group
	  + HBase > HBase Rest Server/HBase Thrift Server/Master/RegionServer Default Group
	  + HDFS > DataNode/Failover Controller/HttpFS/JournalNode/BFS Gateway/NameNode/SecondaryNameNode Default Group
	  + Hive > Hive  Metastore Server/HiveServer2/WebHCat Server Default Group  
	  + Hive on Tez > HiveServer2 Defauly Group  
	  + Oozie > Oozie Server Default Group  
	  + Ranger > Ranger Admin/Ranger Tagsync/Ranger Usersync Default Group  
	  => 65536
	  
	  + Kudu > Master/Tablet Server Default Group
	  => 131072
	  
	  
**18. (Hadoop) HDFS (Service-Wide)** 	 
	
    - HDFS Service Advanced Configuration Snippet (safety Valve) for ranger-hdfs-security.xml (ranger_security_safety_valve)  
      + HDFS (Service-Wide)  
      => Name : ranger.plugin.hdfs.chained.services, Value : cm_hive 
      => Name : ranger.plugin.hdfs.chained.services.cm_hive.impl, Value : org.apache.ranger.chainedplugin.hdfs.hive.RangerHdfsHiveChainedPlugin 
	  
    - Superuser Group 
	  + HDFS(service-Wide) : supergroup,cbdp_cdh_adms   
	  
	- Hadoop User Group Mapping LDAP URL  
	  + HDFS (Service-Wide) : ldap://ad.domain.com:389  
	  
	- Hadoop User Group Mapping LDAP Bind User Distinguished Name        
	  + HDFS (Service-Wide) : CN=cbdp_binduser,OU=Users,OU=cbdp_prd,DC=domain,DC=com
	  
	- Hadoop User Mapping LDAP Bind User Password  
	  + HDFS (service-Wide) : Hahahaha (cbdp_binduser의 비번)  

    - Hadoop User Group Mapping Search Base(hadoop_group_mapping_ldap_base)  
	  + HDFS (Service-Wide) : OU=Groups,OU=cbdp_prd,DC=domain,DC=com  
	
	- Hadoop Secure Authentication   
	  + HDFS (Service-Wide) : simple, kerberos (Checked)  
	
	- Hadoop Secure Authorization (hadoop_security_authorization)  
	  + HDFS (Service-Wide) : Checked  
	
    - Enable Ranger Authorization (enable_ranger_authorization)  
	  + HDFS (Service-Wide) : Checked  
	
    - Data Transger Encryption Algorithm  
      + HDFS (Service-Wide) : 3des, rc4, AES/CTR/NoPadding (Checked)  
	  
	- Trusted Kerberos Realms(trusted_realms)
	  + HDFS (Service-Wide) : DOMAIN.COM  
	  
	- Cluster-Wide Default TLS/SSL Client Truststore Location(ssl_client_truststore_location)  
	  + HDFS (Service-Wide) : /opt/cloudera/security/pki/tls/truststore   
	  
	- Cluster-Wide Default TLS/SSL Client Truststore Password(ssl_client_truststore_password)  
	  + HDFS (Service-Wide) : Hahahah (인증서암호)

    - Zookeeper Service (zookeeper_service) 
	  + CDP-INFRA-SOLR/HBase/HDFS, Hive, Hive on Tez, Hue, Kafka, Oozie, Ranger RMS, YARN, YARN Queue Manager (Service-Wide) 
	  => ZooKeeper Checked (Not Activate)	

	  
**19. (Hive) HDFS (Service-Wide)** 	 
     
    - HBase Service (hbase_service)  
	  + Atlas / CDSW / Hive / Hive on Tez / Impala / Spark (Service-Wide)
      => HBase Checked (Not Activate)
	  
	- Hive Metastore Database Host (hive_metastore_database_host)
	  + Hive (Service-Wide) : cpmaria.woorifg.com  (가상IP로 이중화한 주소 사용 권장)

    - Hive Metastore Database Port (hive_metastore_database_port)
	  + Hive (Service-Wide) : 13306
	  
	- Hive Metastore Database Password (hive_metastore_database_password)  
      + Hive (Service-Wide) : Hahahah (MariaDB hive 계정 암호)
	  
    - Hive MEtastore TLS/SSL Client Trust Store File(ssl_client_truststore_location)  
	  + Hive (Service-Wide) : /opt/cloudera/security/pki/tls/truststore   
	  
	- CHive MEtastore TLS/SSL Client Trust Store Password(ssl_client_truststore_password)  
	  + Hive (Service-Wide) : Hahahah (인증서암호)

    - Enable LDAP Authentication for Hive Metastore (hive_metastore_enable_ldap_auth)  
	  + Hive (Service-Wide) : Checked
	  
	- LDAP URL (hive_metastore_ldap_url)  
	  + Hive (Service-Wide) : ldap://ad.domain.com:389  
	  
	- LDAP BaseDN (hive_metastore_ldap_basedn)  
	  + Hive (Service-Wide) : CN=cbdp_binduser,OU=Users,OU=cbdp_prod,DC=domain,DC=com  
	  
	- Hive Service Advanced Configuration Snippet(Safety Valve) for hive-site.xml  
      + Hive (Service-Wide) 
      => Name : hive.server2.authentication, Value : LDAP  
      => Name : hive.server2.authentication.ldap.baseDN, Value : CN=cbdp_binduser,OU=Users,OU=cbdp_prod,DC=domain,DC=com 	 
      => Name : hive.server2.authentication.ldap.url, Value : ldap://ad.domain.com:389  
	  => Name : hive.server2.authentication.ldap.Domain, Value : DOMAIN.COM

      + Hive on Tez (Service-Wide)  
	  => Name : hive.exec.failure.hooks, Value : org.apache.hadoop.hive.ql.hooks.ATSHook,org.apache.hadoop.hive.ql.hooks.HiveProtoLoggingHook  
	  => Name : hive.exec.post.hooks, Value : org.apache.hadoop.hive.ql.hooks.ATSHook,org.apache.atlas.hive.hook.HiveHook  
      => Name : hive.exec.pre.hooks, Value : org.apache.hadoop.hive.ql.hooks.ATSHook,org.apache.hive.ql.hooks.HiveProtoLoggingHook,org.apache.hadoop.hive.sql.security.authorization.plugin.DisallowTransformHook  
	  => Name : hive.server2.webui.spnego.keytab, Value : hive.keytab  
	  => Name : hive.server2.webui.spnego.principal, Value : HTTP/_HOST@DOMAIN.COM  
	  => Name : hive.users.in.admin.role, Value : *  
	  => Name : hive.parquet.write.int64.timestamp, Value : true
	  => Name : hive.server2.tez.initialize.default.sessions, Value : false  
	  => Name : hive.server2.parallel.ops.in.session, Value : true  
	  => Name : hive.resultset.use.unique.column.names, Value : false
	  => Name : hive.security.authorization.sqlstd.confwhitelist, Value : *  
	  => Name : parquet.compression, Value : SNAPPY  
	  => Name : orc.compress, Value : SNAPPY  
	  => Name : hive.tex.exec.print.summary, Value : false  
	  => Name : hive.server2.authentication, Value : LDAP  
	  => Name : hive.server2.authentication.ldap.url, Value : ldap://ad.domain.com:389  
	  => Name : hive.server2.authentication.ldap.baseDN, Value : CN=cbdp_binduser,OU=Users,OU=cbdp_prod,DC=domain,DC=com  
	  => Name : hive.server2.authentication.ldap.Domain, Value : DOMAIN.COM
	 
	- Enable LDAP Authentication for HiveServer2 (hiveserver2_enable_ldap_auth)
	  + Hive / Hive on Tez (Service-Wide) : Checked
	  
	- HiveServer2 TLS/SSL Client Trust Store File (hiverserver2_truststore_file)
	  + Hive / Hive on Tez (Service-Wide)  
	  => /opt/cloudera/security/pki/tls/truststore  
	  
	- HiveServer2 TLS/SSK Client Trust Store Password (hiverserver2_truststore_password)
	  + Hive / Hive on Tez (Service-Wide) : Hahaha (인증서암호)  

    - LDAP URL  
	

## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/repository.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr


