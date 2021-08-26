# Definition of Libraries
import os
import pandas as pd
import numpy as np
import time
import datetime
import timeit

from impala.dbapi import connect
from impala.util import as_pandas


# impala_query func
def impala_query(sql):

    impala_HMS_HOST=os.getenv('IMPALA_HOST','url')
	impala = connect(host=impala_HME_HOST,
	port=21050,
	use_ssl=False,
	auth_mechanism='GSSAPI',
	kerberos_service_name='impala')
	
	proc_start = time.time()
	# Time Check
	#--------------------------
	impala_cursor = impala.cursor()
	impala_cursor.execute(sql)
	df = as_pandas(impala_cursor)
	#--------------------------
	proc_end = time.time()


	columns = df.shape[1]
	nrows=len(df)
	
	# Calculation
	#--------------------------
	memory_usage = round(sum(df.memory_usage(deep=True))/1024**2,6)
	read_time = round(proc_end - proc_start,6)
	
	impala.close()
	return df


# impala_query func
def hive_query(sql):

    HIVE_HMS_HOST = os.getenv('HIVE_HS2_HOST','url')
	hive = connect(host=HIVE_HMS_HOST,
	port=10000,
	use_ssl=False,
	auth_mechanism='GSSAPI',
	kerberos_service_name='hive')
	
	proc_start = time.time()
	# Time Check
	#--------------------------
	hive_cursor = hive.cursor()
	hive_cursor.execute(sql)
	df = as_pandas(hive_cursor)
	#--------------------------
	proc_end =time.time()


	columns = df.shape[1]
	nrows=len(df)
	
	# Calculation
	#--------------------------
	memory_usage = round(sum(df.memory_usage(deep=True))/1024**2,6)
	read_time = round(proc_end - proc_start,6)
	
	hive.close()
	return df



#-----------------------------------------
# impala
#-----------------------------------------
query = 'select * from mart_tmp.mart_test1 limit 10'
impala_query(query)


query = 'select * from mart_tmp.mart_test1 limit 100'
impala_query(query)


query = 'select * from mart_tmp.mart_test1 limit 500'
impala_query(query)


query = 'select * from mart_tmp.mart_test1 limit 1000'
impala_query(query)


query = 'select * from mart_tmp.mart_test1 limit 2000'
impala_query(query)


query = 'select * from mart_tmp.mart_test1 limit 3000'
impala_query(query)


query = 'select * from mart_tmp.mart_test1 limit 5000'
impala_query(query)

query = 'select * from mart_tmp.mart_test1 limit 10000'
impala_query(query)

query = 'select * from mart_tmp.mart_test1 limit 50000'
impala_query(query)


#-----------------------------------------
# hive
#-----------------------------------------

query = 'select * from mart_tmp.mart_test1 limit 10'
hive_query(query)


query = 'select * from mart_tmp.mart_test1 limit 100'
hive_query(query)


query = 'select * from mart_tmp.mart_test1 limit 500'
hive_query(query)


query = 'select * from mart_tmp.mart_test1 limit 1000'
hive_query(query)


query = 'select * from mart_tmp.mart_test1 limit 2000'
hive_query(query)


query = 'select * from mart_tmp.mart_test1 limit 3000'
hive_query(query)


query = 'select * from mart_tmp.mart_test1 limit 5000'
hive_query(query)

query = 'select * from mart_tmp.mart_test1 limit 10000'
hive_query(query)

query = 'select * from mart_tmp.mart_test1 limit 50000'
hive_query(query)